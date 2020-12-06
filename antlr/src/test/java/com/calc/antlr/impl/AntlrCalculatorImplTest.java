package com.calc.antlr.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AntlrCalculatorImplTest {

    AntlrCalculatorImpl calculator = new AntlrCalculatorImpl();

    @Test
    @DisplayName("single value")
    void singleValue() {
        Assertions.assertEquals(new BigDecimal(1), calculator.evaluate("1"));
    }

    @Test
    @DisplayName("trim spaces")
    void trimSpaces() {
        Assertions.assertEquals(new BigDecimal(2), calculator.evaluate(" 1 + 1 "));
    }

    @Test
    @DisplayName("multiplication should go first")
    void operationsOrder() {
        Assertions.assertEquals(new BigDecimal(3), calculator.evaluate("1 + 1*2"));
    }

    @Test
    @DisplayName("operation in bracket should go first")
    void brackets() {
        Assertions.assertEquals(new BigDecimal(4), calculator.evaluate("(1+1)*2"));
    }

    @Test
    @DisplayName("negative values")
    void negativeValues() {
        Assertions.assertEquals(new BigDecimal(-4), calculator.evaluate("(1+1)*(-2)"));
        Assertions.assertEquals(new BigDecimal(-4), calculator.evaluate("-(1+1)*(2)"));
    }
}