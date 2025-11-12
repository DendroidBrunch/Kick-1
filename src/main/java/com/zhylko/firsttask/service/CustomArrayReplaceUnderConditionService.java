package com.zhylko.firsttask.service;

import java.util.function.Predicate;

import com.zhylko.firsttask.entity.CustomArray;
import com.zhylko.firsttask.exception.CustomArrayException;

public interface CustomArrayReplaceUnderConditionService {
	CustomArray replaceUnderCondition (CustomArray customArray, Predicate<Integer> condition, int newValue) throws CustomArrayException;
}
