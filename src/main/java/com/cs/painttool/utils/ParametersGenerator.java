package com.cs.painttool.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class ParametersGenerator {

	public static List<String> getParameters(String input) throws Exception {
		
		List<String> params = null;
		if(!StringUtils.isEmpty(input) && !"".equals(input.trim())) {
			
			input = input.trim();
			String inputs[] = input.split(" ");
			params = new ArrayList<String>();
			for(String str:inputs) {
				 str = str.trim();
				if(!StringUtils.isEmpty(str)) {
					params.add(str);
				}
			}
		} else {
			throw new Exception("The command is empty");
		}
		return params;
	}
}
