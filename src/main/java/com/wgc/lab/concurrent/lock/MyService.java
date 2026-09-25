package com.wgc.lab.concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author wgc
 * @Description
 * @Date 2020/6/23
 **/
public class MyService {
    private ReentrantLock lock =new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean hasValue = false;
    public void set(){
        try {
            lock.lock();
            while (hasValue == true){
                condition.await();
            }
            System.out.println("打印1"+Thread.currentThread().getName());
            hasValue = true;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void get(){
        try {
            lock.lock();
            while (hasValue == false){
                condition.await();
            }
            System.out.println("打印2"+Thread.currentThread().getName());
            hasValue = false;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
