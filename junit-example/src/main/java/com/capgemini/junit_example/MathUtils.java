package com.capgemini.junit_example;

public class MathUtils {
	
	public int add(int a, int b) {
		return a+b;
	}
	public int multiply(int a, int b) {
		return a*b;
	}
	public double divide(int a, int b) {
		if(b == 0) {
			throw new ArithmeticException("Denominator cannot be zero");
		}
		return a/b;
	}

	public boolean isEven(int num) {
		return num % 2 == 0;
	}

	public double calculateSimpleInterest(double p, double r, double t) {
		if (p < 0 || r < 0 || t < 0)
			throw new IllegalArgumentException();
		return (p * r * t) / 100;
	}

	public int fibonacci(int n) {
		if (n < 0)
			throw new IllegalArgumentException();
		if (n == 0 || n == 1)
			return n;
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public boolean isPrime(int n) {
		if (n <= 1)
			return false;
		for (int i = 2; i <= Math.sqrt(n); i++)
			if (n % i == 0)
				return false;
		return true;
	}

	public int factorial(int n) {
		if (n < 0)
			throw new IllegalArgumentException("Negative number");
		int result = 1;
		for (int i = 1; i <= n; i++)
			result *= i;
		return result;
	}
}
