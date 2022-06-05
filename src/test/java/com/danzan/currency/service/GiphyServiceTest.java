package com.danzan.currency.service;

import com.danzan.currency.model.Giphy;
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
public class GiphyServiceTest {
    @Autowired
    GiphyServiceImpl giphyService;


    @Test
    @DisplayName("Проверка на получение url гифки с сервиса Giphy")
    public void getGif() {
        ResponseEntity<Giphy> giphy = giphyService.getGif("rich");
        assertThat(giphy.getStatusCodeValue()).isEqualTo(200);
        assertThat(giphy.getBody().getData().get("embed_url")).isNotNull();
    }
}
