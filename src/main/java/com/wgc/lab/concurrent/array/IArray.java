package com.wgc.lab.concurrent.array;

/**
 * @Author wgc
 * @Description
 * @Date 2020/6/24
 **/
public interface IArray {

    int indexOf(Object o);
    Object copyFrom(int desPos, IArray src, int srcPos, int lenght);
    Object getAt(int index);
    Object setAt(int index, Object o);
    int length();

    boolean add(Object obj);
}
