package com.zhylko.firsttask.filereader.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import com.zhylko.firsttask.exception.CustomArrayException;

class CustomArrayFileReaderImplTest {
	
	CustomArrayFileReaderImpl fileReader = new CustomArrayFileReaderImpl(); 

	@Test
	void readCustomArrayFileWrongFilepath() throws CustomArrayException {
		String filepath = "nonExistent";
		assertThrows(CustomArrayException.class, () -> {fileReader.readCustomArrayFile(filepath);});
	}

	@Test
	void readCustomArrayFileEmptyFile(@TempDir Path tempDir) throws CustomArrayException {
		Path testFile = tempDir.resolve("test.txt");
		try {
			Files.createFile(testFile);
		} catch(IOException e) {
			fail("cannot create test file");
		}
		String filepath = "nonExistent";
		assertThrows(CustomArrayException.class, () -> {fileReader.readCustomArrayFile(filepath);});
	}
}
