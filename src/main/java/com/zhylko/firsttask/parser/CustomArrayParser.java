package com.zhylko.firsttask.parser;

import java.util.List;

public interface CustomArrayParser {
	String DATA_REGEX = ",.;/|\\[]";
	
	List<String[]> parseCustomArrayStringList(List<String> customArrayStringList);
}
