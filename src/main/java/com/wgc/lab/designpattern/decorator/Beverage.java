package com.wgc.lab.designpattern.decorator;

/**
 * 抽象组件 Component
 * Created by Administrator on 8/16/2018.
 */
public abstract class Beverage {

    protected String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
