package com.calc.regexp;

import com.calc.calculator.Calculator;
import com.calc.regexp.service.RegexpCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class ExpressionParserTest {

    Calculator calculator = new RegexpCalculator();

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
    }

    @Test
    @DisplayName("invalid expression")
    void invalidExpression() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.evaluate("(1+1)*(-2)("), "you try to parse incorrect expression: (1+1)*(-2)(");
    }
}