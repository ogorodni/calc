package com.calc;

import java.io.IOException;
import java.math.BigDecimal;

public interface CalculatorService {
    BigDecimal evaluate(String expr) throws IOException, InterruptedException;
}
