package com.wgc.lab.misc;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Pony
 * @Date: 2020/11/18 15:05
 * @Description:
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal num1 = new BigDecimal(10.5);
        System.out.println(num1.subtract(new BigDecimal(2.2)));
        System.out.println(num1.subtract(new BigDecimal(2.2)).setScale(6,BigDecimal.ROUND_HALF_UP));
        System.out.println(num1.multiply(new BigDecimal(2.2)).setScale(6,BigDecimal.ROUND_HALF_UP));
        System.out.println("默认不四舍五入："+num1.multiply(new BigDecimal(2.2)).setScale(6,BigDecimal.ROUND_HALF_UP));
        System.out.println("四舍五入："+num1.multiply(new BigDecimal(2.2)).setScale(6,BigDecimal.ROUND_HALF_UP));
        double a = 10.5;
        double b = 2.2;
        System.out.println(a*b);

        Map<Long,String> param = new HashMap<>();
        param.put(1L,"a");

        System.out.println(new BigDecimal(1).add(new BigDecimal(0.36)).setScale(6,BigDecimal.ROUND_HALF_UP));
        System.out.println(new BigDecimal(10.5).multiply(new BigDecimal(1).add(new BigDecimal(0.36))).setScale(6,BigDecimal.ROUND_HALF_UP));
        System.out.println(new BigDecimal(10.5).multiply(new BigDecimal(1).add(new BigDecimal(0.36)).setScale(6,BigDecimal.ROUND_HALF_UP)).setScale(6,BigDecimal.ROUND_HALF_UP));
        BigDecimalTest t = new BigDecimalTest();
        String test = t.test();
        System.out.println(test);

        String a1= "D-20202-01";
        System.out.println(a1.substring(a1.lastIndexOf("-")+1));
        System.out.println("01".startsWith("0"));
        System.out.println("10".startsWith("0"));
        System.out.println("01".replace("0",""));
        System.out.println("==================>"+new BigDecimal(2400000.000000).multiply(new BigDecimal(0.000000)).setScale(6,BigDecimal.ROUND_HALF_UP));
        System.out.println("=========1100001=========>"+new BigDecimal(2400000.220000).add(new BigDecimal(0.100000)));
        System.out.println("=========111=========>"+new BigDecimal(2400000.000000).add(new BigDecimal(0.000000)).setScale(6,BigDecimal.ROUND_HALF_UP));

        System.out.println("==========2222========>"+new BigDecimal(2400000.120000).add(new BigDecimal(0.320000)));

        BigDecimal unitPrice = new BigDecimal(12.111111);
        System.out.println("777==="+unitPrice.divide(new BigDecimal(1).add(new BigDecimal(0.8)),6,BigDecimal.ROUND_HALF_UP));
        System.out.println("888==="+unitPrice.divide(new BigDecimal(1).add(new BigDecimal(0.8)).setScale(6,BigDecimal.ROUND_HALF_UP),6,BigDecimal.ROUND_HALF_UP));

        System.out.println("uuid"+UUID.randomUUID());

        System.out.println(new BigDecimal(10).divide(new BigDecimal(2.4),BigDecimal.ROUND_HALF_UP));

        BigDecimal multiply = new BigDecimal(100).multiply(new BigDecimal(80)).divide(new BigDecimal(100 + 20),BigDecimal.ROUND_HALF_UP);
        System.out.println("result is:"+multiply);

        if(new BigDecimal(2.3).subtract(new BigDecimal(1.2)).compareTo(BigDecimal.ZERO)<0){
            System.out.println("小于0");
        }
        System.out.println(new BigDecimal(2.3).subtract(new BigDecimal(1.2)));
        Map<Long,String> testMap = new HashMap<>();
        testMap.put(1L,"a");
        System.out.println(testMap.get(new Long(1)));
        System.out.println(testMap.get(1));



    }

    private String test(){
        ReentrantLock reentrantLock = new ReentrantLock();
        try {
            reentrantLock.lock();
            String deliveryNo;
            int a = 2/0;

        }catch (Exception e){
            e.printStackTrace();
            return "dd";
        }finally {
            reentrantLock.unlock();
            System.out.println("finally...");
        }
        return "end";
    }

}
