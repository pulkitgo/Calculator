package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public double sqrt ( double x){
        return Math.sqrt(x);
    }

    public double factorial ( double x){
        if (x < 0) throw new IllegalArgumentException("Negative not allowed");

        long res = 1;
        for (int i = 2; i <= x; i++) {
            res *= i;
        }
        return res;
    }

    public double ln ( double x){
        if (x <= 0) throw new IllegalArgumentException("x must be positive");
        return Math.log(x);
    }

    public double power ( double x, double b){
        return Math.pow(x, b);
    }
    public static void main(String[] args)
    {
        Main calculator = new Main();
        System.out.println("sqrt(16) = " + calculator.sqrt(16));
        System.out.println("factorial(5) = " + calculator.factorial(5));
        System.out.println("ln(10) = " + calculator.ln(10));
        System.out.println("power(2,3) = " + calculator.power(2,3));
    }
}