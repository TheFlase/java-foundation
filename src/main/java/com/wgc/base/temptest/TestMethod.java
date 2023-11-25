package com.wgc.base.temptest;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.MessageFormat;
import java.util.*;

/**
 * @Author 翁国超
 * @Description //
 * @Date 2022/3/24
 **/
public class TestMethod {

    public static void main1(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class<TestMethod> methodClass = TestMethod.class;
        Method[] declaredMethods = methodClass.getDeclaredMethods();
        for(Method item:declaredMethods){
            System.out.println("方法名是："+item.getName());
            Parameter[] parameters = item.getParameters();
            for(Parameter p:parameters){
                System.out.println("方法参数名称："+p.getName()+",参数类型："+p.getType());
            }
        }

        String cName = "com.wgc.base.temptest.TestMethod";
        Class<?> aClass = Class.forName(cName);
        TestMethod instance = (TestMethod) aClass.newInstance();
        Field age = aClass.getDeclaredField("age");
        System.out.println("字段名称"+age.getName());
        System.out.println(age.get(instance));

    }

    public static void main(String[] args) {
//        BigDecimal a = new BigDecimal(14);
//        BigDecimal b = new BigDecimal(500);
//        BigDecimal c = a.divide(b,9, BigDecimal.ROUND_HALF_UP);
//        System.out.println(c.toString());
//
//        BigDecimal decimal = new BigDecimal("12.1234567");
//        BigDecimal decimalTwo = BigDecimal.valueOf(12.12345678);
//        BigDecimal decimalThree = BigDecimal.valueOf(0);
//        System.out.println(decimalTwo.setScale(5, RoundingMode.DOWN));
//        System.out.println(decimalThree.setScale(5, RoundingMode.DOWN));
//        System.out.println();

//        Object numberObj = new Object();
//        Object doubleObj = new Object();
//        Object bigDecimalObj = new Object();
//        Object strObj = new Object();
//        doubleObj = 22.1234567;
//        bigDecimalObj = new BigDecimal("13.123456");
//        strObj = "12.1234567";
//        System.out.println((BigDecimal)doubleObj);
//        System.out.println((BigDecimal)bigDecimalObj);
//        System.out.println((BigDecimal)strObj);

        List<Long> ruleIds = new ArrayList<>();
        ruleIds.add(3L);
        ruleIds.add(6L);
        ruleIds.add(9L);
        ruleIds.add(11L);
        ruleIds.add(13L);
        ruleIds.add(16L);
        ruleIds.add(18L);
        ruleIds.add(20L);

//        System.out.println(ruleIds.contains(3));

        List<String> systemList = Arrays.asList("CAS", "LTS", "CMS", "GD", "ELD", "OWMS", "FMS", "LOMS", "OPS", "SIMS");
        System.out.println(systemList.contains("cas"));

    }



    public static void main2(String[] args) {
//        Double a = new Double(3);
//        System.out.println(a.compareTo(null));

//        Map<Long, List<Map<String, Object>>> resultMap = new HashMap<>();
//
//        Map<String,Object> tempMap = new HashMap<>();
//        tempMap.put("2022-06-10",10);
//        tempMap.put("2022-06-11",11);
//        tempMap.put("2022-06-12",12);
//        tempMap.put("2022-06-13",13);
//        tempMap.put("2022-06-14",14);
//        tempMap.put("2022-06-15",15);
////        List<Map<String, Object>> tempList = new ArrayList<>();
////        tempList.add(tempMap);
////
////        resultMap.put(1L,tempList);
////        System.out.println();
//        Date collectTimeDate = DateUtil.parse("2022-05-30 10:39:43", "yyyy-MM-dd HH:mm:ss");//"2022-05-30 10:39:43"
//        Date collectEndTimeDate = DateUtil.parse("2022-05-30 14:31:40", "yyyy-MM-dd HH:mm:ss");//"2022-05-30 14:31:40"
//        DateTime dateTime  = DateUtil.offsetMinute(collectTimeDate, 0);
//        int i =0;
//        while (dateTime.getTime() <= collectEndTimeDate.getTime()) {
//            dateTime = DateUtil.offsetMinute(collectTimeDate, i);
//            System.out.println(dateTime.getTime());
//            i++;
//        }
        StringBuilder sb = new StringBuilder();
        DateTime startTime = DateUtil.parse(String.valueOf(null));
        sb.delete(0,sb.length());
        sb.append(DateUtil.offset(startTime, DateField.SECOND, 59).toString(DatePattern.NORM_DATETIME_PATTERN));
        System.out.println(sb.toString());


    }

    private int age;

    public void mPublic(int a,String name){

    }

    protected void pMethod(){}

    private void prMethod(){}
}
