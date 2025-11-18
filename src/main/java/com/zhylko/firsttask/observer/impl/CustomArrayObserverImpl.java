package com.zhylko.firsttask.observer.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.zhylko.firsttask.entity.CustomArray;
import com.zhylko.firsttask.exception.CustomArrayException;
import com.zhylko.firsttask.observer.CustomArrayObserver;
import com.zhylko.firsttask.service.impl.CustomArrayServiceImpl;
import com.zhylko.firsttask.statistics.CustomArrayStatistics;
import com.zhylko.firsttask.warehouse.CustomArrayWarehouse;

public class CustomArrayObserverImpl implements CustomArrayObserver {
	
	private static final Logger logger  = LogManager.getLogger();
	
	@Override
	public void update(CustomArray customArray) {
		CustomArrayWarehouse warehouse = CustomArrayWarehouse.getInstance();
		CustomArrayServiceImpl service = new CustomArrayServiceImpl();
		try {
			CustomArrayStatistics statistics = new CustomArrayStatistics(
																										service.findMin(customArray).get(),
																										service.findMax(customArray).get(),
																										service.countSum(customArray).get(),
																										service.countAverage(customArray).get());
			
			warehouse.put(customArray.getCustomArrayId(), statistics);
		} catch(CustomArrayException e) {
			logger.log(Level.ERROR, "Error while updating warehouse: " + e);
		}
	}

}
