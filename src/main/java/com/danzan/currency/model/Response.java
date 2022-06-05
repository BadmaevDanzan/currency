package com.danzan.currency.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private String currency;
    private String profit;
    private String imgUrl;
    private BigDecimal yesterdayRate;
    private BigDecimal todayRate;
}
