package com.wgc.lab.interview.thread;

/**
 * @Author wgc
 * @Description //join实现多线程顺序执行
 * @Date 2020/10/13
 **/
public class OrderExecutor {
    public static void main(String[] args) {
        Thread t1= new Thread(new MyOrderThread(null),"T1");
        Thread t2= new Thread(new MyOrderThread(t1),"T2");
        Thread t3= new Thread(new MyOrderThread(t2),"T3");
        t1.start();
        t3.start();
        t2.start();

    }
    static class MyOrderThread implements Runnable {
        private Thread previous;

        public MyOrderThread(Thread previous) {
            this.previous = previous;
        }

        @Override
        public void run() {
            if(null != previous){
                try {
                    previous.join();
                    System.out.println("Current Thread is:"+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                System.out.println("Current Thread is:"+Thread.currentThread().getName());
            }
        }
    }
}
