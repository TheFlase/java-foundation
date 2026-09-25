package com.wgc.lab.concurrent.join;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 1/3/2019
 **/
public class JoinDemo extends Thread{
    int i;
    Thread previousThread;

    public JoinDemo(int i, Thread previousThread) {
        this.i = i;
        this.previousThread = previousThread;
    }

    @Override
    public void run() {
        try{
            previousThread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("num"+i);
    }

    public static void main(String[] args) {
        Thread previousThread = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            JoinDemo joinDemo = new JoinDemo(i,previousThread);
            joinDemo.start();
            previousThread = joinDemo;
        }
    }
}
