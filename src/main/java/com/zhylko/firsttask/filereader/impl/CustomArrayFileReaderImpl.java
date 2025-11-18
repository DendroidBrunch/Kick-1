package com.zhylko.firsttask.filereader.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.zhylko.firsttask.exception.CustomArrayException;
import com.zhylko.firsttask.filereader.CustomArrayFileReader;

public class CustomArrayFileReaderImpl implements CustomArrayFileReader{
	
	private static final Logger logger = LogManager.getLogger();

	@Override
	public List<String> readCustomArrayFile(String filepath) throws CustomArrayException {
		Path path = Paths.get(filepath);
		
		if(!Files.exists(path)) {
			throw new CustomArrayException("Cannot access file: " + filepath);
		}
		
		List<String> customArrayList = new ArrayList<>();
		try {
			customArrayList = Files.readAllLines(path);
		} catch(IOException e){
			logger.log(Level.ERROR, "File error: " + e);
			throw new CustomArrayException("File error: " + e);
		}
		return customArrayList;
	}

}
