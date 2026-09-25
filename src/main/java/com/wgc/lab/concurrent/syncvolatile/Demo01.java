package com.wgc.lab.concurrent.syncvolatile;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 4/10/2019
 **/
public class Demo01 {
    private int count = 10;
    private Object object = new Object();

    public void test(){
        synchronized (this){
            //任何线程要执行下面的代码，必须先拿到object对象的锁
            count--;
            System.out.println(Thread.currentThread().getName()+"count = "+ count);
        }
    }

    public static void main(String[] args) {
        Demo01 demo01 = new Demo01();
        new Thread(()->demo01.test()).start();
        new Thread(()->demo01.test()).start();
    }

    /**
     * 1.synchronized关键字锁定的是对象不是代码块,demo中锁的是object对象的实例（堆内存中）
     * 2.锁定的对象有两种情况：①类的实例 ②类的字节码(.class)
     * 3.关于线程安全：加synchronized关键字之后不一定能实现线程安全，具体还要看
     * 锁定的对象是否唯一。
     */
}
