package br.com.acmepay.application.ports.in;

import br.com.acmepay.application.domain.models.AccountDomain;
import br.com.acmepay.application.domain.models.AccountTransaction;

public interface ITransactionAccountUseCase {
    void transacion(AccountTransaction accountTransaction);

    void createCard(String document);
}
