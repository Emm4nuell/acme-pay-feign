package br.com.acmepay.application.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardVO {
    private String document;
    private BigDecimal salary;
    private BigDecimal limit;
}
