package org.example;

import java.util.Scanner;
import java.text.DecimalFormat;
import org.apache.commons.lang3.StringUtils;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static void printMenu() {
        int WIDTH = 35;

        System.out.println(StringUtils.center("", WIDTH, '-'));
        System.out.println("|" + StringUtils.center("MENU", WIDTH-2) + "|");
        System.out.println(StringUtils.center("", WIDTH, '-'));
        System.out.println(StringUtils.rightPad("| 1. Square Root", WIDTH-1) + "|");
        System.out.println(StringUtils.rightPad("| 2. Factorial", WIDTH-1) + "|");
        System.out.println(StringUtils.rightPad("| 3. Natural Logarithm", WIDTH-1) + "|");
        System.out.println(StringUtils.rightPad("| 4. Power", WIDTH-1) + "|");
        System.out.println(StringUtils.rightPad("| 5. Exit", WIDTH-1) + "|");
        System.out.println(StringUtils.center("", WIDTH, '-'));
    }

    private static int getInteger(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);

            if (scanner.hasNextInt()) {
                int val = scanner.nextInt();
                scanner.nextLine(); // consume the rest of the line, including the newline
                return val;
            }
            else {
                System.out.println("Enter a valid number!");
                scanner.nextLine(); // discard the invalid token/line
            }
        }
    }

    private static double getDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);

            if (scanner.hasNextDouble()) {
                double val = scanner.nextDouble();
                scanner.nextLine(); // consume the rest of the line, including the newline
                return val;
            }
            else {
                System.out.println("Enter a valid number!");
                scanner.nextLine(); // discard the invalid token/line
            }
        }
    }

    private static String formatDouble(double val) {
        DecimalFormat df = new DecimalFormat("0.##########");
        return df.format(val); // 6
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Scientific Calculator!");
        System.out.print("Press Enter to start...");
        scanner.nextLine();

        boolean exit = false;

        while (!exit) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            printMenu();

            int choice = getInteger(scanner, "Enter your choice: ");

            if  (choice == 1) {
                double number = getDouble(scanner, "Enter a number: ");
                if (number < 0) {
                    System.out.println("Cannot compute square root!\n");
                    continue;
                }
                double result = calculator.squareRoot(number);
                System.out.printf("Square Root of %s is %s\n",
                        formatDouble(number), formatDouble(result));
            }
            else if (choice == 2) {
                int number = getInteger(scanner, "Enter an integer: ");
                long result = calculator.factorial(number);
                System.out.printf("Factorial of %d is %d\n", number, result);
            }
            else if (choice == 3) {
                double number = getDouble(scanner, "Enter a number: ");
                if (number < 0) {
                    System.out.println("Cannot compute natural logarithm!\n");
                    continue;
                }
                double result = calculator.log(number);
                System.out.printf("Natural Logarithm of %s is %s\n",
                        formatDouble(number), formatDouble(result));
            }
            else if (choice == 4) {
                double base =  getDouble(scanner, "Enter the base: ");
                double exponent = getDouble(scanner, "Enter the exponent: ");
                double result = calculator.power(base, exponent);
                System.out.printf("%s raised to the power %s is %s\n",
                        formatDouble(base), formatDouble(exponent), formatDouble(result));
            }
            else {
                exit = true;
            }

            if (!exit) {
                System.out.println();
                System.out.print("Press Enter to continue...");
                scanner.nextLine();
            }
            System.out.println();
        }
    }
}