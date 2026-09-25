package com.wgc.lab.designpattern.decorator;

/**
 * 具体装饰类
 * Created by Administrator on 8/16/2018.
 */
public class Soy extends CondimentDecorator{

    private Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " , Soy";
    }

    @Override
    public double cost(){
        return  beverage.cost() + 0.10;
    }
}
