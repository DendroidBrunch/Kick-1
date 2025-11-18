package com.zhylko.firsttask.specification.impl;

import java.util.Optional;

import com.zhylko.firsttask.entity.CustomArray;
import com.zhylko.firsttask.exception.CustomArrayException;
import com.zhylko.firsttask.service.impl.CustomArrayServiceImpl;
import com.zhylko.firsttask.specification.CustomArraySpecificator;

public class CustomArraySumIntervalSpecification implements CustomArraySpecificator {

	private int left;
	private int right;
	
	public CustomArraySumIntervalSpecification(int left, int right) {
		this.left = left;
		this.right = right;
	}
	
	@Override
	public boolean specify(CustomArray t) throws CustomArrayException {
		CustomArrayServiceImpl service = new CustomArrayServiceImpl();
		Optional<Integer> tSum = service.countSum(t);
		boolean result = false;
		if(!tSum.isEmpty()) {
		 result = tSum.get() > left && tSum.get() < right;
		}
		return result;
	}

}
