package com.wgc.lab.interview.thread;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author wgc
 * @Description //使用BlockingQueue
 * @Date 2020/10/13
 **/
public class OrderExecutor4 {
    public static void main(String[] args) {
        LinkedBlockingDeque<Thread> linkedBlockingDeque = new LinkedBlockingDeque<Thread>();
        Thread t1 = new Thread(new Work(), "T1");
        Thread t2 = new Thread(new Work(), "T2");
        Thread t3 = new Thread(new Work(), "T3");

        linkedBlockingDeque.add(t1);
        linkedBlockingDeque.add(t2);
        linkedBlockingDeque.add(t3);

        for (int i = 0; i < 3; i++) {
            try {
                Thread thread = linkedBlockingDeque.take();
                thread.start();
                while (thread.isAlive());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static class Work implements Runnable{
        @Override
        public void run() {
            System.out.println("thread start:" + Thread.currentThread().getName());
        }
    }
}
