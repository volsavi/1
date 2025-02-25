import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    private List<String> history = new ArrayList<>();

    public double add(double a, double b) {
        double result = a + b;
        saveHistory("Addition", a, b, result);
        return result;
    }

    public double subtract(double a, double b) {
        double result = a - b;
        saveHistory("Subtraction", a, b, result);
        return result;
    }

    public double multiply(double a, double b) {
        double result = a * b;
        saveHistory("Multiplication", a, b, result);
        return result;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        double result = a / b;
        saveHistory("Division", a, b, result);
        return result;
    }

    public double power(double base, double exponent) {
        double result = Math.pow(base, exponent);
        saveHistory("Power", base, exponent, result);
        return result;
    }

    public double squareRoot(double a) {
        if (a < 0) {
            throw new ArithmeticException("Square root of negative number is not allowed");
        }
        double result = Math.sqrt(a);
        saveHistory("Square Root", a, 0, result);
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
        saveHistory("Factorial", n, 0, result.doubleValue());
        return result;
    }

    public double modulus(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Modulus by zero is not allowed");
        }
        double result = a % b;
        saveHistory("Modulus", a, b, result);
        return result;
    }

    private void saveHistory(String operation, double a, double b, double result) {
        history.add(operation + " of " + a + " and " + b + " = " + result);
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
            double num1 = scanner.nextDouble();
            double num2 = 0;

            if (!operation.equals("sqrt") && !operation.equals("factorial")) {
                System.out.print("Enter second number: ");
                num2 = scanner.nextDouble();
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
                        System.out.println("Result: " + calculator.power(num1, num2));
                        break;
                    case "sqrt":
                        System.out.println("Result: " + calculator.squareRoot(num1));
                        break;
                    case "factorial":
                        System.out.println("Result: " + calculator.factorial((int) num1));
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
