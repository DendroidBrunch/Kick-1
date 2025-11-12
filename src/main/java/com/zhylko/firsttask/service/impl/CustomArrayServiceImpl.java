package com.zhylko.firsttask.service.impl;

import com.zhylko.firsttask.entity.CustomArray;
import com.zhylko.firsttask.exception.CustomArrayIndexOutOfBoundsException;
import com.zhylko.firsttask.service.CustomArrayService;

public class CustomArrayServiceImpl implements CustomArrayService{

	@Override
	public Integer findMax(CustomArray customArray) throws CustomArrayIndexOutOfBoundsException {
		int length = customArray.getLength();
		if(length == 0) {
			return null;
		}
		Integer max = customArray.get(0);
		for(int i = 1; i < length; i++) {
			if(customArray.get(i) > max) {
				max = customArray.get(i);
			}
		}
		return max;
	}

	@Override
	public Integer findMin(CustomArray customArray) throws CustomArrayIndexOutOfBoundsException {
		int length = customArray.getLength();
		if(length == 0) {
			return null;
		}
		Integer min = customArray.get(0);
		for(int i = 1; i < length; i++) {
			if(customArray.get(i) < min) {
				min = customArray.get(i);
			}
		}
		return min;
	}

	@Override
	public Integer countSum(CustomArray customArray) throws CustomArrayIndexOutOfBoundsException {
		int length = customArray.getLength();
		if(length == 0) {
			return null;
		}
		int sum = 0;
		for(int  i = 0; i < length; i++) {
			sum += customArray.get(i);
		}
		return sum;
	}
	
	@Override
	public Double countAverage(CustomArray customArray) throws CustomArrayIndexOutOfBoundsException {
		int length = customArray.getLength();
		if(length == 0) {
			return null;
		}
		int sum = this.countSum(customArray);
		double average = (double) sum / length;
		return average;
	}

	@Override
	public Integer countNegative(CustomArray customArray) throws CustomArrayIndexOutOfBoundsException {
		int length = customArray.getLength();
		if(length == 0) {
			return null;
		}
		int counter = 0;
		for(int i = 0; i < length; i++) {
			if(customArray.get(i) < 0) {
				counter++;
			}
		}
		return counter;
	}

	@Override
	public Integer countPositive(CustomArray customArray) throws CustomArrayIndexOutOfBoundsException {
		int length = customArray.getLength();
		if(length == 0) {
			return null;
		}
		int counter = 0;
		for(int i = 0; i < length; i++) {
			if(customArray.get(i) > 0) {
				counter++;
			}
		}
		return counter;
	}
	
}
