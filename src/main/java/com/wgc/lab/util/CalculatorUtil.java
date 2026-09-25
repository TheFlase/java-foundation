package com.wgc.lab.util;

import java.io.UnsupportedEncodingException;

public class CalculatorUtil {
	public static void main(String[] args) throws Exception {
		String b = "缈�";
		String e = "翁";
		System.out.println(b.getBytes().length+"e==="+e);
		
		System.out.println("=========");
		System.out.println(System.getProperty("file.encoding"));
		String a = "缈�";
		byte[] c = a.getBytes("utf-8");
//		String d = new String(c,"gb2312");
		String d = new String(c,"utf-8");
		System.out.println("d=="+d+"瀵瑰���瀛�����:"+d.getBytes().length);
	}
}
