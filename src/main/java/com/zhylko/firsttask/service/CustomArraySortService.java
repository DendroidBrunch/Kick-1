package com.zhylko.firsttask.service;

import com.zhylko.firsttask.entity.CustomArray;
import com.zhylko.firsttask.exception.CustomArrayException;

public interface CustomArraySortService {
	void shakerSort(CustomArray customArray) throws CustomArrayException;
	void mergeSort(CustomArray customArray, int begin, int end) throws CustomArrayException;
	void quickSort(CustomArray customArray, int begin, int end) throws CustomArrayException;
	void streamSort(CustomArray customArray) throws CustomArrayException;
}
