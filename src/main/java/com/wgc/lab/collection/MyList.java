package com.wgc.lab.collection;

/**
 * desc:自定义list接口
 * Created by Administrator on 3/9/2018.
 */
public interface MyList<T> {
    /**
     * 是否为空集合
     * @return
     */
    public boolean isEmpty();


    /**
     * 获取大小
     * @return
     */
    public int size();

    /**
     * 默认添加到最后
     * @param e
     * @return
     */
    public boolean add(T e);


    /**
     * desc:添加元素到指定位置
     * @param e
     * @param index
     * @return
     */
    public boolean add(int index,T e);

    /**
     * 获取指定位置的元素
     * @param index
     * @return
     */
    public T get(int index);

    /**
     * 移除指定索引位置的元素
     * @param index
     * @return
     */
    public boolean remove(int index);


}
