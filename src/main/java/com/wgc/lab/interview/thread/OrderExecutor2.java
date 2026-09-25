package com.wgc.lab.interview.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @Author wgc
 * @Description //CountDownLatch实现线程顺序执行
 * @Date 2020/10/13
 **/
public class OrderExecutor2 {
    public static void main(String[] args) {
        CountDownLatch c1 = new CountDownLatch(0);
        CountDownLatch c2 = new CountDownLatch(1);
        CountDownLatch c3 = new CountDownLatch(1);

        Thread t1 = new Thread(new MyCountDownLatch(c1,c2),"t1");
        Thread t2 = new Thread(new MyCountDownLatch(c2,c3),"t2");
        Thread t3 = new Thread(new MyCountDownLatch(c3,c3),"t3");
        t3.start();
        t2.start();
        t1.start();
    }
 static class MyCountDownLatch implements Runnable{
        CountDownLatch c1;
        CountDownLatch c2;

        public MyCountDownLatch(CountDownLatch c1, CountDownLatch c2) {
            this.c1 = c1;
            this.c2 = c2;
        }

        @Override
        public void run() {
            try {
                c1.await();
                System.out.println("Current thread is :"+Thread.currentThread().getName());
                c2.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
