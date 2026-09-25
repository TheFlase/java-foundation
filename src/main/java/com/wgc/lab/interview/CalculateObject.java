package com.wgc.lab.interview;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Author wgc
 * @Description 显示对象头信息
 * @Date 2020/6/3
 **/
public class CalculateObject {
    public static void main(String[] args) {
        Object obj = new Object();
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        synchronized (obj){
            System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        }
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
    }
}
