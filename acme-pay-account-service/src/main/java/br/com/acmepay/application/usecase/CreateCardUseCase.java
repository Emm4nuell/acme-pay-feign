package br.com.acmepay.application.usecase;

import br.com.acmepay.application.domain.models.AccountDomain;
import br.com.acmepay.application.domain.models.CardVO;
import br.com.acmepay.application.ports.in.ICreateCardUseCase;
import br.com.acmepay.application.ports.out.ICreateCardCustomer;
import br.com.acmepay.infrastructure.util.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class CreateCardUseCase implements ICreateCardUseCase {

    private final ICreateCardCustomer iCreateCardCustomer;

    @Override
    public void execute(AccountDomain domain) {
        domain.createCard(iCreateCardCustomer);
//        AccountDomain domain = new AccountDomain();
    }
}
