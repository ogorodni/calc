package com.calc.app;

import com.calc.client.service.Client;
import org.springframework.context.support.GenericXmlApplicationContext;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:context.xml");
        ctx.refresh();
        Client client = ctx.getBean("client", Client.class);
        String expr = "((1+2) + 3*4 - 1)*5";
        System.out.println(expr + " = " + client.evaluate(expr));
    }
}
