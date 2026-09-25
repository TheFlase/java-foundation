package com.wgc.lab.collection;


import java.util.Arrays;

/**
 * Created by Administrator on 3/15/2018.
 */
public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
        myArrayList.add(5);
        myArrayList.add(4);
        myArrayList.add(3);
        myArrayList.add(2);
        myArrayList.add(6);

        System.out.println("size:"+myArrayList.size());
        System.out.println("all the elements is :"+ Arrays.toString(myArrayList.elements));
        System.out.println(" 获取指定下标的元素 \n "+myArrayList.get(0));
        System.out.println(" 获取指定下标的元素 \n "+myArrayList.get(4));
        myArrayList.add(0,10);
        System.out.println("after insert the elements :"+ Arrays.toString(myArrayList.elements));

        myArrayList.remove(0);
        System.out.println("after remove the special elements :"+ Arrays.toString(myArrayList.elements));

        System.out.println(myArrayList.hasNext());
        System.out.println("使用自定义的迭代器遍历:");
        while (myArrayList.hasNext()) {
            System.out.println(myArrayList.next()+"\t");
        }

        System.out.println("\n 是否包含:"+myArrayList.contains(7));
        System.out.println("\n 移除:"+myArrayList.removeObj(5));
        System.out.println(myArrayList.hasNext());
        System.out.println("使用自定义的迭代器遍历:");
        while (myArrayList.hasNext()) {
            System.out.println(myArrayList.next()+"\t");
        }

        System.out.println("\n toString:"+myArrayList.toString());


    }
}
