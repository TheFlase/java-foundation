package com.wgc.lab.designpattern.singleton.enumsingleton;

import java.lang.reflect.Constructor;

/**
 * @Author wgc
 * @Description //枚举单例
 * @Date 2020/10/21
 **/
public enum EnumPattern {
    instance1("wgc1",30),instance2("wgc2",31);
    private String name;
    private int age;

    EnumPattern(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) throws Exception{
        EnumPattern enumPattern1 = EnumPattern.instance1;
        System.out.println(enumPattern1.getName());
        EnumPattern enumPattern2 = EnumPattern.instance1;
        System.out.println(enumPattern1);
        System.out.println(enumPattern2);
        System.out.println(enumPattern2.equals(enumPattern1));
    }
}
