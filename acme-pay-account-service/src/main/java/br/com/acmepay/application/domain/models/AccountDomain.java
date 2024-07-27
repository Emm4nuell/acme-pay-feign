package br.com.acmepay.application.domain.models;

import br.com.acmepay.adapters.request.DocumentRequest;
import br.com.acmepay.application.domain.exception.BalanceToWithdrawException;
import br.com.acmepay.application.ports.out.ICheckDocumentCustomer;
import br.com.acmepay.application.ports.out.ICreateAccount;
import br.com.acmepay.application.ports.out.ICreateCardCustomer;
import br.com.acmepay.application.ports.out.ITransactionKafkaCustumer;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDomain {

    private Long id;
    private Integer number;
    private Integer agency;
    private BigDecimal balance;
    private Boolean close;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private String customerDocument;

    private static final double COEF_MIN = 0.1;
    private static final double COEF_MED = 0.3;
    private static final double COEF_MAX = 0.5;

    public void create(ICreateAccount createAccount, ICheckDocumentCustomer checkDocumentCustomer) {

        var doc = DocumentRequest.builder().document(this.customerDocument).build();
        checkDocumentCustomer.execute(doc);
        var tras = AccountTransaction.builder()
                .origem(this.getAgency())
                .desu(this.getAgency())
                .data_hora(LocalDateTime.now())
                .alor(this.getBalance())
                .build();
        createAccount.execute(this);
    }

    public CardVO createCard(ICreateCardCustomer createCardCustomer) {
        BigDecimal salary = createCardCustomer.execute(this.customerDocument);
        BigDecimal limit = BigDecimal.ZERO;
        if (salary.compareTo(new BigDecimal("10000")) == -1) {
            limit = salary.multiply(BigDecimal.valueOf(COEF_MIN));
        } else if (salary.compareTo(new BigDecimal("15000")) == -1) {
            limit = salary.multiply(BigDecimal.valueOf(COEF_MED));
        }else{
            limit = salary.multiply(BigDecimal.valueOf(COEF_MAX));
        }

        return CardVO.builder()
                .document(customerDocument)
                .salary(salary)
                .limit(limit)
                .build();
    }

    public void deposit(BigDecimal amount) {
        this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) throws BalanceToWithdrawException {
        if (this.balance.compareTo(amount) >= 0) {
            this.balance.subtract(amount);
        } else {
            throw new BalanceToWithdrawException("error withdraw");
        }
    }

    public void transaction(AccountTransaction transaction, ITransactionKafkaCustumer custumer) {


        var tras = AccountTransaction.builder()
                .origem(transaction.getOrigem())
                .desu(transaction.getDesu())
                .data_hora(LocalDateTime.now())
                .alor(transaction.getAlor())
                .build();

        // chama a interface de saida e passa o objeto (tras)
        custumer.transaction(tras);
    }
}
