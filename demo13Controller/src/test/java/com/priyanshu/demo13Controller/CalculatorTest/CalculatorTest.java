package com.priyanshu.demo13Controller.CalculatorTest;
import com.priyanshu.demo13Controller.Calculator.Calculator;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    Calculator calculator = new Calculator(); // object of Calculator class for using it in Test cases.

    @Test
    public void testAddition() {
        int result = calculator.add(2, 3);
        assertEquals(5, result);
    }

    @Test
    public void testSubtraction() {
        int result = calculator.subtract(5, 3);
        assertEquals(2, result);
    }

    @Test
    public void testMultiplication() {
        int result = calculator.multiply(2, 3);
        assertEquals(6, result);
    }

    @Test
    public void testDivision() {
        int result = calculator.divide(6, 3);
        assertEquals(3, result);
    }



}
