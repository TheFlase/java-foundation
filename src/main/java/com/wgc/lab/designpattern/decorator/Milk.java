package com.wgc.lab.designpattern.decorator;

/**
 * 具体装饰类
 * Created by Administrator on 8/16/2018.
 */
public class Milk extends CondimentDecorator{

    private Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " , Milk";
    }

    @Override
    public double cost(){
        return  beverage.cost() + 0.3;
    }
}
