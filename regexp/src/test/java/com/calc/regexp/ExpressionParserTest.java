package com.calc.regexp;

import com.calc.regexp.impl.ExpressionParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class ExpressionParserTest {

    @Test
    @DisplayName("single value")
    void singleValue() {
        Assertions.assertEquals(new BigDecimal(1), ExpressionParser.parse("1").evaluate());
    }

    @Test
    @DisplayName("trim spaces")
    void trimSpaces() {
        Assertions.assertEquals(new BigDecimal(2), ExpressionParser.parse(" 1 + 1 ").evaluate());
    }

    @Test
    @DisplayName("multiplication should go first")
    void operationsOrder() {
        Assertions.assertEquals(new BigDecimal(3), ExpressionParser.parse("1 + 1*2").evaluate());
    }

    @Test
    @DisplayName("operation in bracket should go first")
    void brackets() {
        Assertions.assertEquals(new BigDecimal(4), ExpressionParser.parse("(1+1)*2").evaluate());
    }

    @Test
    @DisplayName("negative values")
    void negativeValues() {
        Assertions.assertEquals(new BigDecimal(-4), ExpressionParser.parse("(1+1)*(-2)").evaluate());
    }

    @Test
    @DisplayName("invalid expression")
    void invalidExpression() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> ExpressionParser.parse("(1+1)*(-2)("), "you try to parse incorrect expression: (1+1)*(-2)(");
    }
}