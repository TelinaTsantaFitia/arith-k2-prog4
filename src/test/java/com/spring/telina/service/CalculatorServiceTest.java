package com.spring.telina.service;

import com.spring.telina.model.CalculationRequest;
import com.spring.telina.model.CalculationResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorService();
    }

    @Test @DisplayName("10 + 5 = 15")
    void testAdd() {
        CalculationResult r = calculatorService.add(10.0, 5.0);
        assertTrue(r.isSuccess());
        assertEquals(15.0, r.getResult());
    }

    @Test @DisplayName("-3 + -7 = -10")
    void testAddNegatives() {
        assertEquals(-10.0, calculatorService.add(-3.0, -7.0).getResult());
    }

    @Test @DisplayName("10 - 3 = 7")
    void testSubtract() {
        assertEquals(7.0, calculatorService.subtract(10.0, 3.0).getResult());
    }

    @Test @DisplayName("3 - 10 = -7")
    void testSubtractNegative() {
        assertEquals(-7.0, calculatorService.subtract(3.0, 10.0).getResult());
    }

    @Test @DisplayName("4 * 3 = 12")
    void testMultiply() {
        assertEquals(12.0, calculatorService.multiply(4.0, 3.0).getResult());
    }

    @Test @DisplayName("5 * 0 = 0")
    void testMultiplyByZero() {
        assertEquals(0.0, calculatorService.multiply(5.0, 0.0).getResult());
    }

    @Test @DisplayName("10 / 2 = 5")
    void testDivide() {
        assertEquals(5.0, calculatorService.divide(10.0, 2.0).getResult());
    }

    @Test @DisplayName("7 / 2 = 3.5")
    void testDivideDecimal() {
        assertEquals(3.5, calculatorService.divide(7.0, 2.0).getResult());
    }

    @Test @DisplayName("Division par zéro : erreur")
    void testDivideByZero() {
        CalculationResult r = calculatorService.divide(10.0, 0.0);
        assertFalse(r.isSuccess());
        assertTrue(r.getErrorMessage().contains("zéro"));
    }

    @Test @DisplayName("calculate() via request : 8 + 2 = 10")
    void testCalculate() {
        CalculationResult r = calculatorService.calculate(new CalculationRequest(8.0, 2.0, "+"));
        assertTrue(r.isSuccess());
        assertEquals(10.0, r.getResult());
    }

    @Test @DisplayName("Opération inconnue : erreur")
    void testUnknownOp() {
        assertFalse(calculatorService.calculate(new CalculationRequest(8.0, 2.0, "%")).isSuccess());
    }
}