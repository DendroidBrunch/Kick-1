package com.zhylko.firsttask.specification;

import com.zhylko.firsttask.entity.CustomArray;
import com.zhylko.firsttask.exception.CustomArrayException;

@FunctionalInterface
public interface CustomArraySpecificator {
	boolean specify(CustomArray t) throws CustomArrayException;
}
