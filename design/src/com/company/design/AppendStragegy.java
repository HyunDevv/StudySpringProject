package com.company.design;

import com.company.design.strategy.EncodingStrategy;

public class AppendStragegy implements EncodingStrategy {
    @Override
    public String encode(String text) {
        return "ABCD"+text;
    }
}
