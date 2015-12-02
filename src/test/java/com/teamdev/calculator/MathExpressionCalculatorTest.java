package com.teamdev.calculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MathExpressionCalculatorTest {

    private final MathExpressionCalculator calculator = new MathExpressionCalculator();


    @Test
    public void testMathExpressionWithSingleNumberCalculation() throws CalculationError {
        assertEquals("result of 1 must be ", 1.0,
                calculator.calculate("1"), 0.01);
        assertEquals("result of 1.0 must be ", 1.0,
                calculator.calculate("1.0"), 0.01);
        assertEquals("result of 55 must be ", 55.0,
                calculator.calculate("55"), 0.01);
        assertEquals("result of 55.33 must be ", 55.33,
                calculator.calculate("55.33"), 0.01);
    }

    @Test
    public void testMathExpressionWithBinaryOperators() throws CalculationError {
        assertEquals("result of 1 + 2", 3.0,
                calculator.calculate("1 + 2"), 0.01);
        assertEquals("result of 1 + 2 * 3 ^ 4 must be ", 163.0,
                calculator.calculate("1 + 2 * 3 ^ 4"), 0.01);

    }

}
