package com.zhylko.firsttask.validator;

public interface CustomArrayValidator {
	String CUSTOM_ARRAY_REGEX = "\\d+";
	
	boolean checkCustomArrayString(String[] parsedCustomArray);
}
