package com.zhylko.firsttask.validator.impl;

import com.zhylko.firsttask.validator.CustomArrayValidator;

public class CustomArrayValidatorImpl implements CustomArrayValidator{

	@Override
	public boolean checkCustomArrayString(String[] parsedCustomArray) {
		for(String customArrayPart : parsedCustomArray) {
			if(!customArrayPart.matches(CUSTOM_ARRAY_REGEX));{
				return false;
			}
		}
		
		return true;
	}
}
