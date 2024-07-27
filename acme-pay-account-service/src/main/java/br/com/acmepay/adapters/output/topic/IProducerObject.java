package br.com.acmepay.adapters.output.topic;

import br.com.acmepay.application.domain.models.AccountTransaction;

public interface IProducerObject {
    void producer(AccountTransaction transaction);
}
