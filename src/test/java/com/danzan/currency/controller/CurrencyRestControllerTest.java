package com.danzan.currency.controller;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.matchesRegex;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CurrencyRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Отправляем get запрос (USD) и проверяем параметры полученные с API.")
    public void getData() throws Exception {
        mockMvc.perform(get("/api?currency=USD"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.currency", is("USD")))
                .andExpect(jsonPath("$.profit", is("rich")))
                .andExpect(jsonPath("$.imgUrl", matchesRegex("https://giphy.com/embed/..*")))
                .andExpect(jsonPath("$.yesterdayRate", is(1)))
                .andExpect(jsonPath("$.todayRate", is(1)));
    }

    @Test
    @DisplayName("Отправляем get запрос с неправильным названием валюты, которой нет в котировках.")
    public void notValidRate1() throws Exception {
        mockMvc.perform(get("/api?currency=AAA"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", matchesRegex("Неправильно введен формат или значение валюты..*")));
    }

    @Test
    @DisplayName("Отправляем get запрос с неправильным названием валюты")
    public void notValidRate2() throws Exception {
        mockMvc.perform(get("/api?currency=TEST"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", matchesRegex("Неправильно введен формат или значение валюты..*")));
    }
}