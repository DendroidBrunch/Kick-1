package com.zhylko.firsttask.service;

import com.zhylko.firsttask.entity.CustomArray;
import com.zhylko.firsttask.exception.CustomArrayException;

public interface CustomArrayService {
	Integer findMax(CustomArray customArray) throws CustomArrayException;
	Integer findMin(CustomArray customArray) throws CustomArrayException;
	Integer countSum(CustomArray customArray) throws CustomArrayException;
	Double countAverage(CustomArray customArray) throws CustomArrayException;
	Integer countNegative(CustomArray customArray) throws CustomArrayException;
	Integer countPositive(CustomArray customArray) throws CustomArrayException;
}
