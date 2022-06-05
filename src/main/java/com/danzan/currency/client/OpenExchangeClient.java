package com.danzan.currency.client;

import com.danzan.currency.model.OpenExchange;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "openex", url = "${feign.client.openex.url}")
public interface OpenExchangeClient {
    @RequestMapping(method = RequestMethod.GET, value = "api/latest.json" +
            "?app_id=${feign.client.openex.api_key}")
    ResponseEntity<OpenExchange> getTodayRate();

    @RequestMapping(method = RequestMethod.GET, value = "api/historical/" +
            "{date}.json" +
            "?app_id=${feign.client.openex.api_key}")
    ResponseEntity<OpenExchange> getYesterdayRate(@PathVariable("date") String date);
}
