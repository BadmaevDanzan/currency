package com.danzan.currency.service;

import com.danzan.currency.model.Giphy;
import org.springframework.http.ResponseEntity;

public interface GiphyService {
    ResponseEntity<Giphy> getGif(String rate);
}
