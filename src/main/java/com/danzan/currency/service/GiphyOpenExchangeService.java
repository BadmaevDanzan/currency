package com.danzan.currency.service;

import com.danzan.currency.model.Response;

import java.util.Optional;

public interface GiphyOpenExchangeService {
    Optional<Response> getData(String currency);
}
