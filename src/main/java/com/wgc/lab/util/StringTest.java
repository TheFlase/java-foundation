package com.wgc.lab.util;

public class StringTest {
	
	
	/**
	 * 1.判断字符串是否相等 equals()、equalsIgnoreCase()
	 * 2.字符串比较
	 * 3.转换大小写 toUpperCase(),toLowerCase()
	 */
	public static void main(String[] args) {
//		System.out.println(StringTest.comPareTo("we", "wf"));
//		StringTest.splitTest("abc,def,ghi,gki", ",", 3);
		StringTest.regexTest("11234567890");
	}
	
	public static void indexMethod(){
		String str = "We are students";
		int size = str.lastIndexOf("");
		int size1 = str.indexOf("");
		System.out.println(size+"  "+size1);
		System.out.println(str.charAt(2));//获取指定下标的字符串
		System.out.println(str.substring(2));//从指定下标到最后
		System.out.println(str.substring(3,5));//指定下标到endIndex下标之间
	}
	
	public static int comPareTo(String str1,String str2){
		return str1.compareTo(str2);
	}
	
	public static void splitTest(String str,String sign ,int limit){
		String[] strContext =str.split(sign,limit); 
		if(strContext.length>0){
			int i=1;
			for(String s:strContext){
				System.out.println("第"+i+"次拆分的结果是："+s);
				i++;
			}
		}
	}
	
	public static void regexTest(String str){
		/**
		 * 移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
		　　联通：130、131、132、152、155、156、185、186
		　　电信：133、153、180、189、（1349卫通）
		
		 */
		
		String regExp = "^[1]([3][0-9]{1}|59|58|88|89)[0-9]{8}$";
		System.out.println(str.matches(regExp));
	}
}
