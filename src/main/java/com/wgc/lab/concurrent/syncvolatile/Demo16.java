package com.wgc.lab.concurrent.syncvolatile;

import java.util.concurrent.TimeUnit;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 4/13/2019
 **/
public class Demo16 {
    int count = 0;

    public synchronized void test1() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//业务逻辑中只有下面这句需要sync，这时不应该给整个方法上锁
        count++;
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void test2() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//业务逻辑中只有下面这句需要sync，这时不应该给整个方法上锁
//采用细粒度的锁，可以是线程争用时间变短，从而提高效率
        synchronized (this) {
            count++;
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 1.业务逻辑中只有下面这句需要sync，这时不应该给整个方法上锁
     * 2.采用细粒度的锁，可以是线程争用时间变短，从而提高效率
     */
}
