package com.zhylko.firsttask.filereader;

import java.util.List;

import com.zhylko.firsttask.exception.CustomArrayException;

public interface CustomArrayFileReader {

	List<String> readCustomArrayFile(String filename) throws CustomArrayException;
}
