package com.zhylko.firsttask.warehouse;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.zhylko.firsttask.statistics.CustomArrayStatistics;

class CustomArrayWarehouseTest {

	CustomArrayWarehouse warehouse = CustomArrayWarehouse.getInstance();
	
	@BeforeEach
	void setUp() {
		CustomArrayStatistics statistics = new CustomArrayStatistics(0, 3, 5, 1);
		warehouse.put(0, statistics);
	}

	@Test
	void getStatisticsNull() {
		CustomArrayStatistics expected = null;
		CustomArrayStatistics actual = warehouse.getStatistics(5);
		assertEquals(expected, actual);
	}
	
	@Test
	void getStatistics() {
		CustomArrayStatistics expected = new CustomArrayStatistics(0, 3, 5, 1);;
		CustomArrayStatistics actual = warehouse.getStatistics(0);
		assertEquals(expected, actual);
	}

}
