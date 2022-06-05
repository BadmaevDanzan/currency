package com.danzan.currency.client;

import com.danzan.currency.model.Giphy;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GiphyClientTest {

    @Autowired
    GiphyClient giphyClient;


    @Test
    @DisplayName("Получаем url гифки с сервиса Giphy")
    public void getGif() {
        ResponseEntity<Giphy> giphyResponseEntity = giphyClient.getGif("0", "rich");
        assertThat(giphyResponseEntity.getStatusCodeValue()).isEqualTo(HttpStatus.SC_OK);
        assertThat(giphyResponseEntity.getBody().getData().get("embed_url")).isNotNull();
    }
}