package com.wgc.lab.concurrent.lock;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 2020/6/23
 **/
public class MyThreadB extends Thread{
    private MyService service;

    public MyThreadB(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            service.get();
        }
    }
}
