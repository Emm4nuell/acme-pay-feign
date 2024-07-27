package br.com.acmepay.adapters.output.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;

@FeignClient(name = "customer", url = "${url.customer}")
public interface ICustomerFeignClient {

    @GetMapping("find-salary")
    BigDecimal getSalary(String document);

}
