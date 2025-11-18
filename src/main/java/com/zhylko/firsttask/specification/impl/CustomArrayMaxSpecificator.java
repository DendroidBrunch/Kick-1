package com.zhylko.firsttask.specification.impl;

import java.util.Optional;

import com.zhylko.firsttask.entity.CustomArray;
import com.zhylko.firsttask.exception.CustomArrayException;
import com.zhylko.firsttask.service.impl.CustomArrayServiceImpl;
import com.zhylko.firsttask.specification.CustomArraySpecificator;

public class CustomArrayMaxSpecificator implements CustomArraySpecificator {
	private int max;

	public CustomArrayMaxSpecificator(int max) {
		this.max = max;
	}
	
	@Override
	public boolean specify(CustomArray t) throws CustomArrayException {
		CustomArrayServiceImpl service = new CustomArrayServiceImpl();
		Optional<Integer> tMax= service.findMax(t);
		boolean result = false;
		if(!tMax.isEmpty()) {
		 result = tMax.get() == max;
		}
		return result;
	}

}
