package com.wgc.lab.concurrent.syncvolatile;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 4/10/2019
 **/
public class Demo03 {
    private int count = 10;

    public synchronized void test() {//等同于synchronized(this)，锁定的是Demo03对象的实例
        count--;
        System.out.println(Thread.currentThread().getName() + " count =" + count);
    }
    /**
     * 1.synchronized关键字修饰普通方法等同于synchronized(this)
     */
}
