package com.diptam.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CurrencyConverter {

    private Long id;
    private String currency_from;
    private String currency_to;
    private String conversionMultiple;
    private BigDecimal amount;
    private BigDecimal convertedAmount;
}
