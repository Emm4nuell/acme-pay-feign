package br.com.acmepay.application.usecase;

import br.com.acmepay.application.domain.model.CustomerDomain;
import br.com.acmepay.application.ports.in.ISalaryCustomerUseCase;
import br.com.acmepay.application.ports.out.ICreateCustomer;
import br.com.acmepay.infrastructure.util.UseCase;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@UseCase
@AllArgsConstructor
public class SalaryCustomerUseCase implements ISalaryCustomerUseCase {

//    private final ICreateCustomer createCustomer;

    @Override
    public BigDecimal execute(CustomerDomain customerDomain) {
        return null;
    }
}
