package com.zhylko.firsttask.validator;

import com.zhylko.firsttask.exception.CustomArrayException;

public interface CustomArrayValidator {
	String INTEGER_REGEX = "^?[+-]\\d+";
	
	boolean checkCustomArrayString(String token) throws CustomArrayException;
}
