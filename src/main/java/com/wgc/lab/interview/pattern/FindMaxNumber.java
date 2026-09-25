package com.wgc.lab.interview.pattern;

import java.util.Arrays;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 3/5/2020
 **/
public class FindMaxNumber {
    public static void main(String[] args) {
        int[] tempArry={6,8,39,1,2,3};
        FindMaxNumber.findMaxNum(tempArry);
        FindMaxNumber.sortMp(tempArry);
    }
    public static void findMaxNum(int[] intArray){
        int max =0;
        for(int i=0;i<intArray.length;i++){
            System.out.println("当前的i是："+i);
            if(intArray[i]>max){
                max =intArray[i];
            }
        }
        System.out.println("数组中最大的数是:"+max);
    }

    public static void sortMp(int[] intArray){
        int temp = 0;
        for(int i=0;i<intArray.length;i++){
            for(int j=0;j<intArray.length-i-1;j++){
                if(intArray[j]>intArray[j+1]){
                    temp=intArray[j];
                    intArray[j] =intArray[j+1];
                    intArray[j+1]=temp;
                }
            }
        }
        System.out.println("冒泡排序的结果是:"+Arrays.toString(intArray));
    }
}
