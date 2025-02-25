package com.example.calculator;

import com.example.Calculator.Calculator;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTests {

    private final Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        BigInteger a = new BigInteger("5");
        BigInteger b = new BigInteger("3");
        BigInteger result = calculator.add(a, b);
        assertEquals(new BigInteger("8"), result);
    }

    @Test
    public void testSubtract() {
        BigInteger a = new BigInteger("5");
        BigInteger b = new BigInteger("3");
        BigInteger result = calculator.subtract(a, b);
        assertEquals(new BigInteger("2"), result);
    }

    @Test
    public void testMultiply() {
        BigInteger a = new BigInteger("5");
        BigInteger b = new BigInteger("3");
        BigInteger result = calculator.multiply(a, b);
        assertEquals(new BigInteger("15"), result);
    }

    @Test
    public void testDivide() {
        BigInteger a = new BigInteger("6");
        BigInteger b = new BigInteger("3");
        BigInteger result = calculator.divide(a, b);
        assertEquals(new BigInteger("2"), result);
    }

    @Test
    public void testFactorial() {
        // Для факториала также используем BigInteger
        BigInteger n = new BigInteger("5");
        BigInteger result = calculator.factorial(n);
        assertEquals(new BigInteger("120"), result); // 5! = 120
    }

    @Test
    public void testModulus() {
        BigInteger a = new BigInteger("7");
        BigInteger b = new BigInteger("3");
        BigInteger result = calculator.modulus(a, b);
        assertEquals(new BigInteger("1"), result); // 7 % 3 = 1
    }

    // Пример с другими тестами...
}
