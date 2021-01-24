package com.calc.domain;

import java.math.BigDecimal;
import java.util.function.BinaryOperator;

public class ExpressionBinaryOperationDivide extends ExpressionBinaryOperation {

    public ExpressionBinaryOperationDivide(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public BinaryOperator<BigDecimal> getOperation() {
        return BigDecimal::divide;
    }
}
