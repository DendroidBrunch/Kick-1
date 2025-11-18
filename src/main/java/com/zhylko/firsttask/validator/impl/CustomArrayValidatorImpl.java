package com.zhylko.firsttask.validator.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.zhylko.firsttask.exception.CustomArrayException;
import com.zhylko.firsttask.validator.CustomArrayValidator;

public class CustomArrayValidatorImpl implements CustomArrayValidator{

	private static Logger logger = LogManager.getLogger();
	
	@Override
	public boolean checkCustomArrayString(String token) throws CustomArrayException {
		if(token == null) {
			logger.log(Level.ERROR, "Null token passed to Validator");
			throw new CustomArrayException("Null token");
		}
		return token.matches(INTEGER_REGEX);
	}
}
