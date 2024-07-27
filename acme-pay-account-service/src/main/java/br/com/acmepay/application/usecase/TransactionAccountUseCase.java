package br.com.acmepay.application.usecase;

import br.com.acmepay.application.domain.models.AccountDomain;
import br.com.acmepay.application.domain.models.AccountTransaction;
import br.com.acmepay.application.ports.in.ITransactionAccountUseCase;
import br.com.acmepay.application.ports.out.ITransactionKafkaCustumer;
import br.com.acmepay.infrastructure.util.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class TransactionAccountUseCase implements ITransactionAccountUseCase {

    private final ITransactionKafkaCustumer transactionKafkaCustumer;
    @Override
    public void transacion(AccountTransaction accountTransaction) {
        accountTransaction.transaction(transactionKafkaCustumer);
    }
}
