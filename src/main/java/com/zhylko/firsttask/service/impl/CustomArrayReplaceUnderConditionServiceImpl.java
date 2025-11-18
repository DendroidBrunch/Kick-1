package com.zhylko.firsttask.service.impl;

import java.util.Arrays;
import java.util.function.Predicate;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.zhylko.firsttask.entity.CustomArray;
import com.zhylko.firsttask.exception.CustomArrayException;
import com.zhylko.firsttask.service.CustomArrayReplaceUnderConditionService;

public class CustomArrayReplaceUnderConditionServiceImpl implements CustomArrayReplaceUnderConditionService{
	
	private static final Logger logger = LogManager.getLogger();
	@Override
	public void replaceUnderCondition(CustomArray customArray, Predicate<Integer> condition, int newValue) throws CustomArrayException{
		if(customArray == null) {
			logger.log(Level.ERROR, "Null customArray passed to service");
			throw new CustomArrayException("Array is not initialized");
		}
		
		int length = customArray.getLength();
		for(int i = 0; i < length; i++) {
			if(condition.test(customArray.get(i))) {
				customArray.set(i, newValue);
			}
		}
	}

	@Override
	public void replaceUnderConditionWithStream(CustomArray customArray, Predicate<Integer> condition, int newValue) throws CustomArrayException {
		if(customArray == null) {
			logger.log(Level.ERROR, "Null customArray passed to service");
			throw new CustomArrayException("Array is not initialized");
		}
		
		int[] newValues = Arrays.stream(customArray.getArray())
												.map(value -> condition.test(value) ? newValue: value)
												.toArray();
		customArray.setArray(newValues);
	}
	
}
