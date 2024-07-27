package br.com.acmepay.adapters.output.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;

@FeignClient(name = "customer", url = "${url.customer}")
public interface IClientCustomerFeign {

    @GetMapping("find-salary")
    BigDecimal getSalary(String document);

}
