package com.wgc.lab.concurrent.naming;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 3/16/2020
 **/
public class InterruptThreadTest {
    public static void main(String[] args) {
        try {
            MyThread myThread = new MyThread();
            myThread.start();
            myThread.join();
            Thread.sleep(200);
            myThread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end!");
    }
}
class MyThread extends Thread{
    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0; i < 500000; i++) {
                if(this.isInterrupted()){
                    System.out.println("已经是停止状态，我要退出了");
                    throw new InterruptedException();
                }
                System.out.println("i="+(i+1));
            }
            System.out.println("我在for下面");
        } catch (InterruptedException e) {
            System.out.println("进入"+Thread.currentThread().getName()+"的run()方法了！");
            e.printStackTrace();
        }
    }
}
