package com.danzan.currency.controller;

import com.danzan.currency.model.ErrorResponse;
import com.danzan.currency.model.Response;
import com.danzan.currency.service.GiphyOpenExchangeServiceImpl;
import feign.FeignException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class CurrencyRestController {
    private final GiphyOpenExchangeServiceImpl giphyOpenExchangeServiceImpl;


    public CurrencyRestController(GiphyOpenExchangeServiceImpl giphyOpenExchangeServiceImpl) {
        this.giphyOpenExchangeServiceImpl = giphyOpenExchangeServiceImpl;
    }


    @GetMapping
    public ResponseEntity<?> getData(@RequestParam(required = false, defaultValue = "RUB") String currency) {
        Optional<Response> response;
        try {
            response = giphyOpenExchangeServiceImpl.getData(currency.toUpperCase());
            if (response.isPresent()) {
                return ResponseEntity.ok().body(response);
            }
        } catch (FeignException e) {
            return ResponseEntity.status(522).body(new ErrorResponse(e.getMessage()));
        }
        return ResponseEntity.badRequest().body(new ErrorResponse("Неправильно введен формат или значение валюты, Ваше значение: " + currency));
    }
}
