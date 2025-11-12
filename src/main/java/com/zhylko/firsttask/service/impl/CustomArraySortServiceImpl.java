package com.zhylko.firsttask.service.impl;

import com.zhylko.firsttask.entity.CustomArray;
import com.zhylko.firsttask.exception.CustomArrayException;
import com.zhylko.firsttask.service.CustomArraySortService;

public class CustomArraySortServiceImpl implements CustomArraySortService{
	
	@Override
	public CustomArray shakerSort(CustomArray customArray) throws CustomArrayException {
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
		
		return customArray;
	}

	@Override
	public CustomArray mergeSort(CustomArray customArray, int begin, int end) throws CustomArrayException {
		int length = customArray.getLength();
		if(begin < 0) {
			throw new CustomArrayException("Index begin out of range: " + begin);
		}
		if(end > length) {
			throw new CustomArrayException("Index end out of range: " + end);
		}
		
		if(begin >= end - 1) return customArray;
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
		
		return customArray;
	}

	@Override
	public CustomArray quickSort(CustomArray customArray) throws CustomArrayException {
		// TODO Auto-generated method stub
		throw new CustomArrayException("In development");
	}

}
