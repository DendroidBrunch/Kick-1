package com.zhylko.firsttask.service;

import com.zhylko.firsttask.entity.CustomArray;
import com.zhylko.firsttask.exception.CustomArrayIndexOutOfBoundsException;

public interface CustomArrayService {
	Integer findMax(CustomArray customArray) throws CustomArrayIndexOutOfBoundsException;
	Integer findMin(CustomArray customArray) throws CustomArrayIndexOutOfBoundsException;
	Integer countSum(CustomArray customArray) throws CustomArrayIndexOutOfBoundsException;
	Double countAverage(CustomArray customArray) throws CustomArrayIndexOutOfBoundsException;
	Integer countNegative(CustomArray customArray) throws CustomArrayIndexOutOfBoundsException;
	Integer countPositive(CustomArray customArray) throws CustomArrayIndexOutOfBoundsException;
}
