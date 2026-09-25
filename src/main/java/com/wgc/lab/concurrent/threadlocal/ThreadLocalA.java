package com.wgc.lab.concurrent.threadlocal;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 2020/6/23
 **/
public class ThreadLocalA extends Thread{
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("当前线程是："+Thread.currentThread().getName()+"获取的值是:"
                        +ThreadLocalTool.t1.get());;
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
