package com.danzan.currency.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Giphy {
    private Map[] data;

    public Map getData() {
        return data[0];
    }
}
