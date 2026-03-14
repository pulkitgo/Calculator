package org.example;

import java.util.Scanner;

public class Main {

    public double sqrt(double x) {
        return Math.sqrt(x);
    }

    public double factorial(double x) {
        if (x < 0)
            throw new IllegalArgumentException("Negative not allowed");

        long res = 1;
        for (int i = 2; i <= x; i++) {
            res *= i;
        }
        return res;
    }

    public double ln(double x) {
        if (x <= 0)
            throw new IllegalArgumentException("x must be positive");
        return Math.log(x);
    }

    public double power(double x, double b) {
        return Math.pow(x, b);
    }
//
public static void main(String[] args) {
    Main calculator = new Main();
    Scanner scanner = new Scanner(System.in);

    while (true) {
        System.out.println("Choose the operator:");
        System.out.println("1. Square Root");
        System.out.println("2. Factorial");
        System.out.println("3. Natural Log");
        System.out.println("4. Power");

        int operator = scanner.nextInt();
        double x = scanner.nextDouble();

        switch (operator) {
            case 1:
                System.out.println(calculator.sqrt(x));
                break;

            case 2:
                System.out.println(calculator.factorial(x));
                break;

            case 3:
                System.out.println(calculator.ln(x));
                break;

            case 4:
                double b = scanner.nextDouble();
                System.out.println(calculator.power(x, b));
                break;

            default:
                System.out.println("Invalid operator");
        }
    }
}
}
