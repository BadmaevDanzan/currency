package com.danzan.currency.client;

import com.danzan.currency.model.OpenExchange;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@RunWith(SpringRunner.class)
public class OpenExchangeClientTest {

    @Autowired
    OpenExchangeClient openExchangeClient;

    @Test
    @DisplayName("Получаем котировки за сегодня (API OpenExchange latest.json)")
    public void getTodayRate() {
        ResponseEntity<OpenExchange> openExchangeResponseEntity = openExchangeClient.getTodayRate();
        assertThat(openExchangeResponseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.SC_OK);
        assertThat(openExchangeResponseEntity.getBody().getRates()).isNotEmpty();
    }



    @Test
    @DisplayName("Получаем котировки за вчера  (API OpenExchange historical)")
    public void getYesterdayRate() {
        String yesterday = String.valueOf(LocalDate.now().minusDays(1));

        ResponseEntity<OpenExchange> openExchangeResponseEntity = openExchangeClient.getYesterdayRate(yesterday);
        assertThat(openExchangeResponseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.SC_OK);
        assertThat(openExchangeResponseEntity.getBody().getRates()).isNotEmpty();
    }


}