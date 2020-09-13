package com.calc;

import java.math.BigDecimal;
import java.util.Scanner;
import com.calc.domain.Operation;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter exercise (E.g. 1 + 2):");
        BigDecimal param1 = scanner.nextBigDecimal();
        Operation operation = Operation.valueOf(scanner.next());
        BigDecimal param2 = scanner.nextBigDecimal();

    }
}
