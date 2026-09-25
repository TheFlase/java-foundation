package com.wgc.lab.designpattern.singleton;

import java.lang.reflect.Constructor;

/**
 * @Author wgc
 * @Description //静态内部类实现单例模式
 * 很多种单例的写法都有一个通病，就是无法防止反射机制的漏洞，从而无法保证对象的唯一性
 * @Date 2020/10/21
 **/
public class SingletonInner {
    private static SingletonInner instance;
    private SingletonInner(){}
    public SingletonInner getInstance(){
        return SimgleInnerHolder.innerInstance;
    }
    private static class SimgleInnerHolder{
        private static final SingletonInner innerInstance = new SingletonInner();
    }

    public static void main(String[] args) throws Exception{
        //获得构造器
        Constructor constructor = SingletonInner.class.getDeclaredConstructor();
        //设置为可访问
        constructor.setAccessible(true);
        SingletonInner instance1 = (SingletonInner) constructor.newInstance();
        SingletonInner instance2 = (SingletonInner) constructor.newInstance();

        System.out.println(instance1);
        System.out.println(instance2);
        System.out.println(instance2.equals(instance1));

    }

}

