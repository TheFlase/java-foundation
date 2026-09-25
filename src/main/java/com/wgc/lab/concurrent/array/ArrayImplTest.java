package com.wgc.lab.concurrent.array;

/**
 * @Author wgc
 * @Description
 * @Date 2020/6/24
 **/
public class ArrayImplTest {
    public static void main(String[] args) {
        ArrayImpl myArray = new ArrayImpl();
        myArray.add(1);
        myArray.add(2);
        myArray.add(3);

        //测试查找
        System.out.println(myArray.indexOf(8));

        //测试复制
        ArrayImpl myArray2 = new ArrayImpl();
        myArray2.add(6);
        myArray2.add(7);
        ArrayImpl copyFrom = (ArrayImpl) myArray.copyFrom(0, myArray2, 0, 1);
        copyFrom.printString();

        //返回列表中指定位置的元素
        System.out.println(myArray2.getAt(1));

        //用指定元素替换列表中指定位置的元素，并返回原来的元素
        System.out.println("原来的值是:"+myArray2.setAt(0,88));
        myArray2.printString();

        //返回列表的大小
        System.out.println("myArray2列表的大小是:"+myArray2.length());
    }
}
