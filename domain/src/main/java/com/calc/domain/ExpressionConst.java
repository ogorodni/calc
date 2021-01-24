package com.calc.domain;

import java.math.BigDecimal;

public class ExpressionConst implements Expression {
    BigDecimal value;

    public ExpressionConst(BigDecimal value) {
        this.value = value;
    }

    @Override
    public BigDecimal evaluate() {
        return value;
    }
}
