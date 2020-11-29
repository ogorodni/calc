package com.calc.antlr.service;

import com.calc.antlr.impl.AntlrCalculatorImpl;
import com.calc.calculator.Calculator;

import java.math.BigDecimal;

public class AntlrCalculator implements Calculator {
    @Override
    public BigDecimal evaluate(String expr) {
        return AntlrCalculatorImpl.evaluate(expr);
    }
}
