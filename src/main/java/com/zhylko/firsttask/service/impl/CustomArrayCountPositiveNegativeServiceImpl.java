package com.zhylko.firsttask.service.impl;

import java.util.Arrays;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.zhylko.firsttask.entity.CustomArray;
import com.zhylko.firsttask.exception.CustomArrayException;
import com.zhylko.firsttask.service.CustomArrayCountPositiveNegativeService;

public class CustomArrayCountPositiveNegativeServiceImpl implements CustomArrayCountPositiveNegativeService{
	
	private static final Logger logger  = LogManager.getLogger();

	@Override
	public int countNegative(CustomArray customArray) throws CustomArrayException {
		if(customArray == null) {
			logger.log(Level.ERROR, "Null customArray passed to service");
			throw new CustomArrayException("Array is not initialized");
		}
		
		int length = customArray.getLength();
		int counter = 0;
		for(int i = 0; i < length; i++) {
			if(customArray.get(i) < 0) {
				counter++;
			}
		}
		return counter;
	}

	@Override
	public int countPositive(CustomArray customArray) throws CustomArrayException {
		if(customArray == null) {
			logger.log(Level.ERROR, "Null customArray passed to service");
			throw new CustomArrayException("Array is not initialized");
		}
		
		int length = customArray.getLength();
		int counter = 0;
		for(int i = 0; i < length; i++) {
			if(customArray.get(i) > 0) {
				counter++;
			}
		}
		return counter;
	}

	@Override
	public int countPositiveWithStream(CustomArray customArray) throws CustomArrayException {
		if(customArray == null) {
			logger.log(Level.ERROR, "Null customArray passed to service");
			throw new CustomArrayException("Array is not initialized");
		}
		
		long result = Arrays.stream(customArray.getArray())
															.filter(value -> value > 0)
															.count();
		return (int) result;
	}

	@Override
	public int countNegativeWithStream(CustomArray customArray) throws CustomArrayException {
		if(customArray == null) {
			logger.log(Level.ERROR, "Null customArray passed to service");
			throw new CustomArrayException("Array is not initialized");
		}
		
		long result = Arrays.stream(customArray.getArray())
															.filter(value -> value < 0)
															.count();
		return (int) result;
	}
}
