package com.wgc.lab.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体主题接口
 * Created by Administrator on 8/14/2018.
 */
public class WeatherData implements Subject{

    private List<Observer> observers;
    private float tempterature;
    private float pressure;
    private float humidity;

    public WeatherData() {
        observers = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if(i>=0){
            observers.remove(i);
        }
    }

    @Override
    public void notifyObserver() {
        for(int i=0;i<observers.size();i++){
            observers.get(i).update(this.tempterature,this.pressure,this.humidity);
        }
    }

    /**
     * 气象站得到更新的观测数据时，通知观察者
     */
    public void measurementChanged(){
        notifyObserver();
    }

    public void setMeasurements(float tempterature,float pressure,float humidity){
        this.tempterature = tempterature;
        this.pressure = pressure;
        this.humidity=humidity;
        measurementChanged();
    }
}
