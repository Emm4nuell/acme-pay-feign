package br.com.acmepay.adapters.input.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class AccountTransactionRequest {
    private Integer origem;
    private Integer desu;
    private BigDecimal alor;
    private LocalDateTime data_hora;
}
