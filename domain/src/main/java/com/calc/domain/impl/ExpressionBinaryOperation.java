package com.calc.domain.impl;

import com.calc.domain.Expression;

import java.math.BigDecimal;
import java.util.function.BinaryOperator;

public abstract class ExpressionBinaryOperation implements Expression {
    Expression left;
    Expression right;

    public ExpressionBinaryOperation(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public abstract BinaryOperator<BigDecimal> getOperation();

    @Override
    public BigDecimal evaluate(){
        return getOperation().apply(left.evaluate(), right.evaluate());
    }
}
