package com.capgemini.junit_example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("MathUtils Test Suite")
public class MathUtilsTest {

	MathUtils mathUtils = new MathUtils();
	
	
	@Nested
	@DisplayName("Assignment 1")
	@Tag("Ass1")
	class Ass1{
		@Test
		@DisplayName("Should add two numbers")
		void testAddNumbers() {
			assertEquals(5, mathUtils.add(2, 3));
		}
		@ParameterizedTest
		@CsvSource({
		    "1,4",
		    "2,3",
		    "3,2"
		})
		@DisplayName("Should add Para two numbers")
		void testAddNumbersPara(int a, int b) {
			assertEquals(5, mathUtils.add(a, b));
		}
		@Test
		@DisplayName("Should multiply two numbers")
		void testMultiplyNumbers() {
			assertEquals(6, mathUtils.multiply(2, 3));
		}
		@Test
		@DisplayName("Should divide two numbers")
		void testDivideNumbers() {
			assertEquals(2, mathUtils.divide(8, 4));
			assertThrows(ArithmeticException.class, ()-> mathUtils.divide(8, 0));
		}
	}

	@Nested
	@DisplayName("Tests for Even Number Validation")
	@Tag("unit")
	class EvenTests {

		@Test
		@DisplayName("Should return true for even numbers")
		void testEvenNumbers() {
			assertTrue(mathUtils.isEven(2));
			assertTrue(mathUtils.isEven(4));
			assertTrue(mathUtils.isEven(6));
			assertTrue(mathUtils.isEven(8));
			assertTrue(mathUtils.isEven(10));
		}

		@Test
		@DisplayName("Should return false for odd numbers")
		void testOddNumbers() {
			assertFalse(mathUtils.isEven(1));
			assertFalse(mathUtils.isEven(3));
			assertFalse(mathUtils.isEven(5));
			assertFalse(mathUtils.isEven(7));
			assertFalse(mathUtils.isEven(9));
		}
	}

	@Nested
	@DisplayName("Tests for Prime Number Validation")
	@Tag("unit")
	class PrimeTests {

		@Test
		@DisplayName("Should return true for prime number 7")
		void testPrime() {
			assertTrue(mathUtils.isPrime(7));
		}

		@Test
		@DisplayName("Should return false for non-prime numbers")
		void testNonPrime() {
			assertFalse(mathUtils.isPrime(4));
			assertFalse(mathUtils.isPrime(1));
		}
	}

	@Nested
	@DisplayName("Factorial Computation Tests")
	@Tag("integration")
	class FactorialTests {

		@Test
		@DisplayName("Should correctly compute factorial")
		void testFactorial() {
			assertEquals(120, mathUtils.factorial(5));
			assertEquals(1, mathUtils.factorial(0));
		}

		@Test
		@DisplayName("Should throw exception for negative input")
		void testNegativeInputFactorial() {
			assertThrows(IllegalArgumentException.class, () -> mathUtils.factorial(-1));
		}
	}

	@Nested
	@DisplayName("Fibonacci Computation Tests")
	@Tag("integration")
	class FibonacciTests {

		@Test
		@DisplayName("Should correctly compute Fibonacci sequence")
		void testFibonacci() {
			assertEquals(0, mathUtils.fibonacci(0));
			assertEquals(1, mathUtils.fibonacci(1));
			assertEquals(5, mathUtils.fibonacci(5));
		}

		@Test
		@Disabled("Pending Fix: Handle negative Fibonacci inputs")
		@DisplayName("Should throw exception for negative input")
		void testNegativeInputFibo() {
			assertThrows(IllegalArgumentException.class, () -> mathUtils.fibonacci(-1));
		}
	}

	@Nested
	@DisplayName("Simple Interest Calculation Tests")
	@Tag("performance")
	class InterestTests {

		@Test
		@DisplayName("Should correctly compute simple interest")
		void testCalculateSimpleInterest() {
			assertEquals(100.0, mathUtils.calculateSimpleInterest(1000, 2, 5));
		}

		@Test
		@DisplayName("Should throw exception for negative input values")
		@DisabledIfSystemProperty(named = "skipNegativeInterestTests", matches = "true")
		void testNegativeInputs() {
			assertThrows(IllegalArgumentException.class, () -> mathUtils.calculateSimpleInterest(-1, 2, 3));
		}
	}
}