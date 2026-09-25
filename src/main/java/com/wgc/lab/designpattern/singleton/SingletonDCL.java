package com.wgc.lab.designpattern.singleton;

/**
 * @Author wgc
 * @Description //DCL双重检查
 * @Date 2020/10/21
 **/
public class SingletonDCL {
    private static SingletonDCL instance;
    private SingletonDCL(){};
    public static SingletonDCL getInstance(){
        if(null != instance){
            synchronized (SingletonDCL.class){
                if(null != instance){
                    instance = new SingletonDCL();
                }
            }
        }
        return null;
    }
}
