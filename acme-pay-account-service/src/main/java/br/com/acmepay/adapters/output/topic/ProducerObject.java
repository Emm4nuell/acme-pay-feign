package br.com.acmepay.adapters.output.topic;

import br.com.acmepay.application.domain.models.AccountTransaction;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class ProducerObject implements IProducerObject{

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void producer(AccountTransaction transaction) {
        log.info("Topic1 enviado!");
        kafkaTemplate.send("topic1", transaction);
    }
}
