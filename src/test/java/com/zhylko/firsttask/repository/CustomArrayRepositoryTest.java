package com.zhylko.firsttask.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.zhylko.firsttask.comparator.CustomArrayComparator;
import com.zhylko.firsttask.entity.CustomArray;
import com.zhylko.firsttask.exception.CustomArrayException;
import com.zhylko.firsttask.specification.impl.CustomArrayIdSpecificator;

class CustomArrayRepositoryTest {
	
	CustomArrayRepository repository = CustomArrayRepository.getInstance();

	@BeforeEach
	void setUp() throws CustomArrayException {
		CustomArray customArray1 = CustomArray.newCustomArrayBuilder()
																		.setArray(new int[] {4, 1, 2, 3})
																		.setCustomArrayId(0)
																		.build();
		CustomArray customArray2 = CustomArray.newCustomArrayBuilder()
																		.setArray(new int[] {1, 2, 3})
																		.setCustomArrayId(2)
																		.build();
		CustomArray customArray3 = CustomArray.newCustomArrayBuilder()
																		.setArray(new int[] {5, 1, 2, 3})
																		.setCustomArrayId(1)
																		.build();
		repository.add(customArray1);
		repository.add(customArray2);
		repository.add(customArray3);
	}

	@AfterEach
	void tearDown() throws CustomArrayException {
		for(CustomArray array : repository.getCustomArrays()) {
			repository.remove(array);
		}
	}

	@Test
	void sortById() {
		CustomArrayComparator comparator = CustomArrayComparator.BY_ID;
		List<CustomArray> result = repository.sort(comparator);
		
		assertEquals(result.get(0).getCustomArrayId(), 0);
		assertEquals(result.get(1).getCustomArrayId(), 1);
		assertEquals(result.get(2).getCustomArrayId(), 2);
	}
	
	@Test
	void query() {
		CustomArray customArray = CustomArray.newCustomArrayBuilder()
				.setArray(new int[] {5, 1, 2, 3})
				.setCustomArrayId(1)
				.build();
		List<CustomArray> expected = new ArrayList<>();
		expected.add(customArray);
		CustomArrayIdSpecificator specificator = new CustomArrayIdSpecificator(1); 
		List<CustomArray> actual = repository.query(specificator);
		
		assertEquals(expected, actual);
	}
}
