package com.danzan.currency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CurrencyController {

    @RequestMapping("/")
    public String getPage() {
        return "index.html";
    }

}
