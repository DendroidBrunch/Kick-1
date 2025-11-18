package com.zhylko.firsttask.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import com.zhylko.firsttask.entity.CustomArray;
import com.zhylko.firsttask.exception.CustomArrayException;

class CustomArrayReplaceUnderConditionImplTest {
	
	CustomArray customArray = CustomArray.newCustomArrayBuilder()
			.setArray(new int[] {1, -3, 2, -4, -5})
			.build();

	@Test
	void replaceUnderCondition() throws CustomArrayException {
		CustomArray expected = CustomArray.newCustomArrayBuilder()
																				.setArray(new int[] {1,0,2,0,0})
																				.build();
		CustomArrayReplaceUnderConditionServiceImpl service = new CustomArrayReplaceUnderConditionServiceImpl();
		Predicate <Integer> predicate = integer -> integer < 0;
		service.replaceUnderCondition(customArray, predicate, 0);
		CustomArray actual = customArray;
		assertEquals(expected, actual);
	}
	
	@Test
	void replaceUnderConditionWithStream() throws CustomArrayException {
		CustomArray expected = CustomArray.newCustomArrayBuilder()
																				.setArray(new int[] {1,0,2,0,0})
																				.build();
		CustomArrayReplaceUnderConditionServiceImpl service = new CustomArrayReplaceUnderConditionServiceImpl();
		Predicate <Integer> predicate = integer -> integer < 0;
		service.replaceUnderConditionWithStream(customArray, predicate, 0);
		CustomArray actual = customArray;
		assertEquals(expected, actual);
	}
}
