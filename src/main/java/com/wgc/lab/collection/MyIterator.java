package com.wgc.lab.collection;

/**
 * desc:自定义迭代器接口
 * Created by Administrator on 3/9/2018.
 */
public interface MyIterator <T>{

    /**
     * 是否有下一个
     * @return
     */
    public boolean hasNext();

    /**
     * 下一个元素
     * @return
     */
    public T next();
}
