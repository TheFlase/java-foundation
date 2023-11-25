package com.wgc.base.offusemethod;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author 翁国超
 * @Description // java8 常用方法
 * @Date 2023/7/6
 **/
public class Java8MethodTest01 {
    public static void main(String[] args) {
        bigdecimalTest();
    }

    public static void bigdecimalTest(){
        // 结果相加
        List<BigDecimal> bigDecimalList = new ArrayList<>();
        bigDecimalList.add(BigDecimal.valueOf(3));
        bigDecimalList.add(null);
        bigDecimalList.add(BigDecimal.valueOf(4));
        BigDecimal bigDecimal01 = bigDecimalList.stream().filter(Objects::nonNull).reduce(BigDecimal::add).orElse(new BigDecimal(0));
        System.out.println("计算结果1："+bigDecimal01);
    }
}
