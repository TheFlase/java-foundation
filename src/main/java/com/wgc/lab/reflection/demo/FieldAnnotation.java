package com.wgc.lab.reflection.demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author
 * @Description //
 * @Date 2022/3/7
 **/
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldAnnotation {

    String describe() default "字段默认值";

    /**
     * 为值加单位
     * @return
     */
//    String format() default "%s";
    String format() default "{0}";


    // 默认消息转换器
    Class convert() default DefaultMessageConvert.class;

    // 组合字段注解 key
    String compositeKey() default "";
    // 组合注解 value
    String compositeValue() default "";

    // 内存计算 填转换单位值
    String memorryCalu() default "";

}
