package com.wgc.lab.concurrent.deadlock;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 1/1/2019
 **/
public class DeadLockDemo {
    private final Object lockA = new Object();
    private final Object lockB = new Object();
    private void deadLock(){
        new Thread(()->{
            synchronized (lockA){
                try {
                    Thread.sleep(4000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

                synchronized (lockB){
                    System.out.println("Lock B");
                }
            }
        }).start();

        new Thread(()->{
            synchronized (lockB){
                synchronized (lockA){
                    System.out.println("Lock A");
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }
}
