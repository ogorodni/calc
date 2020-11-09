package com.calc.client.service;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.http.HttpResponse;

public interface Client {
    BigDecimal evaluate(String expr) throws IOException, InterruptedException;
}
