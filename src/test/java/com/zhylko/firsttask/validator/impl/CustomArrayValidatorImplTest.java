package com.zhylko.firsttask.validator.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.zhylko.firsttask.exception.CustomArrayException;

class CustomArrayValidatorImplTest {
	CustomArrayValidatorImpl validator = new CustomArrayValidatorImpl();
	
	@Test
	void checkCustomArrayStringInvalid() throws CustomArrayException {
		String token = "4t4";
		boolean result = validator.checkCustomArrayString(token);
		assertFalse(result);
	}
	
	@Test
	void checkCustomArrayStringEmptyToken() throws CustomArrayException {
		String token = "";
		boolean result = validator.checkCustomArrayString(token);
		assertFalse(result);
	}

	@Test
	void checkCustomArrayStringNullToken() throws CustomArrayException {
		String token = null;
		assertThrows(CustomArrayException.class, () -> {validator.checkCustomArrayString(token);});
	}
	
	@Test
	void checkCustomArrayStringPlusInteger() throws CustomArrayException {
		String token = "+3";
		boolean result = validator.checkCustomArrayString(token);
		assertTrue(result);
	}
	
	@Test
	void checkCustomArrayStringMinusInteger() throws CustomArrayException {
		String token = "-3";
		boolean result = validator.checkCustomArrayString(token);
		assertTrue(result);
	}
}
