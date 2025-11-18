package com.zhylko.firsttask.specification.impl;

import java.util.Optional;

import com.zhylko.firsttask.entity.CustomArray;
import com.zhylko.firsttask.exception.CustomArrayException;
import com.zhylko.firsttask.service.impl.CustomArrayServiceImpl;
import com.zhylko.firsttask.specification.CustomArraySpecificator;

public class CustomArrayMinSpecificator implements CustomArraySpecificator {
	private int min;

	public CustomArrayMinSpecificator(int min) {
		this.min = min;
	}
	
	@Override
	public boolean specify(CustomArray t) throws CustomArrayException {
		CustomArrayServiceImpl service = new CustomArrayServiceImpl();
		Optional<Integer> tMin= service.findMin(t);
		boolean result = false;
		if(!tMin.isEmpty()) {
		 result = tMin.get() == min;
		}
		return result;
	}
}
