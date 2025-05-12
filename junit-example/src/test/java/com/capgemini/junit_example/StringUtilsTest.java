package com.capgemini.junit_example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

@DisplayName("StringUtils Test Suite")
public class StringUtilsTest {

	StringUtils stringUtils = new StringUtils();

	@Nested
	@DisplayName("Tests for Palindrome Validation")
	@Tag("unit")
	class PalindromeTests {

		@Test
		@DisplayName("Should return true for palindrome word")
		void testPalindrome() {
			assertTrue(stringUtils.isPalindrome("Madam"));
		}

		@Test
		@DisplayName("Should return false for non-palindrome word")
		void testNonPalindrome() {
			assertFalse(stringUtils.isPalindrome("Hello"));
		}

		@Test
		@DisplayName("Should return false for null input")
		void testNullPalindrome() {
			assertFalse(stringUtils.isPalindrome(null));
		}
	}

	@Nested
	@DisplayName("String Reversal Tests")
	@Tag("unit")
	class ReverseTests {

		@Test
		@DisplayName("Should correctly reverse string")
		void testReverse() {
			assertEquals("cba", stringUtils.reverse("abc"));
		}

		@Test
		@DisplayName("Should return null for null input")
		void testNullReverse() {
			assertNull(stringUtils.reverse(null));
		}
	}

	@Nested
	@DisplayName("Vowel Counting Tests")
	@Tag("integration")
	class VowelTests {

		@Test
		@DisplayName("Should correctly count vowels in a word")
		void testCountVowels() {
			assertEquals(5, stringUtils.countVowels("Education"));
		}

		@Test
		@DisplayName("Should return 0 for string without vowels")
		void testNoVowels() {
			assertEquals(0, stringUtils.countVowels("bcdfg"));
		}

		@Test
		@DisplayName("Should return 0 for null input")
		void testNullVowelCount() {
			assertEquals(0, stringUtils.countVowels(null));
		}
	}

	@Nested
	@DisplayName("Anagram Validation Tests")
	@Tag("integration")
	class AnagramTests {

		@Test
		@DisplayName("Should return true for valid anagram")
		void testValidAnagram() {
			assertTrue(stringUtils.isAnagram("Listen", "Silent"));
		}

		@Test
		@DisplayName("Should return false for non-anagram words")
		void testInvalidAnagram() {
			assertFalse(stringUtils.isAnagram("Hello", "World"));
		}

		@Test
		@DisplayName("Should return false for null input")
		void testNullAnagram() {
			assertFalse(stringUtils.isAnagram(null, "test"));
		}
	}

	@Nested
	@DisplayName("Email Validation Tests")
	@Tag("performance")
	class EmailValidationTests {

		@Test
		@DisplayName("Should return true for valid email formats")
		void testValidEmails() {
			assertTrue(stringUtils.isValid("test@example.com"));
			assertTrue(stringUtils.isValid("user123@domain.co"));
		}

		@Test
		@DisplayName("Should return false for invalid email formats")
		void testInvalidEmails() {
			assertFalse(stringUtils.isValid("invalid-email"));
		}

		@Test
		@DisplayName("Should return false for null email input")
		void testNullEmail() {
			assertFalse(stringUtils.isValid(null));
		}
	}
}