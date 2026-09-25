package com.wgc.lab.concurrent.syncvolatile;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Author wgc
 * @Description
 *
 * /**
 *  * 曾经的面试题：（淘宝？）
 *  * 实现一个容器，提供两个方法，add，size
 *  * 写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到5个时，线程2给出提示并结束
 *  *
 *  * 给lists添加volatile之后，t2能够接到通知，但是，t2线程的死循环很浪费cpu，如果不用死循环，该怎么做呢？
 *  *
 *  * 这里使用wait和notify做到，wait会释放锁，而notify不会释放锁
 *  * 需要注意的是，运用这种方法，必须要保证t2先执行，也就是首先让t2监听才可以
 *  *
 *  * 阅读下面的程序，并分析输出结果
 *  * 可以读到输出结果并不是size=5时t2退出，而是t1结束时t2才接收到通知而退出
 *  * 想想这是为什么？
 *  */
public class MyContainer2 {
    //添加volatile，使t2能够得到通知
    volatile List lists = new ArrayList();

    public void add(Object o) {
        lists.add(o);
    }

    public static void main(String[] args) {
        MyContainer2 myContainer1 = new MyContainer2();
        final Object object = new Object();
        CountDownLatch countDownLatch = new CountDownLatch(1);

        new Thread(()->{
            System.out.println("t2启动。。");
            if(myContainer1.lists.size() !=5){
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t2结束。。");
        },"t2").start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            System.out.println("t1启动。。");
            for(int i=0;i<10;i++){
                myContainer1.lists.add(new Object());
                System.out.println("当前的list的大小是:"+myContainer1.lists.size());
                if(i==4){
                    countDownLatch.countDown();
                    break;
                }
            }
            System.out.println("t1结束。。");
        },"t1").start();

    }
}
