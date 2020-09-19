package com.calc;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.calc.domain.Exercise;
import com.calc.domain.Operation;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter exercise (E.g. 1 + 2):");
        BigDecimal param1 = scanner.nextBigDecimal();
        Operation operation = Operation.getOperation(scanner.next().charAt(0));
        BigDecimal param2 = scanner.nextBigDecimal();
        Exercise ex = new Exercise(operation, param1, param2);

        ClientImpl client = new ClientImpl("http://localhost:8080/calc");
        HttpResponse getResponse = client.get(ex);
        HttpResponse postResponse = client.post(ex);

        System.out.println(getResponse.statusCode());
        System.out.println(getResponse.body());

        System.out.println(postResponse.statusCode());
        System.out.println(postResponse.body());
    }
}
