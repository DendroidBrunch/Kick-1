package com.zhylko.firsttask.service;

import com.zhylko.firsttask.entity.CustomArray;
import com.zhylko.firsttask.exception.CustomArrayException;

public interface CustomArraySortService {
	CustomArray shakerSort(CustomArray customArray) throws CustomArrayException;
	CustomArray mergeSort(CustomArray customArray, int begin, int end) throws CustomArrayException;
	CustomArray quickSort(CustomArray customArray, int begin, int end) throws CustomArrayException;
}
