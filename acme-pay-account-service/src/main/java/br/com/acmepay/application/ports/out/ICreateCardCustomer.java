package br.com.acmepay.application.ports.out;

import java.math.BigDecimal;

public interface ICreateCardCustomer {
    BigDecimal execute(String document);
}
