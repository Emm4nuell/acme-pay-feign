package br.com.acmepay.application.ports.out;

import br.com.acmepay.application.domain.models.AccountTransaction;

public interface ITransactionKafkaCustumer {
    void transaction(AccountTransaction transaction);
}
