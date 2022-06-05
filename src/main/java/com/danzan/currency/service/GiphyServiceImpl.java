package com.danzan.currency.service;

import com.danzan.currency.client.GiphyClient;
import com.danzan.currency.model.Giphy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GiphyServiceImpl implements GiphyService {

    private final GiphyClient giphyClient;

    public GiphyServiceImpl(GiphyClient giphyClient) {
        this.giphyClient = giphyClient;
    }

    public ResponseEntity<Giphy> getGif(String rate) {
        return giphyClient.getGif(
                String.valueOf(new Random().nextInt(20)),
                rate
        );
    }
}
