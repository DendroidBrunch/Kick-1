package com.zhylko.firsttask.service.impl;

import java.util.Arrays;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.zhylko.firsttask.entity.CustomArray;
import com.zhylko.firsttask.exception.CustomArrayException;
import com.zhylko.firsttask.service.CustomArraySortService;

public class CustomArraySortServiceImpl implements CustomArraySortService{
	
	private static final Logger logger = LogManager.getLogger();
	
	@Override
	public void shakerSort(CustomArray customArray) throws CustomArrayException {
		if(customArray == null) {
			logger.log(Level.ERROR, "Null customArray passed to service");
			throw new CustomArrayException("Array is not initialized");
		}
		
		int length = customArray.getLength();
		int left = 0;
		int right = length - 1;
		boolean flag = true;
		while(flag) {
			flag = false;
			for(int i = left; i < right; i++) {
				if(customArray.get(i) > customArray.get(i + 1)) {
					int tmp = customArray.get(i);
					customArray.set(i, customArray.get(i + 1));
					customArray.set(i + 1, tmp);
					flag = true;
				}
			}
			right--;
			for(int i = right; i > left; i--) {
				if(customArray.get(i) < customArray.get(i - 1)) {
					int tmp = customArray.get(i);
					customArray.set(i, customArray.get(i - 1));
					customArray.set(i - 1, tmp);
					flag = true;
				}
			}
			left++;
		}
	}

	@Override
	public void mergeSort(CustomArray customArray, int begin, int end) throws CustomArrayException {
		if(customArray == null) {
			logger.log(Level.ERROR, "Null customArray passed to service");
			throw new CustomArrayException("Array is not initialized");
		}
		
		int length = customArray.getLength();
		if(begin < 0) {
			throw new CustomArrayException("Index begin out of range: " + begin);
		}
		if(end > length) {
			throw new CustomArrayException("Index end out of range: " + end);
		}
		
		if(begin >= end - 1) {
			return;
		}
		
		int k = (begin + end + 1) / 2;
		mergeSort(customArray, begin, k);
		mergeSort(customArray, k, end);
		
		int[] sorted = new int[end - begin];
		int left = begin;
		int right = k;
		int sortedIndex = 0;
		while(left + right < k + end) {
			if(left == k || (right < end && customArray.get(left) > customArray.get(right))) {
				sorted[sortedIndex] = customArray.get(right);
				right++;
			} else {
				sorted[sortedIndex] = customArray.get(left);
				left++;
			}
			sortedIndex++;
		}
		
		for(int i = 0; i < sorted.length; i++) {
			customArray.set(begin + i, sorted[i]);
		}
	}

	@Override
	public void quickSort(CustomArray customArray, int begin, int end) throws CustomArrayException {
		if(customArray == null) {
			logger.log(Level.ERROR, "Null customArray passed to service");
			throw new CustomArrayException("Array is not initialized");
		}
		
		int length = customArray.getLength();
		if(begin < 0) {
			throw new CustomArrayException("Index begin out of range: " + begin);
		}
		if(end > length) {
			throw new CustomArrayException("Index end out of range: " + end);
		}
		
		if(begin >= end) {
			return;
		}
		
		int[] pivoted = new int[end - begin];
		int left = 0;
		int right = end - begin - 1;
		int pivot = customArray.get(begin);
		for(int i = begin + 1; i < end; i++) {
			if(customArray.get(i) < pivot) {
				pivoted[left] = customArray.get(i);
				left++;
			} else {
				pivoted[right] = customArray.get(i);
				right--;
			}
		}
		pivoted[left] = pivot;
		
		for(int i = begin; i < end; i++) {
			customArray.set(i, pivoted[i - begin]);
		}
		
		quickSort(customArray, begin, left + begin);
		quickSort(customArray, left + 1 + begin, end);
	}

	@Override
	public void streamSort(CustomArray customArray) throws CustomArrayException {
		if(customArray == null) {
			logger.log(Level.ERROR, "Null customArray passed to service");
			throw new CustomArrayException("Array is not initialized");
		}
		
		int[] sortedArray =	Arrays.stream(customArray.getArray())
													.sorted()
													.toArray();
		customArray.setArray(sortedArray);
	}

}
