package br.com.acmepay.adapters.output.service;

import br.com.acmepay.adapters.output.feign.ICustomerFeignClient;
import br.com.acmepay.application.ports.out.ICreateCardCustomer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class CreateCardCustomerService implements ICreateCardCustomer {

    private final ICustomerFeignClient iCustomerFeignClient;

    @Override
    public BigDecimal execute(String document) {
        return iCustomerFeignClient.getSalary(document);
    }
}
