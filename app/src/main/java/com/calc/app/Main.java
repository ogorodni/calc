package com.calc.app;

import com.calc.client.impl.CalculatorService;
import org.springframework.context.support.GenericXmlApplicationContext;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:context.xml");
        ctx.refresh();
        CalculatorService calculatorService = ctx.getBean("calculatorService", CalculatorService.class);
        String expr = "1 + 2";
        System.out.println(expr + " = " + calculatorService.evaluate(expr));
    }
}
