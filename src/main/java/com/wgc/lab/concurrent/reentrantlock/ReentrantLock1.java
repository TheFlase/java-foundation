package com.wgc.lab.concurrent.reentrantlock;

import java.util.concurrent.TimeUnit;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 4/13/2019
 **/
public class ReentrantLock1 {
    synchronized void m1() {
        for(int i=0; i<10; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("CurrentThread's name"+Thread.currentThread().getName()+",and i is:"+i);
        }

    }

    synchronized void m2() {
        System.out.println("CurrentThread's name"+Thread.currentThread().getName()+":m2 ...");
    }

    public static void main(String[] args) {
        ReentrantLock1 rl = new ReentrantLock1();
        new Thread(rl::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(rl::m2).start();
    }
}
