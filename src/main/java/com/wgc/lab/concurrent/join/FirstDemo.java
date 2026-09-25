package com.wgc.lab.concurrent.join;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 2020/10/6
 **/
public class FirstDemo {
    public static void main(String[] args) throws Exception{
        Thread mainThread = Thread.currentThread();
        Thread thread = new Thread(()->{
            for(int i=0;i<50;i++) {
                if(i == 3){
                    try {
                        mainThread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"执行、x="+i);
            }
        },"玩耍的线程");

        thread.start();
        for(int j=0;j<50;j++) {
            Thread.sleep(100);
            System.out.println("【霸道的线程】number:"+j);
        }
    }
}
class Producter implements Runnable{
    private Object obj;

    public Producter(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        synchronized (obj){
            try {
                obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
