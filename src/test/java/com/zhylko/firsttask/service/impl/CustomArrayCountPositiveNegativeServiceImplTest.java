package com.zhylko.firsttask.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.zhylko.firsttask.entity.CustomArray;
import com.zhylko.firsttask.exception.CustomArrayException;

class CustomArrayCountPositiveNegativeServiceImplTest {

	CustomArray customArray = CustomArray.newCustomArrayBuilder()
			.setArray(new int[] {1, -3, 2, -4, -5})
			.build();
	
	@Test
	void countNegative() throws CustomArrayException {
		int expected = 3;
		CustomArrayCountPositiveNegativeServiceImpl service = new CustomArrayCountPositiveNegativeServiceImpl();
		int actual = service.countNegative(customArray);
		assertEquals(expected, actual);
	}
	
	@Test
	void countPositive() throws CustomArrayException {
		int expected = 2;
		CustomArrayCountPositiveNegativeServiceImpl service = new CustomArrayCountPositiveNegativeServiceImpl();
		int actual = service.countPositive(customArray);
		assertEquals(expected, actual);
	}
	
	@Test
	void countNegativeWithStream() throws CustomArrayException {
		int expected = 3;
		CustomArrayCountPositiveNegativeServiceImpl service = new CustomArrayCountPositiveNegativeServiceImpl();
		int actual = service.countNegativeWithStream(customArray);
		assertEquals(expected, actual);
	}
	
	@Test
	void countPositiveWithStream() throws CustomArrayException {
		int expected = 2;
		CustomArrayCountPositiveNegativeServiceImpl service = new CustomArrayCountPositiveNegativeServiceImpl();
		int actual = service.countPositiveWithStream(customArray);
		assertEquals(expected, actual);
	}

}
