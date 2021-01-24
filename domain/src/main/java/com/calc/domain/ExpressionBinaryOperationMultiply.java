package com.calc.domain;

import java.math.BigDecimal;
import java.util.function.BinaryOperator;

public class ExpressionBinaryOperationMultiply extends ExpressionBinaryOperation {

    public ExpressionBinaryOperationMultiply(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public BinaryOperator<BigDecimal> getOperation() {
        return BigDecimal::multiply;
    }
}
