package com.wgc.base.offusemethod;

import cn.hutool.core.util.StrUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author 翁国超
 * @Description // String个人遇到的一些常用方法
 * @Date 2023/7/6
 **/
public class StrMethodTest01 {
    public static void main(String[] args) {
        offenMethod1();
    }


    /**
     * contains,split
     */
    public static void offenMethod1() {
        // 字符串包含关系
        String a = "monitor,aa";
        String b = "monitor,a";
        System.out.println("a.contails(b):"+a.contains(b));
        System.out.println("b.contains(a)"+b.contains(a));

        // 字符串拆解：不包含拆解标志也能拆解
        String ip = "10.100.12.45:8848";
        String ip2 = "10.100.12.45";
        String[] split = ip2.split(StrUtil.COLON);
        System.out.println(Arrays.toString(split));

        // 测试Map获取key为null是否报错：不报错
        Map<String,Object> resultMap = new HashMap<>();
        Object o = resultMap.get(null);
        System.out.println(o);

        // 包含空串判断：包含
        boolean contailFlag = StrUtil.containsIgnoreCase("pro,test", StrUtil.EMPTY);
        System.out.println(contailFlag);

        // 字符串截取
        String c = "2011-11-01 11:11:12";
        System.out.println("字符串截图结果是："+StrUtil.sub(c,0,9));

    }
}
