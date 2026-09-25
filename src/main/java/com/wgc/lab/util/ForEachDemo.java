package com.wgc.lab.util;

import java.util.HashMap;
import java.util.Map;

public class ForEachDemo {
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
		ForEachDemo.mapForEach(map);
	}
	
	/**
	 * 遍历map
	 */
	public static void mapForEach(Map<String, Object> map){
		if(null == map || map.size()<0){//map不为空的时候才可以使用map.isEmpty()
			System.out.println("Your map is null!"+map.isEmpty());
		}else{
			for(Map.Entry<String, Object> entry:map.entrySet()){
				System.out.println("Key = "+entry.getKey()+", value="+entry.getValue());
			}
		}
	}
	
	
	
}
