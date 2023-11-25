package com.wgc.base.offusemethod;

import cn.hutool.core.util.StrUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author 翁国超
 * @Description //
 * @Date 2023/7/6
 **/
public class CollectionMethod01 {

    public static void main(String[] args) {
        testMethod01();
    }

    public static void testMethod01(){
        // set集合转为英文逗号分隔的字符串
        Set<String> setStr = new HashSet<>();
        setStr.add("a");
        setStr.add("b");
        System.out.println("set transfer str,result is:"+ StringUtils.join(setStr.toArray(), StrUtil.COMMA));

        // 获取两个基本数据类型的list的交集
        List<String> listOne = Arrays.asList("1","2","3","5");
        List<String> listTwo = Arrays.asList("1","4","5","2");
        List<String> collect = listOne.stream().filter(listTwo::contains).collect(Collectors.toList());
        System.out.println("intersection result is:"+collect);

        // map获取null键
        Map<String,String> map = new HashMap<>();
        String s = map.get(null);
        System.out.println("s==="+s);
    }

}
