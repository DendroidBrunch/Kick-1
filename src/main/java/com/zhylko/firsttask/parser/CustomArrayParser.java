package com.zhylko.firsttask.parser;

import java.util.List;

public interface CustomArrayParser {
	String DATA_DELIMITERS_REGEX = "[\\Q [],.;\\/|\\E]+";
	
	List<String[]> parse(List<String> stringsToParse);
}
