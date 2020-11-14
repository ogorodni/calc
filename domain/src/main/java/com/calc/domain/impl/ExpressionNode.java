package com.calc.domain.impl;

import com.calc.domain.Expression;

import java.math.BigDecimal;

public class ExpressionNode implements Expression {
    BigDecimal value;

    public ExpressionNode(BigDecimal value) {
        this.value = value;
    }

    @Override
    public BigDecimal evaluate() {
        return value;
    }
}
