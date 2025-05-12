package com.capgemini.junit_example;

import java.util.Arrays;

public class StringUtils {

	public boolean isPalindrome(String str) {
		if (str == null)
			return false;
		String rev = new StringBuilder(str).reverse().toString();
		return str.equalsIgnoreCase(rev);
	}

	public String reverse(String str) {
		return str == null ? null : new StringBuilder(str).reverse().toString();
	}

	public int countVowels(String str) {
		if (str == null)
			return 0;
		return (int) str.toLowerCase().chars().filter(c -> "aeiou".indexOf(c) >= 0).count();
	}

	public boolean isAnagram(String s1, String s2) {
		if (s1 == null || s2 == null)
			return false;
		char[] a = s1.replaceAll("\\s", "").toLowerCase().toCharArray();
		char[] b = s2.replaceAll("\\s", "").toLowerCase().toCharArray();
		Arrays.sort(a);
		Arrays.sort(b);
		return Arrays.equals(a, b);
	}

	public boolean isValid(String email) {
		if (email == null)
			return false;
		return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
	}

}
