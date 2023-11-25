package com.wgc.Algorithm.bubblesort;

import java.util.Arrays;

/**
 * @Author 翁国超
 * @Description //
 * @Date 2023/2/27
 **/
public class BubbleSort {
    public static void main(String[] args) {
        int[] arry = {3,5,4,1,2,6};
//        int[] arry = {3,2,1};
//        BubbleSort.bubbleSort(arry);
//        BubbleSort.insertionSort(arry);
        BubbleSort.selectedSort(arry);
//        BubbleSort.test();
    }

    /**
     * 冒泡排序
     * @param array
     */
    static void bubbleSort(int[] array){
        if(array.length<=0){
            return;
        }
        System.out.println("排序前："+ Arrays.toString(array));
        int hasSort = 0;
        int count = 1;
        for(int i=0;i<array.length;i++){
            int temp;
            for (int j = 0; j < array.length-i-1; j++) {
                // 此处减i的目的：排好一次后，后面已排元素个数就一共增加多i个，如果不减i就导致多操作，浪费资源
                System.out.println("array.length-i-1 =>"+(array.length-i-1));
                if(array[j]>array[j+1]){
                    temp = array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                    hasSort = 1;
                }
            }
            if(hasSort==0){
                System.out.println("当前排序没有需要交换的元素，考虑退出循环！");
                break;
            }else {
                hasSort = 0;
            }
            count++;
        }
        System.out.println("排序后："+ Arrays.toString(array)+",排序次数："+count);
    }

    /**
     * 插入排序
     * @param array
     */
    static void insertionSort(int[] array){
        if(array.length==0 || array.length==1){
            // 改为小于等于1的数量，优化判断 if(array.length<=1)
            return;
        }
        System.out.println("排序前："+ Arrays.toString(array));
        /*for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if(array[i]<array[j+1] && array[i]>array[j]){
                    // 得出插入的位置，搬迁数据，break;
                    for (int k = j; k < i; k++) {
                        array[k]=array[i];
                        array[k+1] = array[k+2];
                    }
                    break;
                }else {
                    break;
                }
            }
        }*/


        for (int i = 1; i < array.length; i++) {
            int value = array[i];
            int j = i-1;
            for(;j>=0;j--){
                if(array[j]>value){
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            array[j+1] = value;
        }

        System.out.println("排序后："+ Arrays.toString(array));
    }

    /**
     * 选择排序
     * @param array
     */
    static void selectedSort(int[] array){
        if(array.length<=1){
            return;
        }
        System.out.println("排序前："+ Arrays.toString(array));
        for (int i = 1; i < array.length; i++) {
            int j = i-1;
            int mix = 0;
            int index = 0;
            for (; j< array.length-1 ; j++) {
                System.out.println("array[j]="+array[j]+",array[j+1]="+array[j+1]);
                if(array[j]>array[j+1]){
                    mix = array[j+1];
                    index = j+1;
                }
            }
            if(index != 0){
                array[index] = array[i-1];
                array[i-1] = mix;
            }

        }
        System.out.println("排序后："+ Arrays.toString(array));
    }

    static void test(){
        int j = 5;
        for(;j>=0;j--){
            System.out.println("j=="+j);
        }
    }
}
