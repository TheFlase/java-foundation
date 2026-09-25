package com.wgc.lab.concurrent.lifecycle;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 10/2/2018
 **/
public class ThreadLifeTest {
    public static void main(String[] args) {
        System.out.println("主线程开始");
//        Thread t1 = new Thread(new ChildThread("子线程1"));
//        Thread t2 = new Thread(new ChildThread("子线程2"));
        Thread t1 = new Thread(new ChildThread(),"子线程1");
        Thread t2 = new Thread(new ChildThread(),"子线程2");
        t1.start();

        t2.start();
        System.out.println("主线程结束");
    }
}
class ChildThread implements Runnable{
//    private String threadName;
//    public ChildThread(String threadName) {
//        this.threadName = threadName;
//    }

    @Override
    public void run() {
//        System.out.println("子线程:"+this.threadName+"执行开始");
        System.out.println("子线程:"+Thread.currentThread().getName()+"执行开始");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("子线程:"+Thread.currentThread().getName()+"执行结束");
//        System.out.println("子线程"+this.threadName+"执行结束");
        return;
    }
}
