package com.zhylko.firsttask.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.zhylko.firsttask.entity.CustomArray;
import com.zhylko.firsttask.exception.CustomArrayException;

class CustomArrayServiceImplTest {
	
	CustomArray customArray = CustomArray.newCustomArrayBuilder()
																				.setArray(new int[] {1, -3, 2, -4, -5})
																				.build();

	@Test
	void findMax() throws CustomArrayException {
		int expected = 2;
		CustomArrayServiceImpl service = new CustomArrayServiceImpl();
		int actual = service.findMax(customArray).get();
		assertEquals(expected, actual);
	}
	
	@Test
	void findMin() throws CustomArrayException {
		int expected = -5;
		CustomArrayServiceImpl service = new CustomArrayServiceImpl();
		int actual = service.findMin(customArray).get();
		assertEquals(expected, actual);
	}

	@Test
	void CountSum() throws CustomArrayException {
		int expected = -9;
		CustomArrayServiceImpl service = new CustomArrayServiceImpl();
		int actual = service.countSum(customArray).get();
		assertEquals(expected, actual);
	}
	
	@Test
	void countAverage() throws CustomArrayException {
		double expected = - 1.8;
		CustomArrayServiceImpl service = new CustomArrayServiceImpl();
		double actual = service.countAverage(customArray).get();
		assertEquals(expected, actual);
	}
	
	@Test
	void findMaxWithStream() throws CustomArrayException {
		int expected = 2;
		CustomArrayServiceImpl service = new CustomArrayServiceImpl();
		int actual = service.findMaxWithStream(customArray).getAsInt();
		assertEquals(expected, actual);
	}
	
	@Test
	void findMinWithStream() throws CustomArrayException {
		int expected = -5;
		CustomArrayServiceImpl service = new CustomArrayServiceImpl();
		int actual = service.findMinWithStream(customArray).getAsInt();
		assertEquals(expected, actual);
	}

	@Test
	void CountSumWithStream() throws CustomArrayException {
		int expected = -9;
		CustomArrayServiceImpl service = new CustomArrayServiceImpl();
		int actual = service.countSumWithStream(customArray).getAsInt();
		assertEquals(expected, actual);
	}
	
	@Test
	void countAverageWithStream() throws CustomArrayException {
		double expected = - 1.8;
		CustomArrayServiceImpl service = new CustomArrayServiceImpl();
		double actual = service.countAverageWithStream(customArray).getAsDouble();
		assertEquals(expected, actual);
	}
}
