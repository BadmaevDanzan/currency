package com.danzan.currency.service;

import com.danzan.currency.model.OpenExchange;
import org.springframework.http.ResponseEntity;

public interface OpenExchangeService {
    ResponseEntity<OpenExchange> getTodayRates();

    ResponseEntity<OpenExchange> getYesterdayRates();
}
