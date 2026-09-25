package com.wgc.lab.concurrent.syncvolatile;

import java.util.concurrent.TimeUnit;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 4/12/2019
 **/
public class Demo10 {
    synchronized void test(){
        System.out.println("test start........");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test end........");
    }
    public static void main(String[] args) {
        new Demo10Sun().test();
    }
}

class Demo10Sun extends Demo10{
    @Override
    synchronized void test() {
        System.out.println("child test start.......");
        super.test();
        System.out.println("child test end.......");
    }
}

/**
 * 一个同步方法可以调用另一个同步方法，一个线程已经拥有某个对象的锁，
 * 再次申请的时候仍然会得到该对象的锁
 * 也就是说synchronized获得的锁是可重入的（这里是继承中有可能发生的情形，子类调用父类的同步方法）
 */
