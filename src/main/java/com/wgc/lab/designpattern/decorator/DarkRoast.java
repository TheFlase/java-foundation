package com.wgc.lab.designpattern.decorator;

/**
 * 具体组件
 * Created by Administrator on 8/16/2018.
 */
public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "DarkRoast";
    }

    @Override
    public double cost() {
        return 1.08;
    }
}
