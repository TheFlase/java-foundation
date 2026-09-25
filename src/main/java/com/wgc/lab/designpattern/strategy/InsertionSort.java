package com.wgc.lab.designpattern.strategy;

import java.util.Arrays;

/**
 * Created by Administrator on 8/14/2018.
 */
public class InsertionSort implements StrategySort {
    @Override
    public int[] sort(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int j;
            int temp = arr[i];
            for (j = i; j > 0; j--) {
                if (arr[j - 1] > temp) {
                    arr[j] = arr[j - 1];

                } else
                    break;
            }
            arr[j] = temp;
        }
        System.out.println("插入排序");
        return arr;
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 4, 5, 3, 15, 10};
        BubbleSort b = new BubbleSort();
        System.out.println(Arrays.toString(b.sort(a)));
    }
}
