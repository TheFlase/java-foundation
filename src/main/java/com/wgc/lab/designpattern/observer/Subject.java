package com.wgc.lab.designpattern.observer;

/**
 * 主题接口
 * Created by Administrator on 8/14/2018.
 */
public interface Subject {

    /**
     * 注册观察者
     *
     * @param observer
     */
    public void registerObserver(Observer observer);

    /**
     * 移除观察者
     *
     * @param observer
     */
    public void removeObserver(Observer observer);

    /**
     * 当主题发生变化时,这个方法需要被调用,以通知所有观察者
     */
    public void notifyObserver();
}
