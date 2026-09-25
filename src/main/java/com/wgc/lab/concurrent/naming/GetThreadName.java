package com.wgc.lab.concurrent.naming;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 3/16/2020
 **/
public class GetThreadName {

    public static void main(String[] args) {
        Cat catThread = new Cat();
        catThread.start();
    }

}
class Cat extends Thread {
    public Cat() {
        System.out.println("------" + "构造函数开始" + "------");
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive() = " + Thread.currentThread().isAlive());
        System.out.println("this.getName() = " + this.getName());
        System.out.println("this.isAlive() = " + this.isAlive());
        System.out.println("Thread.currentThread() == this : " + (Thread.currentThread() == this));
        System.out.println("------" + "构造函数结束" + "------");

    }

    @Override
    public void run() {
        System.out.println("*******run start*********");
        System.out.println("Thread.currentThread.getName:"+Thread.currentThread().getName());
        System.out.println("Thread.CurrentThread.isAlive:"+Thread.currentThread().isAlive());
        System.out.println("this.getName:"+this.getName());
        System.out.println("this.isAlive:"+this.isAlive());
        System.out.println("Thread.currentThread() == this : " + (Thread.currentThread() == this));
        System.out.println("******run end**********");
    }
}
