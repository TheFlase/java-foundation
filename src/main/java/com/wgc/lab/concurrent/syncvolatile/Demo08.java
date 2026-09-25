package com.wgc.lab.concurrent.syncvolatile;

import java.util.concurrent.TimeUnit;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 4/10/2019
 **/
public class Demo08 {
    String name;
    double balance;

    public synchronized void set(String name, double balance) {
        this.name = name;
        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
    }

    public /**synchronized**/ double getBalance(String name) {
        return this.balance;
    }

    public static void main(String[] args) {
        Demo08 demo08 = new Demo08();
        new Thread(() -> demo08.set("zhangsan", 100.0)).start(); //JDK1.8新特性
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(demo08.getBalance("zhangsan"));
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(demo08.getBalance("zhangsan"));
    }

    /**
     * 对业务写方法加锁，同时也要对业务读方法加锁，否则容易产生脏读问题
     */
}
