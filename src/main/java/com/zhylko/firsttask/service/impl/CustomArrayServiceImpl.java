package com.zhylko.firsttask.service.impl;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.zhylko.firsttask.entity.CustomArray;
import com.zhylko.firsttask.exception.CustomArrayException;
import com.zhylko.firsttask.service.CustomArrayService;

public class CustomArrayServiceImpl implements CustomArrayService{
	
	private static final Logger logger = LogManager.getLogger();

	@Override
	public Optional<Integer> findMax(CustomArray customArray) throws CustomArrayException {
		if(customArray == null) {
			logger.log(Level.ERROR, "Null customArray passed to service");
			throw new CustomArrayException("Array is not initialized");
		}
		
		int length = customArray.getLength();
		Optional<Integer> maxOptional = Optional.empty();;
		if(length > 0) {
			int max = customArray.get(0);
			for(int i = 1; i < length; i++) {
				if(customArray.get(i) > max) {
					max = customArray.get(i);
				}
			}
			maxOptional = Optional.of(max);
		}
		return maxOptional;
	}

	@Override
	public Optional<Integer> findMin(CustomArray customArray) throws CustomArrayException {
		if(customArray == null) {
			logger.log(Level.ERROR, "Null customArray passed to service");
			throw new CustomArrayException("Array is not initialized");
		}
		
		int length = customArray.getLength();
		Optional<Integer> minOptional = Optional.empty();;
		if(length > 0) {
			int min = customArray.get(0);
			for(int i = 1; i < length; i++) {
				if(customArray.get(i) < min) {
					min = customArray.get(i);
				}
			}
			minOptional = Optional.of(min);
		}
		return minOptional;
	}

	@Override
	public Optional<Integer> countSum(CustomArray customArray) throws CustomArrayException {
		if(customArray == null) {
			logger.log(Level.ERROR, "Null customArray passed to service");
			throw new CustomArrayException("Array is not initialized");
		}
		
		int length = customArray.getLength();
		Optional<Integer> sumOptional = Optional.empty();;
		if(length > 0) {
			int sum = 0;
			for(int i = 0; i < length; i++) {
					sum += customArray.get(i);
			}
			sumOptional = Optional.of(sum);
		}
		return sumOptional;
	}
	
	@Override
	public Optional<Double> countAverage(CustomArray customArray) throws CustomArrayException {
		if(customArray == null) {
			logger.log(Level.ERROR, "Null customArray passed to service");
			throw new CustomArrayException("Array is not initialized");
		}
		
		int length = customArray.getLength();
		Optional<Double> averageOptional = Optional.empty();
		if(length > 0) {
			int sum = this.countSum(customArray).get();
			double average = (double) sum / length;
			averageOptional = Optional.of(average);
		}
		return averageOptional;
	}

	@Override
	public OptionalInt findMaxWithStream(CustomArray customArray) throws CustomArrayException {
		if(customArray == null) {
			logger.log(Level.ERROR, "Null customArray passed to service");
			throw new CustomArrayException("Array is not initialized");
		}
		
		OptionalInt maxOptional = Arrays.stream(customArray.getArray()).max();
		return maxOptional;
	}

	@Override
	public OptionalInt findMinWithStream(CustomArray customArray) throws CustomArrayException {
		if(customArray == null) {
			logger.log(Level.ERROR, "Null customArray passed to service");
			throw new CustomArrayException("Array is not initialized");
		}
		
		OptionalInt minOptional = Arrays.stream(customArray.getArray()).min();
		return minOptional;
	}

	@Override
	public OptionalInt countSumWithStream(CustomArray customArray) throws CustomArrayException {
		if(customArray == null) {
			logger.log(Level.ERROR, "Null customArray passed to service");
			throw new CustomArrayException("Array is not initialized");
		}
		
		int length = customArray.getLength();
		OptionalInt sumOptional = OptionalInt.empty();
		if(length > 0) {
			sumOptional = OptionalInt.of(Arrays.stream(customArray.getArray()).sum());
		}
		return sumOptional;
	}

	@Override
	public OptionalDouble countAverageWithStream(CustomArray customArray) throws CustomArrayException {
		if(customArray == null) {
			logger.log(Level.ERROR, "Null customArray passed to service");
			throw new CustomArrayException("Array is not initialized");
		}
		
		int length = customArray.getLength();
		OptionalDouble averageOptional = OptionalDouble.empty();
		if(length > 0) {
			int sum = Arrays.stream(customArray.getArray()).sum();
			double average = (double) sum / length; 
			averageOptional = OptionalDouble.of(average);
		}
		return averageOptional;
	}
}
