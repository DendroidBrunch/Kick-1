package com.zhylko.firsttask.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.zhylko.firsttask.entity.CustomArray;
import com.zhylko.firsttask.exception.CustomArrayException;

class CustomArraySortServiceImplTest {
	static Logger logger = LogManager.getLogger();
	
	CustomArray customArray = CustomArray.newCustomArrayBuilder()
																				.setCustomArrayID(0)
																				.setArray(new int[] {1, -3, 2, -4, -5})
																				.build();
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void shakerSort() throws CustomArrayException {
		logger.log(Level.INFO, customArray.toString());
		CustomArray expected = CustomArray.newCustomArrayBuilder()
				.setCustomArrayID(0)
				.setArray(new int[] {-5, -4, -3, 1, 2})
				.build();
		CustomArraySortServiceImpl service = new CustomArraySortServiceImpl();
		CustomArray actual = service.shakerSort(customArray);
		logger.log(Level.INFO, "CustomArray sorted with shakerSort: " + actual.toString());
		assertEquals(expected, actual);
	}
	
	@Test
	void mergeSort() throws CustomArrayException {
		logger.log(Level.INFO, customArray.toString());
		CustomArray expected = CustomArray.newCustomArrayBuilder()
				.setCustomArrayID(0)
				.setArray(new int[] {-5, -4, -3, 1, 2})
				.build();
		int begin = 0;
		int end = customArray.getLength();
		CustomArraySortServiceImpl service = new CustomArraySortServiceImpl();
		CustomArray actual = service.mergeSort(customArray, begin, end);
		logger.log(Level.INFO, "CustomArray sorted with mergeSort: " + actual.toString());
		assertEquals(expected, actual);
	}
	
	@Test
	void quickSort() throws CustomArrayException {
		logger.log(Level.INFO, customArray.toString());
		CustomArray expected = CustomArray.newCustomArrayBuilder()
				.setCustomArrayID(0)
				.setArray(new int[] {-5, -4, -3, 1, 2})
				.build();
		int begin = 0;
		int end = customArray.getLength();
		CustomArraySortServiceImpl service = new CustomArraySortServiceImpl();
		CustomArray actual = service.quickSort(customArray, begin, end);
		logger.log(Level.INFO, "CustomArray sorted with quickSort: " + actual.toString());
		assertEquals(expected, actual);
	}

}
