package com.wgc.lab.designpattern.strategy;

import java.util.Arrays;

/**
 * Created by Administrator on 8/14/2018.
 */
public class StrategyTest {
    public static void main(String[] args) {
        int arr[]={1,4,6,2,5,3,7,10,9};
        int result[];
        ArrayHandler ah = new ArrayHandler();
        StrategySort bubbleSort = new BubbleSort();
        ah.setSort(bubbleSort);
        ah.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
