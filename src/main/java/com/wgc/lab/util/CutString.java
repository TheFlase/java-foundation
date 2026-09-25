package com.wgc.lab.util;

import java.io.UnsupportedEncodingException;

public class CutString {
	public static boolean isChineseChar(char c)
			   throws UnsupportedEncodingException { // 如果字节数大于1，是汉字 //
			  // 以这种方式区别英文字母和中文汉字并不是十分严谨，但在这个题目中，这样判断已经足够了
			  return String.valueOf(c).getBytes().length > 1;
			 }
			 
			 public static String substring(String orignal, int count)
			   throws UnsupportedEncodingException { // 原始字符不为null，也不是空字符串
			  if (orignal != null && !"".equals(orignal)) { // 将原始字符串转换为GBK编码格式
			   orignal = new String(orignal.getBytes()); // 要截取的字节数大于0，且小于原始字符串的字节数
			   if (count > 0 && count < orignal.getBytes().length) {
			    StringBuffer buff = new StringBuffer();
			    char c;
			    for (int i = 0; i < count; i++) {
			     // charAt(int index)也是按照字符来分解字符串的
			     c = orignal.charAt(i);
			     buff.append(c);
			     if (CutString.isChineseChar(c)) { // 遇到中文汉字，截取字节总数减1
			      --count;
			     }
			    }
			    return buff.toString();
			   }
			  }
			  return orignal;
			 }
			 public static void main(String[] args) { // 原始字符串
			  String s = "我ZWR爱JAVA";
			  System.out.println("原始字符串：" + s);
			  try {
			   System.out.println("截取前1位：" + CutString.substring(s, 1));
			   System.out.println("截取前2位：" + CutString.substring(s, 2));
			   System.out.println("截取前4位：" + CutString.substring(s, 4));
			   System.out.println("截取前6位：" + CutString.substring(s, 6));
			  } catch (UnsupportedEncodingException e) {
			   e.printStackTrace();
			  }
			 }
}
