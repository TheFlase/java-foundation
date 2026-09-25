package com.wgc.lab.reflection.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author wgc
 * @Description 用于构造方法
 * @Date 4/18/2020
 **/
@Target(ElementType.CONSTRUCTOR)
@Retention(RetentionPolicy.RUNTIME)
public @interface ConstructorAnnotation {
    //定义一个具有默认值的String型成员
    String value() default "默认构造方法";
}
