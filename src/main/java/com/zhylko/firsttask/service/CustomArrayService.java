package com.zhylko.firsttask.service;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

import com.zhylko.firsttask.entity.CustomArray;
import com.zhylko.firsttask.exception.CustomArrayException;

public interface CustomArrayService {
	Optional<Integer> findMax(CustomArray customArray) throws CustomArrayException;
	Optional<Integer> findMin(CustomArray customArray) throws CustomArrayException;
	Optional<Integer> countSum(CustomArray customArray) throws CustomArrayException;
	Optional<Double> countAverage(CustomArray customArray) throws CustomArrayException;
	OptionalInt findMaxWithStream(CustomArray customArray) throws CustomArrayException;
	OptionalInt findMinWithStream(CustomArray customArray) throws CustomArrayException;
	OptionalInt countSumWithStream(CustomArray customArray) throws CustomArrayException;
	OptionalDouble countAverageWithStream(CustomArray customArray) throws CustomArrayException;
}
