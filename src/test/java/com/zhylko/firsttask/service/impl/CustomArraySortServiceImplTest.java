package com.zhylko.firsttask.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.zhylko.firsttask.entity.CustomArray;
import com.zhylko.firsttask.exception.CustomArrayException;

class CustomArraySortServiceImplTest {
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
		CustomArray expected = CustomArray.newCustomArrayBuilder()
				.setCustomArrayID(0)
				.setArray(new int[] {-5, -4, -3, 1, 2})
				.build();
		CustomArraySortServiceImpl service = new CustomArraySortServiceImpl();
		CustomArray actual = service.shakerSort(customArray);
		assertEquals(expected, actual);
	}
	
	@Test
	void mergeSort() throws CustomArrayException {
		CustomArray expected = CustomArray.newCustomArrayBuilder()
				.setCustomArrayID(0)
				.setArray(new int[] {-5, -4, -3, 1, 2})
				.build();
		int begin = 0;
		int end = customArray.getLength();
		CustomArraySortServiceImpl service = new CustomArraySortServiceImpl();
		CustomArray actual = service.mergeSort(customArray, begin, end);
		assertEquals(expected, actual);
	}

}
