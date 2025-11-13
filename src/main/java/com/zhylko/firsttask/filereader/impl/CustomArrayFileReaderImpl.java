package com.zhylko.firsttask.filereader.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.zhylko.firsttask.exception.CustomArrayException;
import com.zhylko.firsttask.filereader.CustomArrayFileReader;

public class CustomArrayFileReaderImpl implements CustomArrayFileReader{

	@Override
	public List<String> readCustomArrayFile(String filename) throws CustomArrayException {
		Path filepath = Paths.get(DATA_DIRECTORY, filename);
		
		if(!Files.exists(filepath)) {
			throw new CustomArrayException("Input file does not exist");
		}
		
		List<String> customArrayList = new ArrayList<>();
		try {
			customArrayList = Files.readAllLines(filepath);
			if(customArrayList.isEmpty()) {
				throw new CustomArrayException("Empty file error");
			}
			return customArrayList;
		} catch(IOException e){
			throw new CustomArrayException("File error");
		}
	}

}
