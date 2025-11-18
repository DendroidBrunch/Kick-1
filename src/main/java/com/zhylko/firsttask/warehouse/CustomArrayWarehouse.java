package com.zhylko.firsttask.warehouse;

import java.util.HashMap;
import java.util.Map;

import com.zhylko.firsttask.statistics.CustomArrayStatistics;

public class CustomArrayWarehouse {
	private static CustomArrayWarehouse instance;
	private final Map<Long, CustomArrayStatistics> statistics = new HashMap<>();
	
	private CustomArrayWarehouse() {
	}
	
	public static CustomArrayWarehouse getInstance() {
		if(instance == null) {
			instance = new CustomArrayWarehouse();
		}
		return instance;
	}
	
	public CustomArrayStatistics put(long id, CustomArrayStatistics newStatistics) {
		return statistics.put(id, newStatistics);
	}
	
	public void remove(long id) {
		statistics.remove(id);
	}
	
	public CustomArrayStatistics getStatistics(long id) {
		return statistics.get(id);
	}
}
