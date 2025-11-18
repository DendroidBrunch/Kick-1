package com.zhylko.firsttask.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.zhylko.firsttask.entity.CustomArray;
import com.zhylko.firsttask.exception.CustomArrayException;

class CustomArraySortServiceImplTest {
	
	CustomArray customArray;
	
	@BeforeEach
	void setUp() throws Exception {
		customArray = CustomArray.newCustomArrayBuilder()
				.setCustomArrayId(0)
				.setArray(new int[] {1, -3, 2, -4, -5})
				.build();
	}

	@AfterEach
	void tearDown() throws Exception {
		customArray = null;
	}

	@Test
	void shakerSort() throws CustomArrayException {
		CustomArray expected = CustomArray.newCustomArrayBuilder()
				.setCustomArrayId(0)
				.setArray(new int[] {-5, -4, -3, 1, 2})
				.build();
		CustomArraySortServiceImpl service = new CustomArraySortServiceImpl();
		service.shakerSort(customArray);
		CustomArray actual = customArray;
		assertEquals(expected, actual);
	}
	
	@Test
	void mergeSort() throws CustomArrayException {
		CustomArray expected = CustomArray.newCustomArrayBuilder()
				.setCustomArrayId(0)
				.setArray(new int[] {-5, -4, -3, 1, 2})
				.build();
		int begin = 0;
		int end = customArray.getLength();
		CustomArraySortServiceImpl service = new CustomArraySortServiceImpl();
		service.mergeSort(customArray, begin, end);
		CustomArray actual = customArray;
		assertEquals(expected, actual);
	}
	
	@Test
	void quickSort() throws CustomArrayException {
		CustomArray expected = CustomArray.newCustomArrayBuilder()
				.setCustomArrayId(0)
				.setArray(new int[] {-5, -4, -3, 1, 2})
				.build();
		int begin = 0;
		int end = customArray.getLength();
		CustomArraySortServiceImpl service = new CustomArraySortServiceImpl();
		service.quickSort(customArray, begin, end);
		CustomArray actual = customArray;
		assertEquals(expected, actual);
	}
	
	@Test
	void streamSort() throws CustomArrayException {
		CustomArray expected = CustomArray.newCustomArrayBuilder()
				.setCustomArrayId(0)
				.setArray(new int[] {-5, -4, -3, 1, 2})
				.build();
		CustomArraySortServiceImpl service = new CustomArraySortServiceImpl();
		service.streamSort(customArray);
		CustomArray actual = customArray;
		assertEquals(expected, actual);
	}
}
