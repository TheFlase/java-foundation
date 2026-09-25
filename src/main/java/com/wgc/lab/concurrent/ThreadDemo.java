package com.wgc.lab.concurrent;


import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by Administrator on 6/29/2018.
 */
public class ThreadDemo {

    public static void main(String[] args) throws Exception{
        MyThread myThread = new MyThread();
        FutureTask<String> futureTaskA = new FutureTask<String>(myThread);
        FutureTask<String> futureTaskB = new FutureTask<String>(myThread);
        FutureTask<String> futureTaskC = new FutureTask<String>(myThread);
        new Thread(futureTaskA,"竞赛者A").start();
        new Thread(futureTaskB,"竞赛者B").start();
        new Thread(futureTaskC,"竞赛者C").start();
        System.out.println(futureTaskA.get());
        System.out.println(futureTaskB.get());
        System.out.println(futureTaskC.get());
    }

}


class MyThread implements Callable<String>{
    private boolean flag = false;
    @Override
    public String call() throws Exception {
        synchronized (this) {
            if(this.flag == false){
                this.flag = true;
                return Thread.currentThread().getName()+"抢答成功！";
            }else {
                return Thread.currentThread().getName()+"抢答失败！";
            }
        }
    }
}



