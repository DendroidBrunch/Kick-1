package com.zhylko.firsttask.filereader;

import java.util.List;

import com.zhylko.firsttask.exception.CustomArrayException;

public interface CustomArrayFileReader {
	final String DATA_DIRECTORY = "data";
	
	List<String> readCustomArrayFile(String Filename) throws CustomArrayException;
}
