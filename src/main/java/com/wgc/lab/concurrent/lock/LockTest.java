package com.wgc.lab.concurrent.lock;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 2020/6/23
 **/
public class LockTest {

    public static void main(String[] args) {
        MyService service = new MyService();
        MyThreadA a = new MyThreadA(service);
        a.setName("a");
        MyThreadB b = new MyThreadB(service);
        b.setName("b");
        a.start();
        b.start();
        try {
            Thread.currentThread().wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
