package com.wgc.lab.concurrent.syncvolatile;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 4/10/2019
 **/
public class Demo05 implements Runnable {

    private int count = 10;

    @Override
    public /* synchronized*/ void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) {
        Demo05 demo05 = new Demo05();
        for (int i = 0; i < 5; i++) {
            new Thread(demo05, "THREAD" + i).start();
        }
    }

    /**
     * 1.run()方法没加synchronized关键字时，多个线程同时访问count，线程是不安全的
     * 2.run()方法加上synchronized关键字后，锁定的是Demo05对象的实例，因为只创建了
     * 一个Demo05的实例，多个线程访问时都要拿到Demo05的锁标记才能执行，在多个线程同时访问时也是线程安全的
     */
}
