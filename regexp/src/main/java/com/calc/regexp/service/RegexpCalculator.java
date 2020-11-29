package com.calc.regexp.service;

import com.calc.calculator.Calculator;
import com.calc.regexp.impl.ExpressionParser;

import java.math.BigDecimal;

public class RegexpCalculator implements Calculator {
    @Override
    public BigDecimal evaluate(String expr) {
        return ExpressionParser.parse(expr).evaluate();
    }
}
