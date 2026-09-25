package com.wgc.lab.designpattern.observer;

/**
 * 测试程序
 * Created by Administrator on 8/14/2018.
 */
public class ObserverTest {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();//具体主题
        new CurrentConditionDisplay(weatherData);//注册观察者

        //具体主题发生变化时,通知观察者
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 78, 40.4f);
    }

}
