package com.zhylko.firsttask.parser.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.zhylko.firsttask.exception.CustomArrayException;

class CustomArrayParserImplTest {
	
	CustomArrayParserImpl parser = new CustomArrayParserImpl();

	@Test
	void parseOnlyDelimiters() throws CustomArrayException {
		List<String[]> expected = new ArrayList<>();
		expected.add(new String[] {""});
		List<String> token = new ArrayList<>();
		token.add(".,\\[]|/");
		List<String[]> actual = parser.parse(token);
		assertArrayEquals(expected.get(0), actual.get(0));
	}
	
	@Test
	void parseNoDelimiters() throws CustomArrayException {
		List<String[]> expected = new ArrayList<>();
		expected.add(new String[] {"ac45b"});
		List<String> token = new ArrayList<>();
		token.add("ac45b");
		List<String[]> actual = parser.parse(token);
		assertArrayEquals(expected.get(0), actual.get(0));
	}
	
	@Test
	void parseIllegalInput() throws CustomArrayException {
		List<String[]> expected = new ArrayList<>();
		expected.add(new String[] {"3", "-5", "1t1"});
		List<String> token = new ArrayList<>();
		token.add(",3;//-5.1t1");
		List<String[]> actual = parser.parse(token);
		assertArrayEquals(expected.get(0), actual.get(0));
	}

	@Test
	void parseDelimitersAndDigits() throws CustomArrayException {
		List<String[]> expected = new ArrayList<>();
		expected.add(new String[] {"4", "5", "3", "7", "9", "8"});
		List<String> token = new ArrayList<>();
		token.add(",4 5[3]7;.9\\|8,");
		List<String[]> actual = parser.parse(token);
		assertArrayEquals(expected.get(0), actual.get(0));
	}
}
