package com.app.web.appweb.validators;

import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmailValidatorTest {

	EmailValidator emailValidator = new EmailValidator();

	@Test
	void EmailIsValidTest_ValidEmail_ReturnsTrue () {
		assertEquals(true, emailValidator.EmailIsValid("email@email.com"));
	}

	@Test
	void EmailIsValidTest_NoAtSymbol_ReturnsFalse () {
		assertEquals(false, emailValidator.EmailIsValid("emailemail.com"));
	}

	@Test
	void EmailIsValidTest_HasInvalidSymbol_ReturnsFalse () {
		assertEquals(false, emailValidator.EmailIsValid("email@email.com!"));
	}
	
	@Test
	void EmailIsValidTest_InvalidDomain_ReturnsFalse () {
		assertEquals(false, emailValidator.EmailIsValid("email@baddomain"));
	}

	//Not sure that this test is correct, since TLD needs a dot and is a part of the domain
	@Test
	void EmailIsValidTest_InvalidTLD_ReturnsFalse () {
		assertEquals(false, emailValidator.EmailIsValid("abcd"));
	}
}
