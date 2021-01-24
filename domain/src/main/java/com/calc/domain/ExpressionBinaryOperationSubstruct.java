package com.calc.domain;

import java.math.BigDecimal;
import java.util.function.BinaryOperator;

public class ExpressionBinaryOperationSubstruct extends ExpressionBinaryOperation {

    public ExpressionBinaryOperationSubstruct(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public BinaryOperator<BigDecimal> getOperation() {
        return BigDecimal::subtract;
    }
}
