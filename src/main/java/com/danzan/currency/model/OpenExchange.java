package com.danzan.currency.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpenExchange {
    @JsonIgnore
    String disclaimer;
    @JsonIgnore
    String license;
    String timestamp;
    String base;
    Map<String, String> rates;
}
