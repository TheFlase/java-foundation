package com.wgc.lab.reflection.field;

import java.lang.reflect.Field;

/**
 * @Author wgc
 * @Description
 * @Date 4/18/2020
 **/
public class Field_demo1_Test {

    public static void main(String[] args) {
        Field_demo1 field_demo1 = new Field_demo1();
        Class fieldClass = field_demo1.getClass();
        //获得所有成员变量
        Field[] declaredFields = fieldClass.getDeclaredFields();
        for(Field item:declaredFields){
            Class fieldType = item.getType();
            System.out.println("成员变量名称为(field.getName()):" + item.getName());
            System.out.println("成员变量类型为(field.getType()):" + fieldType);
            boolean isTurn = true;
            while (isTurn){
                try {
                    isTurn = false;
                    System.out.println("修改成员变量的值，修改前的值是(field.get(实例对象)):" + item.get(field_demo1));
                    if(fieldType.equals(int.class)){
                        System.out.println("利用方法setInt()修改成员变量的值");
                        item.setInt(field_demo1,178);
                    }else if(fieldType.equals(float.class)){
                        System.out.println("利用方法setFloat()修改成员变量的值");
                        item.setFloat(field_demo1,100.0F);
                    }else if(fieldType.equals(boolean.class)){
                        System.out.println("利用方法setBoolean()修改成员变量的值");
                        item.setBoolean(field_demo1,true);
                    }else {
                        System.out.println("利用方法set()修改成员变量的值");
                        item.set(field_demo1,"awaresome");
                    }
                    System.out.println("修改后的值为:"+item.get(field_demo1));
                } catch (IllegalAccessException e) {
                    System.out.println("在设置成员变量值时抛出异常,下面执行setAccessible()方法！");
                    item.setAccessible(true);
                    isTurn = true;
                }
            }
            System.out.println();
        }
    }
}
