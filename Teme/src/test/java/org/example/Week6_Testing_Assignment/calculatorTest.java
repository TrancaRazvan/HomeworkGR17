package org.example.Week6_Testing_Assignment;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class calculatorTest {

    @Test
    public void test_calcul_expresie_succes(){
        String expression = "10 cm + 1 m - 10 mm";
        double result = calculator.calcul(expression);
        assertEquals(1090,result);
    }
    @Test
    public void test_if_number_isNumber_true(){
        String expression = "-53";
        calculator.isNumber(expression);
        assertTrue(true, expression);
    }
    @Test
    public void test_ifNumber_isMetricUnit_false(){
        String expression = "123";
        calculator.isMetricUnit(expression);
        assertFalse(false, expression);
    }

}