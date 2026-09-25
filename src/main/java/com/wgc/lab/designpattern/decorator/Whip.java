package com.wgc.lab.designpattern.decorator;

/**
 * Created by Administrator on 8/16/2018.
 */
public class Whip extends CondimentDecorator{
    private Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " , Whip";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.2;
    }
}
