package com.wgc.lab.designpattern.strategy;

/**
 * Created by Administrator on 8/14/2018.
 */
public class ArrayHandler {
    private StrategySort sort;

    public int[] sort(int[] arr){
        sort.sort(arr);
        return arr;
    }

    public void setSort(StrategySort sort) {
        this.sort = sort;
    }
}
