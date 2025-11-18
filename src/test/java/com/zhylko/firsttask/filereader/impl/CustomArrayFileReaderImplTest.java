package com.zhylko.firsttask.filereader.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import com.zhylko.firsttask.exception.CustomArrayException;

class CustomArrayFileReaderImplTest {
	
	CustomArrayFileReaderImpl fileReader = new CustomArrayFileReaderImpl();
	String filepath = "test.txt";

	@Test
	void readCustomArrayFileWrongFilepath() throws CustomArrayException {
		assertThrows(CustomArrayException.class, () -> {fileReader.readCustomArrayFile(filepath);});
	}

	@Test
	void readCustomArrayFileEmptyFile(@TempDir Path tempDir) throws CustomArrayException {
		Path testFile = tempDir.resolve(filepath);
		try {
			Files.createFile(testFile);
		} catch(IOException e) {
			fail("Cannot create test file: " + e);
		}
		List<String> result = fileReader.readCustomArrayFile(testFile.toString());
		assertTrue(result.isEmpty());
	}
	
	@Test
	void readCustomArrayFileCorrectFile(@TempDir Path tempDir) throws CustomArrayException {
		List<String> expected = Arrays.asList("Line1", "Line 2", "3 line");
		Path testFile = tempDir.resolve(filepath);
		try {
			Files.write(testFile, Arrays.asList("Line1", "Line 2", "3 line"));
		} catch(IOException e) {
			fail("Cannot create test file: " + e);
		}
		List<String> actual = fileReader.readCustomArrayFile(testFile.toString());
		assertEquals(expected, actual);
	}
}
