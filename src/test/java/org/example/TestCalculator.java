package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestCalculator {
    private final Calculator calculator = new Calculator();
    private final double delta = 1E-6;

    @Nested
    class SquareRootTests
    {
        @Test
        void Test1()
        {
            double expected = 5;
            double result = calculator.squareRoot(25);
            assertEquals(expected, result, delta);
        }

        @Test
        void Test2()
        {
            double expected = 3.162277;
            double result = calculator.squareRoot(10);
            assertEquals(expected, result, delta);
        }

        @Test
        void Test3()
        {
            double expected = 8.483867;
            double result = calculator.squareRoot(71.976);
            assertEquals(expected, result, delta);
        }

        @Test
        void Test4()
        {
            double expected = 0;
            double result = calculator.squareRoot(0);
            assertEquals(expected, result, delta);
        }

        @Test
        void Test5()
        {
            double result = calculator.squareRoot(-3);
            assertTrue(Double.isNaN(result));
        }
    }

    @Nested
    class FactorialTests
    {
        @Test
        void Test1()
        {
            long expected = 120;
            long result = calculator.factorial(5);
            assertEquals(expected, result);
        }

        @Test
        void Test2()
        {
            long expected = 1;
            long result = calculator.factorial(0);
            assertEquals(expected, result);
        }

        @Test
        void Test3()
        {
            long expected = 1;
            long result = calculator.factorial(-10);
            assertEquals(expected, result);
        }
    }

    @Nested
    class NaturalLogTests
    {
        @Test
        void Test1()
        {
            double expected = 1.0;
            double result = calculator.log(Math.E);
            assertEquals(expected, result, delta);
        }

        @Test
        void Test2()
        {
            double expected = 2.302585;
            double result = calculator.log(10);
            assertEquals(expected, result, delta);
        }

        @Test
        void Test3()
        {
            double expected = Double.NEGATIVE_INFINITY;
            double result = calculator.log(0);
            assertEquals(expected, result);
        }

        @Test
        void Test4()
        {
            double result = calculator.log(-4);
            assertTrue(Double.isNaN(result));
        }
    }

    @Nested
    class PowerTests
    {
        @Test
        void Test1()
        {
            double expected = 9;
            double result = calculator.power(3, 2);
            assertEquals(expected, result, delta);
        }

        @Test
        void Test2()
        {
            double expected = 685.400203;
            double result = calculator.power(10.3, 2.8);
            assertEquals(expected, result, delta);
        }

        @Test
        void Test3()
        {
            double expected = 1;
            double result = calculator.power(134, 0);
            assertEquals(expected, result, delta);
        }

        @Test
        void Test4()
        {
            double expected = 0;
            double result = calculator.power(0, 543.22);
            assertEquals(expected, result, delta);
        }

        @Test
        void Test5()
        {
            double expected = 1;
            double result = calculator.power(0, 0);
            assertEquals(expected, result, delta);
        }

    }
}
