package com.wgc.lab.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileReaderUtil {
	public static void main(String[] args) {
		try {
			String encoding = "GB2312"; // 字符编码(可解决中文乱码问题 )   
			File f = new File("d:/b.txt");
			if(f.isFile() && f.exists()){
				InputStreamReader reader = new InputStreamReader(new FileInputStream(f),encoding);
				BufferedReader bufferedReader = new BufferedReader(reader);
				String lineTxt = null;
				int i = 0;
				while((lineTxt = bufferedReader.readLine())!= null){
					++i;
					System.out.println("当前是第"+i+"行，数据内容是:"+lineTxt);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
