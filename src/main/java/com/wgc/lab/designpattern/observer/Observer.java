package com.wgc.lab.designpattern.observer;

/**
 * 观察者接口
 * Created by Administrator on 8/14/2018.
 */
public interface Observer {

    /**
     *
     * @param temperature 温度
     * @param humidity 湿度
     * @param pressure 气压
     */
    public void update(float temperature, float humidity, float pressure);
}
