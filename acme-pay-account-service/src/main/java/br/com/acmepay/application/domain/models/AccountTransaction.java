package br.com.acmepay.application.domain.models;

import br.com.acmepay.application.ports.out.ITransactionKafkaCustumer;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class AccountTransaction {

    private Integer origem;
    private Integer desu;
    private BigDecimal alor;
    private LocalDateTime data_hora;

    public void transaction(ITransactionKafkaCustumer custumer){

        custumer.transaction(this);

    }
}
