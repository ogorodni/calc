package com.calc.client.impl;

import java.io.IOException;
import java.math.BigDecimal;

public interface CalculatorService {
    BigDecimal evaluate(String expr) throws IOException, InterruptedException;
}
