package com.calc.domain;

import java.math.BigDecimal;
import java.util.Scanner;

public class ExpressionImpl implements Expression {
    final BigDecimal left;
    final BigDecimal right;
    final Operation operation;

    public ExpressionImpl(String str){
        Scanner scanner = new Scanner(str);
        left = scanner.nextBigDecimal();
        operation = Operation.getOperation(scanner.next().charAt(0));
        right = scanner.nextBigDecimal();
    }

    @Override
    public BigDecimal evaluate() {
        return operation.action(left, right);
    }
}
