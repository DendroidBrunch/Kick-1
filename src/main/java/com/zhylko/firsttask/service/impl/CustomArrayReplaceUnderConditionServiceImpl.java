package com.zhylko.firsttask.service.impl;

import java.util.function.Predicate;

import com.zhylko.firsttask.entity.CustomArray;
import com.zhylko.firsttask.exception.CustomArrayException;
import com.zhylko.firsttask.service.CustomArrayReplaceUnderConditionService;

public class CustomArrayReplaceUnderConditionServiceImpl implements CustomArrayReplaceUnderConditionService{
	@Override
	public CustomArray replaceUnderCondition(CustomArray customArray, Predicate<Integer> condition, int newValue) throws CustomArrayException{
		int length = customArray.getLength();
		for(int i = 0; i < length; i++) {
			if(condition.test(customArray.get(i))) {
				customArray.set(i, newValue);
			}
		}
		return customArray;
	}
	
}
