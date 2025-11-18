package com.zhylko.firsttask.service;

import com.zhylko.firsttask.entity.CustomArray;
import com.zhylko.firsttask.exception.CustomArrayException;

public interface CustomArrayCountPositiveNegativeService {
	int countPositive(CustomArray customArray) throws CustomArrayException;
	int countNegative(CustomArray customArray) throws CustomArrayException;
	int countPositiveWithStream(CustomArray customArray) throws CustomArrayException;
	int countNegativeWithStream(CustomArray customArray) throws CustomArrayException;
}
