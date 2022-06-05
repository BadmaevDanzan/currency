package com.danzan.currency.client;

import com.danzan.currency.model.Giphy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "giphy", url = "${feign.client.giphy.url}")
public interface GiphyClient {
    @RequestMapping(method = RequestMethod.GET, value = "v1/gifs/search" +
            "?api_key=${feign.client.giphy.api_key}" +
            "&q={searchValue}" +
            "&rating=g" +
            "&limit=1" +
            "&offset={page}" +
            "&bundle=messaging_non_clips")
    ResponseEntity<Giphy> getGif(@PathVariable("page") String page, @PathVariable("searchValue") String searchValue);
}
