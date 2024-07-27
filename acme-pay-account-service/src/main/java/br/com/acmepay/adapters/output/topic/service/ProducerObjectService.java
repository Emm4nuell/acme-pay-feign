package br.com.acmepay.adapters.output.topic.service;

import br.com.acmepay.adapters.output.topic.IProducerObject;
import br.com.acmepay.application.domain.models.AccountTransaction;
import br.com.acmepay.application.ports.out.ITransactionKafkaCustumer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProducerObjectService implements ITransactionKafkaCustumer {

    private final IProducerObject iProducerObject;

    @Override
    public void transaction(AccountTransaction transaction) {
        iProducerObject.producer(transaction);
    }
}
