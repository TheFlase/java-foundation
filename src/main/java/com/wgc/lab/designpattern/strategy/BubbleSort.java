package com.wgc.lab.designpattern.strategy;

import java.util.Arrays;

/**
 * Created by Administrator on 8/14/2018.
 */
public class BubbleSort implements StrategySort {
    @Override
    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = 0;
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("冒泡排序");
        return arr;
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 4, 5, 3, 15, 10};
        BubbleSort b = new BubbleSort();
        System.out.println(Arrays.toString(b.sort(a)));
    }
}
