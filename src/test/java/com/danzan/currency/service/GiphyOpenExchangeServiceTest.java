package com.danzan.currency.service;

import com.danzan.currency.model.Response;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GiphyOpenExchangeServiceTest {
    @Autowired
    GiphyOpenExchangeServiceImpl giphyWithOpenExchangeService;

    @Test
    @DisplayName("Обращаемся к сервису с параметром USD и проверяем параметры полученные с клиентов.")
    public void getResponse() {
        Optional<Response> responseOptional = giphyWithOpenExchangeService.getData("USD");
        assertThat(responseOptional.get().getCurrency()).isEqualTo("USD");
        assertThat(responseOptional.get().getProfit()).isEqualTo("rich");
        assertThat(responseOptional.get().getImgUrl()).matches("https://giphy.com/embed/..*");
        assertThat(responseOptional.get().getTodayRate()).isEqualTo("1");
        assertThat(responseOptional.get().getYesterdayRate()).isEqualTo("1");
    }

    @Test
    @DisplayName("Отправляем get запрос с неправильным названием валюты, которой нет в котировках.")
    public void notValidRate2() {
        Optional<Response> responseOptional = giphyWithOpenExchangeService.getData("ZZZ");
        assertThat(responseOptional).isEmpty();
    }

    @Test
    @DisplayName("Отправляем get запрос с неправильным названием валюты")
    public void notValidRate1() {
        Optional<Response> responseOptional = giphyWithOpenExchangeService.getData("TEST");
        assertThat(responseOptional).isEmpty();
    }



}
