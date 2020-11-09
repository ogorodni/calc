package com.calc.client.service;

import com.calc.client.impl.HttpClientImpl;

public class HttpCalculatorService implements CalculatorService {

    private final String url;

    public HttpCalculatorService(String url) {
        this.url = url;
    }

    @Override
    public Client createClient() {
        return new HttpClientImpl(url);
    }
}
