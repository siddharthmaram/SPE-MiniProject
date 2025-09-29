package org.example;

public class Calculator {
    double squareRoot(double number) {
        return Math.sqrt(number);
    }

    long factorial(int number) {
        if (number <= 0)
            return 1;
        return number * factorial(number - 1);
    }

    double log(double number) {
        return Math.log(number);
    }

    double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
}
