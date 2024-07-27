package br.com.acmepay.adapters.input;

import br.com.acmepay.application.domain.model.CustomerDomain;
import br.com.acmepay.application.ports.in.ISalaryCustomerUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/customers")
@AllArgsConstructor
public class Controller {

    private final ISalaryCustomerUseCase iCreateCustomerUseCase;

    @GetMapping("find-salary/{document}")
    ResponseEntity<BigDecimal> getSalary(@PathVariable(name = "document") String document){
        var domain = CustomerDomain.builder()
                .document(document)
                .build();
//        iCreateCustomerUseCase.execute(domain);
        return null;
    }
}
