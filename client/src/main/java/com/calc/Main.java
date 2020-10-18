package com.calc;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:conf/context.xml");
        ctx.refresh();
        CalculatorService calculatorService = ctx.getBean("calculatorService", CalculatorService.class);
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter exercise (E.g. 1 + 2):");
//        String expr = scanner.nextLine();
        String expr = "1 + 2";
        System.out.println(expr + " = " + calculatorService.evaluate(expr));
    }
}
