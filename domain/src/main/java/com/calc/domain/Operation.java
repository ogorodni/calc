package com.calc.domain;

import java.math.BigDecimal;

public enum Operation {
    SUM{
        @Override
        public BigDecimal action(BigDecimal x, BigDecimal y) {
            return x.add(y);
        }
    },
    MULTIPLY{
        @Override
        public BigDecimal action(BigDecimal x, BigDecimal y) {
            return x.multiply(y);
        }
    },
    DIVIDE{
        @Override
        public BigDecimal action(BigDecimal x, BigDecimal y) {
            return x.divide(y);
        }
    },
    SUBSTRUCT{
        @Override
        public BigDecimal action(BigDecimal x, BigDecimal y) {
            return x.subtract(y);
        }
    };
public abstract BigDecimal action (BigDecimal x, BigDecimal y);
}
