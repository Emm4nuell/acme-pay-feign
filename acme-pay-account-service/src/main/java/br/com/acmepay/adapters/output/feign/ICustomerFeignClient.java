package br.com.acmepay.adapters.output.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient(name = "customer", url = "localhost:8082/api/v1/customers/")
public interface ICustomerFeignClient {

    @GetMapping("find-salary/{document}")
    BigDecimal getSalary(@PathVariable("document") String document);

}
