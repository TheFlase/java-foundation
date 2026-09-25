package com.wgc.lab.interview.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author wgc
 * @Description //使用线程池实现线程顺序执行
 * @Date 2020/10/13
 **/
public class OrderExecutor5 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("current thread is:" + Thread.currentThread().getName()+" run 1");
            }
        }, "T1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("current thread is:" + Thread.currentThread().getName()+" run 2");
                    t1.join(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "T2");
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("current thread is:" + Thread.currentThread().getName()+" run 3");
                    t2.join(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "T3");

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(t1);
        executor.submit(t2);
        executor.submit(t3);
        executor.shutdown();
    }
}
