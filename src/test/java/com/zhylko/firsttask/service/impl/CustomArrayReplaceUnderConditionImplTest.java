package com.zhylko.firsttask.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Predicate;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.zhylko.firsttask.entity.CustomArray;
import com.zhylko.firsttask.exception.CustomArrayException;

class CustomArrayReplaceUnderConditionImplTest {
	Logger logger = LogManager.getLogger();
	
	CustomArray customArray = CustomArray.newCustomArrayBuilder()
			.setArray(new int[] {1, -3, 2, -4, -5})
			.build();
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void replaceUnderCondition() throws CustomArrayException {
		logger.log(Level.INFO, customArray.toString());
		CustomArray expected = CustomArray.newCustomArrayBuilder()
																				.setArray(new int[] {1,0,2,0,0})
																				.build();
		CustomArrayReplaceUnderConditionServiceImpl service = new CustomArrayReplaceUnderConditionServiceImpl();
		Predicate <Integer> predicate = integer -> integer < 0;
		CustomArray actual = service.replaceUnderCondition(customArray, predicate, 0);
		logger.log(Level.INFO, "Replaced negative values with 0   " + actual.toString());
		assertEquals(expected, actual);
	}
}
