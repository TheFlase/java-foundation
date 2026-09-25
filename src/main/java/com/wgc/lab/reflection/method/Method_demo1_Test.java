package com.wgc.lab.reflection.method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author wgc
 * @Description
 * @Date 4/18/2020
 **/
public class Method_demo1_Test {
    public static void main(String[] args) {
        Method_demo1 method_demo1 = new Method_demo1();
        Class methodExample = method_demo1.getClass();
        Method[] declaredMethods = methodExample.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            Method method = declaredMethods[i];
            System.out.println("名称为:"+method.getName());
            System.out.println("是否允许带有可变数量的参数:"+method.isVarArgs());
            System.out.println("入口参数类型依次为: ");
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (int j = 0; j < parameterTypes.length; j++) {
                System.out.println(" " + parameterTypes[j]);
            }
            System.out.println("方法的返回值类型为:"+method.getReturnType());
            System.out.println("可能抛出的异常类型有:");
            Class<?>[] exceptionTypes = method.getExceptionTypes();
            for (int j = 0; j < exceptionTypes.length; j++) {
                System.out.println(" " + exceptionTypes[j]);
            }

            boolean isTurn = true;
            while (isTurn){
                try {
                    isTurn = false;
                    if("staticMethod".equals(method.getName())){
                        method.invoke(method_demo1);
                    }else if("publicMethod".equals(method.getName())){
                        System.out.println("返回值为:"+method.invoke(method_demo1,199));
                    }else if("protectedMethod".equals(method.getName())){
                        System.out.println("返回值为："+method.invoke(method_demo1,"4",5));
                    }else if("privateMethod".equals(method.getName())){
                        Object[] parameters = new Object[]{new String[]{"hello", "  world"," !"}};
                        System.out.println("返回值为：" + method.invoke(method_demo1,parameters));
                    }else {
                        System.out.println("测试demo未定义的方法！==》 "+method.getName());
                    }
                } catch (Exception e) {
//                    e.printStackTrace();
                    System.out.println("在执行方法:"+method.getName()+"时抛出异常,下面执行setAccessible()方法");
                    method.setAccessible(true);
                    isTurn = true;
                }
            }
            System.out.println();
        }

    }
}
