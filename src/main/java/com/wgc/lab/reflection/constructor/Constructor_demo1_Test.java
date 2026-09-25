package com.wgc.lab.reflection.constructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author wgc
 * @Description
 * @Date 4/13/2020
 **/
public class Constructor_demo1_Test {
    public static void main(String[] args) {
        Constructor_demo1 c = new Constructor_demo1("10","20","30");
        Class clazz = c.getClass();
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (int i = 0; i < declaredConstructors.length; i++) {
            Constructor constructor = declaredConstructors[i];
            System.out.println("查看是否允许带有可变数量的参数："+constructor.isVarArgs());
            System.out.println("该构造方法的入口参数类型依次为：");
            Class[] parameterTypes = constructor.getParameterTypes();
            for (int j = 0; j < parameterTypes.length; j++) {
                System.out.println(" "+parameterTypes[j]);
            }
            System.out.println("该构造方法可能抛出的异常为：");
            Class[] exceptionTypes = constructor.getExceptionTypes();
            for (Class item:exceptionTypes) {
                System.out.println(" "+item);
            }
            Constructor_demo1 constructor_demo1 = null;
            while (constructor_demo1 == null){
                try {
                    if(i==2){
                        constructor_demo1 = (Constructor_demo1) constructor.newInstance();
                    }else if(i==1){
                        constructor_demo1 = (Constructor_demo1) constructor.newInstance("7",5);
                    }else {
                        Object[] parameters = new Object[]{new String[]{"100","200","300"}};
                        constructor_demo1 = (Constructor_demo1) constructor.newInstance(parameters);
                    }
                }catch(Exception e) {
                    System.out.println("在创建对象时抛出异常,下面执行setAccessible()方法");
                    constructor.setAccessible(true);
                }
            }
            constructor_demo1.print();
            System.out.println();
        }
    }
}
