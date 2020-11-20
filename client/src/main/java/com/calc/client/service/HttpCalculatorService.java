package com.calc.client.service;

import com.calc.client.impl.Client;
import java.io.IOException;
import java.math.BigDecimal;

public class HttpCalculatorService implements CalculatorService {

    private final Client client;

    public HttpCalculatorService(String url) {
        this.client = new Client(url);
    }

    @Override
    public BigDecimal evaluate(String expr) throws IOException, InterruptedException {
        return client.post(expr);
    }
}
