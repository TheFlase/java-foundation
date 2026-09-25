package com.wgc.lab.interview.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author wgc
 * @Description //CachedThreadPool实现线程顺序执行
 * @Date 2020/10/13
 **/
public class OrderExecutor3 {
    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask<>(new work(null));
        Thread t1 = new Thread(futureTask,"T1");

        FutureTask<Integer> future2 = new FutureTask<>(new work(futureTask));
        Thread t2 = new Thread(future2,"T2");

        FutureTask<Integer> future3= new FutureTask<>(new work(future2));
        Thread t3 = new Thread(future3,"T3");

        t1.start();
        t2.start();
        t3.start();
    }

    static class work implements Callable<Integer> {
        private FutureTask<Integer> beforeFutureTask;

        public work(FutureTask<Integer> beforeFutureTask) {
            this.beforeFutureTask = beforeFutureTask;
        }

        @Override
        public Integer call() throws Exception {
            if(null !=  beforeFutureTask){
                Integer result = beforeFutureTask.get();
                System.out.println("Current Thread is :"+Thread.currentThread().getName());
            }else {
                System.out.println("Current Thread is :"+Thread.currentThread().getName());
            }
            return 0;
        }
    }
}
