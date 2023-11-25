package com.wgc.base.offusemethod;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * @Author 翁国超
 * @Description // 日期常用测试类
 * @Date 2023/7/6
 **/
public class DateMethodTest01 {
    public static void main(String[] args) {
        date01();
        dataCalc01();
    }

    public static void date01(){
        // 获取当前时间
        DateTime dateTime = DateUtil.date();
        System.out.println(dateTime);

        // 获取当前时间 时分秒
        String nowStr = DateUtil.now();
        System.out.println(nowStr);

        // 获取30天前的指定格式的时间字符串
        Calendar now = Calendar.getInstance();
        now.add(Calendar.DAY_OF_MONTH, -30);
        String format1 = DateUtil.format(now.getTime(), DatePattern.NORM_DATE_PATTERN);
        System.out.println(":"+format1);

        // apache工具获取7天前
        Date date = DateUtils.addDays(new Date(), -7);
        System.out.println("7天前："+date);

        // 日期比较
        DateTime dateTime1 = DateUtil.parseDateTime("2023-06-01 10:10:10");
        DateTime dateTime2 = DateUtil.parseDateTime("2023-06-01 10:10:20");
        int compare = DateUtil.compare(dateTime1, dateTime2);
        System.out.println("日期大小比较结果："+compare);

        // 是否是同一天
        String dateSameStr = "2023-06-09 11:11:11";
        Date dateSameDate = new Date();
        boolean sameDay = DateUtil.isSameDay(dateSameDate, DateUtil.parseDate(dateSameStr));
        System.out.println("is same day:"+sameDay);

    }

    public static void dataCalc01(){
        // 是否包含指定格式的日期
        String startTimeStr = "2023-03-02";
        String endTimeStr = "2023-08-09";
        Date deliverTime = new Date();
        DateTime startTime = DateUtil.parse(startTimeStr, DatePattern.NORM_YEAR_PATTERN);
        DateTime endTime = DateUtil.parse(endTimeStr, DatePattern.NORM_YEAR_PATTERN);
        String deliverTimeStr = DateUtil.format(deliverTime, DatePattern.NORM_YEAR_PATTERN);
        DateTime dateTime = DateUtil.parse(deliverTimeStr, DatePattern.NORM_YEAR_PATTERN);
        boolean isInFlag = DateUtil.isIn(dateTime, startTime, endTime);
        System.out.println("是否包含结果："+(isInFlag?"包含":"不包含"));

        Date now = new Date();
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(now);
        // 将时分秒,毫秒域清零
        cal1.set(Calendar.HOUR_OF_DAY, 0);
        cal1.set(Calendar.MINUTE, 0);
        cal1.set(Calendar.SECOND, 0);
        cal1.set(Calendar.MILLISECOND, 0);
        System.out.printf("%1$tF %1$tT\n", cal1.getTime());// cal1.getTime()返回的Date已经是更新后的对象
        System.out.printf("data is:"+cal1.getTime());// cal1.getTime()返回的Date已经是更新后的对象
//        boolean isIn = DateUtil.isIn(cal1.getTime(), DateUtil.parseDate("2023-06-09"), DateUtil.parseDate("2023-06-09"));
        boolean isIn = DateUtil.isIn(cal1.getTime(), DateUtil.parseDate("2023-07-06 12:10:10"), DateUtil.parseDate("2023-07-06 10:10:10"));
//        boolean isIn = DateUtil.isIn(now, DateUtil.parseDate("2023-06-09 10:10:10"), DateUtil.parseDate("2023-06-09 10:10:10"));
        System.out.println("is in:"+isIn);
    }
}
