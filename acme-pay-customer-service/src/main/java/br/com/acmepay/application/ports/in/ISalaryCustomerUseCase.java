package br.com.acmepay.application.ports.in;

import br.com.acmepay.application.domain.model.CustomerDomain;

import java.math.BigDecimal;

public interface ISalaryCustomerUseCase {
    BigDecimal execute(CustomerDomain customerDomain);
}
