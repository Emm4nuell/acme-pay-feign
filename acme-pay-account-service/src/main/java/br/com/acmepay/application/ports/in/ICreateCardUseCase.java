package br.com.acmepay.application.ports.in;

import br.com.acmepay.application.domain.models.AccountDomain;
import br.com.acmepay.application.domain.models.CardVO;

public interface ICreateCardUseCase {
    void execute(AccountDomain domain);
}
