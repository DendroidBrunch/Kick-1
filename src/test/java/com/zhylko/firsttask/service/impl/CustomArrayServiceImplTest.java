package com.zhylko.firsttask.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.zhylko.firsttask.entity.CustomArray;
import com.zhylko.firsttask.exception.CustomArrayException;

class CustomArrayServiceImplTest {
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
	void findMax() throws CustomArrayException {
		int expected = 2;
		CustomArrayServiceImpl service = new CustomArrayServiceImpl();
		int actual = service.findMax(customArray);
		assertEquals(expected, actual);
	}
	
	@Test
	void findMin() throws CustomArrayException {
		int expected = -5;
		CustomArrayServiceImpl service = new CustomArrayServiceImpl();
		int actual = service.findMin(customArray);
		assertEquals(expected, actual);
	}

	@Test
	void CountSum() throws CustomArrayException {
		int expected = -9;
		CustomArrayServiceImpl service = new CustomArrayServiceImpl();
		int actual = service.countSum(customArray);
		assertEquals(expected, actual);
	}
	
	@Test
	void countAverage() throws CustomArrayException {
		double expected = - 1.8;
		CustomArrayServiceImpl service = new CustomArrayServiceImpl();
		double actual = service.countAverage(customArray);
		assertEquals(expected, actual);
	}
	
	@Test
	void countNegative() throws CustomArrayException {
		int expected = 3;
		CustomArrayServiceImpl service = new CustomArrayServiceImpl();
		int actual = service.countNegative(customArray);
		assertEquals(expected, actual);
	}
	
	@Test
	void countPositive() throws CustomArrayException {
		int expected = 2;
		CustomArrayServiceImpl service = new CustomArrayServiceImpl();
		int actual = service.countPositive(customArray);
		assertEquals(expected, actual);
	}
}
