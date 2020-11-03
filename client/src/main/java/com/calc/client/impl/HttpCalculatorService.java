package com.calc.client.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.http.HttpResponse;

public class HttpCalculatorService implements CalculatorService {
    final Client client;

    public HttpCalculatorService(Client client){
        this.client=client;
    }

    @Override
    public BigDecimal evaluate(String expr) throws IOException, InterruptedException {
        HttpResponse response = client.post(expr);
        return new BigDecimal(response.body().toString());
    }
}
