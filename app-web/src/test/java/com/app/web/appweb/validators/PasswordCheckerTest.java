package com.app.web.appweb.validators;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PasswordCheckerTest {
	PasswordChecker passwordChecker;
	
	@BeforeEach
	void setUp() throws Exception {
		passwordChecker = new PasswordChecker();
	}

	//Not sure how to cover this test
	@Test
	void PasswordIsValidTest_ValidPassword_ReturnsTrue () {
		assertEquals(true, passwordChecker.PasswordIsValid("Password!"));
	}

	@Test
	void PasswordIsValidTest_PasswordTooShort_ReturnsFalse () {
		assertEquals(false, passwordChecker.PasswordIsValid("Pas!"));
	}

	@Test
	void PasswordIsValidTest_NoUppercaseSymbol_ReturnsFalse () {
		assertEquals(false, passwordChecker.PasswordIsValid("password1"));
	}

	@Test
	void PasswordIsValidTest_NoSpecialSymbol_ReturnsFalse () {
		assertEquals(false, passwordChecker.PasswordIsValid("Password"));
	}
}
