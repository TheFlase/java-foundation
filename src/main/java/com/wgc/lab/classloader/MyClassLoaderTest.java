package com.wgc.lab.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author wgc
 * @Description
 * @Date 4/23/2020
 **/
public class MyClassLoaderTest {
    public static void main(String[] args) {
        MyClassLoader myClassLoader = new MyClassLoader("d:/lib");
        try {
            Class<?> customDefindClass = myClassLoader.loadClass("com.wgc.base.classloader.Hello4ClassLoader");
            if(customDefindClass != null){
                Object obj = customDefindClass.newInstance();
                Method declaredMethod = customDefindClass.getDeclaredMethod("say", null);
                declaredMethod.invoke(obj,null);
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
