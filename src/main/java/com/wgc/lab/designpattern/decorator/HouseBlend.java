package com.wgc.lab.designpattern.decorator;

/**
 * 具体组件
 * Created by Administrator on 8/16/2018.
 */
public class HouseBlend extends Beverage{

    public HouseBlend() {
        description = "HouseBlend";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
