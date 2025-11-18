package com.zhylko.firsttask.repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.zhylko.firsttask.comparator.CustomArrayComparator;
import com.zhylko.firsttask.entity.CustomArray;
import com.zhylko.firsttask.exception.CustomArrayException;
import com.zhylko.firsttask.specification.CustomArraySpecificator;

public class CustomArrayRepository {
	private static CustomArrayRepository instance;
	private final List<CustomArray> customArrays = new ArrayList<>();
	
	private static final Logger logger = LogManager.getLogger();
	
	private CustomArrayRepository() {
	}
	
	public static CustomArrayRepository getInstance() {
		if(instance == null) {
			instance = new CustomArrayRepository();
		}
		return instance;
	}
	
	public boolean add(CustomArray customArray) throws CustomArrayException {
		if(customArray == null) {
			logger.log(Level.ERROR, "CustomArray error: trying to add null to repository");
			throw new CustomArrayException("Cannot add null to repository");
		}
		return customArrays.add(customArray);
	}
	
	public boolean remove(CustomArray customArray) throws CustomArrayException {
		if(customArray == null) {
			logger.log(Level.ERROR, "CustomArray error: trying to remove null from repository");
			throw new CustomArrayException("Cannot remove null from repository");
		}
		return customArrays.remove(customArray);
	}
	
	public CustomArray remove(int index) throws CustomArrayException {
		if(index < 0 || index > customArrays.size()) {
			logger.log(Level.ERROR, "CustomArray error: trying to remove from repository with illegal index: " + index);
			throw new CustomArrayException("Index out of bounds: " + index);
		}
		return customArrays.remove(index); 
	}
	
	public List<CustomArray> getCustomArrays(){
		return List.copyOf(customArrays);
	}
	
	public List<CustomArray> query(CustomArraySpecificator specificator){
		List<CustomArray> result = new ArrayList<>();
		for(CustomArray array : customArrays) {
			try {
				if(specificator.specify(array)) {
					result.add(array);
				}
			} catch(CustomArrayException e) {
				logger.log(Level.WARN, "Repository Query warning: " + e);
			}
		}
		return result;
	}
	
	public List<CustomArray> queryStream(CustomArraySpecificator specificator){
		return customArrays.stream()
				.filter(t -> {
			boolean result;
			try {
				result = specificator.specify(t);
			} catch (CustomArrayException e) {
				logger.log(Level.WARN, "Repository Query warning: " + e);
				result = false;
			}
			return result;
		})
				.toList();
	}
	
	public List<CustomArray> sort(CustomArrayComparator comparator){
		List<CustomArray> result = new ArrayList<>(customArrays);
		result.sort(comparator);
		return result;
	}
}
