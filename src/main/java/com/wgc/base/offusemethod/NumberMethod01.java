package com.wgc.base.offusemethod;

import cn.hutool.core.util.NumberUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Author 翁国超
 * @Description //
 * @Date 2023/7/6
 **/
public class NumberMethod01 {
    public static void main(String[] args) {
        test01();
        calc();
    }

    public static void test01(){
        // 判断一个字符串是否是数字
        String a = "否";
        String b = "0.00";
        System.out.println(NumberUtil.isNumber(a));
        System.out.println(NumberUtil.isNumber(b));

        BigDecimal b01 = new BigDecimal(0.1);
        BigDecimal b02 = new BigDecimal("0.1");
        System.out.println("a=="+b01);
        System.out.println("b=="+b02);


    }

    public static void calc(){
        // 相除，向下取值（相当于截取）保留指定位数
        BigDecimal div = NumberUtil.div(new BigDecimal(5), new BigDecimal(3),10, RoundingMode.FLOOR);
        System.out.println("result is :"+div.doubleValue());

        // 相除，四舍五入向上取值
        BigDecimal div01 = NumberUtil.div(new BigDecimal(1L), new BigDecimal(6), 4, RoundingMode.HALF_UP);
        System.out.println("div mul 100:"+NumberUtil.mul(div01,100));
    }
}
