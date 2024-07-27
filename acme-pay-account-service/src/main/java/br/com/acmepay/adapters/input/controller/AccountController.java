package br.com.acmepay.adapters.input.controller;

import br.com.acmepay.adapters.input.api.IAccountResourceAPI;
import br.com.acmepay.adapters.input.api.request.AccountRequest;
import br.com.acmepay.adapters.input.api.request.AccountTransactionRequest;
import br.com.acmepay.adapters.input.api.request.CreateCardRequest;
import br.com.acmepay.adapters.input.api.response.AccountResponse;
import br.com.acmepay.adapters.input.api.response.CreateCardResponse;
import br.com.acmepay.application.domain.models.AccountDomain;
import br.com.acmepay.application.domain.models.AccountTransaction;
import br.com.acmepay.application.domain.models.CardVO;
import br.com.acmepay.application.ports.in.ICreateAccountUseCase;
import br.com.acmepay.application.ports.in.ICreateCardUseCase;
import br.com.acmepay.application.ports.in.ITransactionAccountUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RestController
@AllArgsConstructor
public class AccountController implements IAccountResourceAPI {

    private final ICreateAccountUseCase createAccountUseCase;
    private final ITransactionAccountUseCase transactionAccountUseCase;
    private final ICreateCardUseCase iCreateCardUseCase;

    @Override
    public AccountResponse create(AccountRequest request) {
        var domain = AccountDomain.builder()
                .created_at(LocalDateTime.now())
                .updated_at(null)
                .close(false)
                .agency(request.getAgency())
                .number(request.getNumber())
                .balance(request.getBalance())
                .customerDocument(request.getDocument())
                .build();
        createAccountUseCase.execute(domain);
        return AccountResponse.builder()
                .message("account created!")
                .build();
    }

    @Override
    public void accountTransaction(AccountTransactionRequest transaction) {
        var accountTransaction = AccountTransaction.builder()
                .origem(transaction.getOrigem())
                .desu(transaction.getDesu())
                .alor(transaction.getAlor())
                .data_hora(LocalDateTime.now())
                .build();
        transactionAccountUseCase.transacion(accountTransaction);
    }

    @Override
    public ResponseEntity<CreateCardResponse> createCard(String document) {
        var domain = AccountDomain.builder()
                .customerDocument(document)
                .build();
        iCreateCardUseCase.execute(domain);
        return null;
    }
}
