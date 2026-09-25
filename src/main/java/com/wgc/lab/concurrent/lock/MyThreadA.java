package com.wgc.lab.concurrent.lock;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 2020/6/23
 **/
public class MyThreadA extends Thread{
    private MyService service;

    public MyThreadA(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            service.set();
        }
    }
}
