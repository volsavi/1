package com.example;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    private List<String> history = new ArrayList<>();

    public BigInteger add(BigInteger a, BigInteger b) {
        BigInteger result = a.add(b);
        saveHistory("Addition", a, b, result);
        return result;
    }

    public BigInteger subtract(BigInteger a, BigInteger b) {
        BigInteger result = a.subtract(b);
        saveHistory("Subtraction", a, b, result);
        return result;
    }

    public BigInteger multiply(BigInteger a, BigInteger b) {
        BigInteger result = a.multiply(b);
        saveHistory("Multiplication", a, b, result);
        return result;
    }

    public BigInteger divide(BigInteger a, BigInteger b) {
        if (b.equals(BigInteger.ZERO)) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        BigInteger result = a.divide(b);
        saveHistory("Division", a, b, result);
        return result;
    }

    public BigInteger power(BigInteger base, int exponent) {
        BigInteger result = base.pow(exponent);
        saveHistory("Power", base, BigInteger.valueOf(exponent), result);
        return result;
    }

    public BigInteger squareRoot(BigInteger a) {
        if (a.compareTo(BigInteger.ZERO) < 0) {
            throw new ArithmeticException("Square root of negative number is not allowed");
        }
        BigInteger result = a.sqrt(); 
        saveHistory("Square Root", a, BigInteger.ZERO, result);
        return result;
    }

   
    public BigInteger factorial(int n) {
        if (n < 0) {
            throw new ArithmeticException("Factorial of negative number is not allowed");
        }
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        saveHistory("Factorial", BigInteger.valueOf(n), BigInteger.ZERO, result);
        return result;
    }


    public BigInteger modulus(BigInteger a, BigInteger b) {
        if (b.equals(BigInteger.ZERO)) {
            throw new ArithmeticException("Modulus by zero is not allowed");
        }
        BigInteger result = a.mod(b);
        if (result.compareTo(BigInteger.ZERO) < 0) {
            result = result.add(b.abs()); 
        }
        saveHistory("Modulus", a, b, result);
        return result;
    }

  
    private void saveHistory(String operation, BigInteger a, BigInteger b, BigInteger result) {
        System.out.println("Operation: " + operation + " | " + a + " % " + b + " = " + result);
    }

   
    public void printHistory() {
        for (String record : history) {
            System.out.println(record);
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose operation: add, subtract, multiply, divide, power, sqrt, factorial, modulus, history, exit");
            String operation = scanner.next().toLowerCase();

            if (operation.equals("exit")) {
                break;
            } else if (operation.equals("history")) {
                calculator.printHistory();
                continue;
            }

            System.out.print("Enter first number: ");
            BigInteger num1 = new BigInteger(scanner.next());
            BigInteger num2 = BigInteger.ZERO;

            if (!operation.equals("sqrt") && !operation.equals("factorial")) {
                System.out.print("Enter second number: ");
                num2 = new BigInteger(scanner.next());
            }

            try {
                switch (operation) {
                    case "add":
                        System.out.println("Result: " + calculator.add(num1, num2));
                        break;
                    case "subtract":
                        System.out.println("Result: " + calculator.subtract(num1, num2));
                        break;
                    case "multiply":
                        System.out.println("Result: " + calculator.multiply(num1, num2));
                        break;
                    case "divide":
                        System.out.println("Result: " + calculator.divide(num1, num2));
                        break;
                    case "power":
                        System.out.print("Enter exponent: ");
                        int exponent = scanner.nextInt();
                        System.out.println("Result: " + calculator.power(num1, exponent));
                        break;
                    case "sqrt":
                        System.out.println("Result: " + calculator.squareRoot(num1));
                        break;
                    case "factorial":
                        System.out.println("Result: " + calculator.factorial(num1.intValue()));
                        break;
                    case "modulus":
                        System.out.println("Result: " + calculator.modulus(num1, num2));
                        break;
                    default:
                        System.out.println("Invalid operation.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
