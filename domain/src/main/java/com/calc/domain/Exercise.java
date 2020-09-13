package com.calc.domain;

import java.math.BigDecimal;

public class Exercise {
    private Operation operation;
    private BigDecimal param1;
    private BigDecimal param2;

    public Exercise(Operation operation, BigDecimal param1, BigDecimal param2){
        this.operation=operation;
        this.param1=param1;
        this.param2=param2;
    }

    public BigDecimal calculate(){
        return operation.action(param1,param2);
    }

}
