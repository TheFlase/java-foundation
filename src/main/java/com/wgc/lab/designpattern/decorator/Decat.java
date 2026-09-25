package com.wgc.lab.designpattern.decorator;

/**
 * Created by Administrator on 8/16/2018.
 */
public class Decat extends Beverage{
    public Decat() {
        description="Decat";
    }

    @Override
    public double cost() {
        return 0.99;
    }
}
