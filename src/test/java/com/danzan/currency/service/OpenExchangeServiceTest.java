package com.danzan.currency.service;

import com.danzan.currency.model.OpenExchange;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OpenExchangeServiceTest {
    @Autowired
    OpenExchangeServiceImpl openExchangeService;

    @Test
    @DisplayName("Проверка на получение котировок за сегодня")
    public void getTodayRates() {
        ResponseEntity<OpenExchange> openExchangeResponseEntity = openExchangeService.getTodayRates();
        assertThat(openExchangeResponseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(openExchangeResponseEntity.getBody().getRates().get("USD")).isEqualTo("1");
    }

    @Test
    @DisplayName("Проверка на получение котировок за вчера")
    public void getYesterdayRates() {
        ResponseEntity<OpenExchange> openExchangeResponseEntity = openExchangeService.getYesterdayRates();
        assertThat(openExchangeResponseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(openExchangeResponseEntity.getBody().getRates().get("USD")).isEqualTo("1");
    }
}
