package com.zhylko.firsttask.parser.impl;

import java.util.ArrayList;
import java.util.List;

import com.zhylko.firsttask.parser.CustomArrayParser;

public class CustomArrayParserImpl implements CustomArrayParser{

	@Override
	public List<String[]> parseCustomArrayStringList(List<String> customArrayStringList) {
		List<String[]> parsedList = new ArrayList<>();
		
		for(String customArrayString : customArrayStringList) {
			String [] parsedString = customArrayString.split(DATA_REGEX);
			parsedList.add(parsedString);
		}
		
		return parsedList;
	}

}
