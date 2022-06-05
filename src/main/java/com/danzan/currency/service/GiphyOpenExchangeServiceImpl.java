package com.danzan.currency.service;

import com.danzan.currency.model.Giphy;
import com.danzan.currency.model.OpenExchange;
import com.danzan.currency.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

@Service
public class GiphyOpenExchangeServiceImpl implements GiphyOpenExchangeService {

    private final GiphyServiceImpl giphyService;
    private final OpenExchangeServiceImpl openExchangeService;

    public GiphyOpenExchangeServiceImpl(GiphyServiceImpl giphyService, OpenExchangeServiceImpl openExchangeService) {
        this.giphyService = giphyService;
        this.openExchangeService = openExchangeService;
    }

    public Optional<Response> getData(String currency) {
        if (currency.matches("[A-Za-z]{3}")) {
            ResponseEntity<OpenExchange> todayRates = openExchangeService.getTodayRates();
            ResponseEntity<OpenExchange> yesterdayRates = openExchangeService.getYesterdayRates();

            if (existRateinRates(currency, todayRates.getBody().getRates())) {
                BigDecimal yesterday = new BigDecimal(yesterdayRates.getBody().getRates().get(currency));
                BigDecimal today = new BigDecimal(todayRates.getBody().getRates().get(currency));

                String profit = whichProfit(yesterday, today);
                ResponseEntity<Giphy> giphy = giphyService.getGif(profit);
                String imgUrl = (String) giphy.getBody().getData().get("embed_url");

                return Optional.of(new Response(
                        currency,
                        profit,
                        imgUrl,
                        yesterday,
                        today
                ));
            }
        }
        return Optional.empty();
    }

    private Boolean existRateinRates(String rate, Map<String, String> rates) {
        return rates.containsKey(rate);
    }

    private String whichProfit(BigDecimal yesterday, BigDecimal today) {

        return (today.compareTo(yesterday) >= 0) ? "rich" : "broke";
    }
}
