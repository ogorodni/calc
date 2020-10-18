package com.calc;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.http.HttpResponse;

public class HttpCalculatorService implements CalculatorService {
    Client client;

    public HttpCalculatorService(Client client){
        this.client=client;
    }

    @Override
    public BigDecimal evaluate(String expr) throws IOException, InterruptedException {
        HttpResponse response = client.post(expr);
        return new BigDecimal(response.body().toString());
    }
}
