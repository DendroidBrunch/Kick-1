package com.zhylko.firsttask.parser.impl;

import java.util.ArrayList;
import java.util.List;

import com.zhylko.firsttask.parser.CustomArrayParser;

public class CustomArrayParserImpl implements CustomArrayParser{

	@Override
	public List<String[]> parse(List<String> stringsToParse) {
		List<String[]> parsedList = new ArrayList<>();
		
		for(String stringToParse : stringsToParse) {
			String beforeTrim = stringToParse.replaceAll(DATA_DELIMITERS_REGEX, " ");
			String trimmed = beforeTrim.trim();
			String [] parsedString = trimmed.split(" ");
			parsedList.add(parsedString);
		}
		
		return parsedList;
	}

}
