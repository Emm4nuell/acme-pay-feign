package br.com.acmepay.adapters.input.api;

import br.com.acmepay.adapters.input.api.request.AccountRequest;
import br.com.acmepay.adapters.input.api.request.AccountTransactionRequest;
import br.com.acmepay.adapters.input.api.request.CreateCardRequest;
import br.com.acmepay.adapters.input.api.response.AccountResponse;
import br.com.acmepay.adapters.input.api.response.CreateCardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/accounts/")
public interface IAccountResourceAPI {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    AccountResponse create(@RequestBody AccountRequest request);

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("transaction")
    void accountTransaction(@RequestBody AccountTransactionRequest transaction);

//    @ResponseStatus(HttpStatus.OK)
    @GetMapping("create-card/{document}")
    ResponseEntity<CreateCardResponse> createCard(@PathVariable(name = "document") String document);

}
