package com.wgc.lab.designpattern.strategy;

/**
 * Created by Administrator on 8/14/2018.
 */
public class SelectionSort implements StrategySort{
    @Override
    public int[] sort(int[] arr) {
        int len = arr.length;
        int temp;
        for (int i = 0; i < len; i++) {
            temp = arr[i];
            int j;
            int samllestLocation = i;
            for (j = i + 1; j < len; j++) {
                if (arr[j] < temp) {
                    temp = arr[j];
                    samllestLocation = j;
                }
            }
            arr[samllestLocation] = arr[i];
            arr[i] = temp;
        }
        System.out.println("选择排序");
        return arr;
    }
}
