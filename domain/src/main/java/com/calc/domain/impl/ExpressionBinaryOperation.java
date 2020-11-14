package com.calc.domain.impl;

import com.calc.domain.Expression;

import java.math.BigDecimal;

public class ExpressionBinaryOperation implements Expression {
    Expression left;
    Expression right;
    Operation operation;

    public ExpressionBinaryOperation(Expression left, Expression right, Operation op) {
        this.left = left;
        this.right = right;
        this.operation = op;
    }

    @Override
    public BigDecimal evaluate() {
        return operation.action(left.evaluate(), right.evaluate());
    }
}
