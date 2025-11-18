package com.zhylko.firsttask.specification.impl;

import com.zhylko.firsttask.entity.CustomArray;
import com.zhylko.firsttask.specification.CustomArraySpecificator;

public class CustomArrayIdSpecificator implements CustomArraySpecificator {

	private long id;
	
	public CustomArrayIdSpecificator(long id) {
		this.id = id;
	}
	
	@Override
	public boolean specify(CustomArray t) {
		return t.getCustomArrayId() == id;
	}

}
