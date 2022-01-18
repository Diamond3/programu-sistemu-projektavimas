package com.app.web.appweb.validators;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PhoneValidatorTest {
	PhoneValidator phoneValidator;
	
	@BeforeEach
	void setUp() throws Exception {
		phoneValidator = new PhoneValidator();
	}

	@Test
	void PhoneIsValidTest_ValidPhone_ReturnsTrue () {
		assertEquals(true, phoneValidator.PhoneIsValid("861234567"));
	}

	@Test
	void PhoneIsValidTest_NumberBadLenght_ReturnsFalse () {
		assertEquals(false, phoneValidator.PhoneIsValid("86123"));
	}

	@Test
	void PhoneIsValidTest_ContainsInvalidCharacters_ReturnsFalse () {
		assertEquals(false, phoneValidator.PhoneIsValid("abcd"));
	}

	@Test
	void ChangePhoneToCountryCodeTest_PhoneWithLocalCode_ReturnsPhoneWithCountryCode () {
		assertEquals("+37061234567", phoneValidator.ChangePhoneToCountryCode("861234567"));
	}
}
