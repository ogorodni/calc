package com.calc.client.impl;
import java.io.IOException;
import java.math.BigDecimal;

public interface Client {
    BigDecimal evaluate(String expr) throws IOException, InterruptedException;
}
