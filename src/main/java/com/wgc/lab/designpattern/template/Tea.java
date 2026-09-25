package com.wgc.lab.designpattern.template;

/**
 * Created by Administrator on 8/14/2018.
 */
public class Tea extends CaffeineBeverageWithHook{
    @Override
    void brew() {
        System.out.println("Steeping the tea...");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Lemon...");
    }
}
