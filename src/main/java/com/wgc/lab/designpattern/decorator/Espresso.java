package com.wgc.lab.designpattern.decorator;

/**
 * 具体组件
 * Created by Administrator on 8/16/2018.
 */
public class Espresso extends Beverage{

    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 0.99;
    }
}
