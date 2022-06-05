package com.danzan.currency.service;

import com.danzan.currency.client.OpenExchangeClient;
import com.danzan.currency.model.OpenExchange;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OpenExchangeServiceImpl implements OpenExchangeService {

    private final OpenExchangeClient openExchangeClient;

    public OpenExchangeServiceImpl(OpenExchangeClient openExchangeClient) {
        this.openExchangeClient = openExchangeClient;
    }

    public ResponseEntity<OpenExchange> getTodayRates() {
        return openExchangeClient.getTodayRate();
    }

    public ResponseEntity<OpenExchange> getYesterdayRates() {
        return openExchangeClient.getYesterdayRate(
                String.valueOf(LocalDate.now().minusDays(1)));
    }


}
