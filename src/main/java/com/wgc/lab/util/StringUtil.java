package com.wgc.lab.util;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class StringUtil {
	public static void main(String[] args) throws Exception {
		String b = null;
		if(!StringUtils.isBlank(b)){
			System.out.println("b is not null");
		}else {
			System.out.println("b is null");
		}
		Map<String,Object> param = new HashMap<>();
	}
}
