package com.wgc.base.temptest;

/**
 * @Author 翁国超
 * @Description //
 * @Date 2022/10/13
 **/
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * 补全日期工具类.
 *
 * @author linzp
 * @version 1.0.0
 * CreateDate 2020/5/11 17:13
 * description
 */
public final class CompletionDateUtils {

    /**
     * 隐藏构造方法.
     */
    private CompletionDateUtils() {
    }

    /**
     * 数据库查询出来的统计数据有时候日期是不连续的.
     * 但是前端展示要补全缺失的日期.
     * 此方法返回一个给定日期期间的所有日期字符串列表.
     * 具体在业务逻辑中去判断补全.
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return
     */
    public static List<String> completionDate(
            LocalDateTime startDate,
            LocalDateTime endDate) {
        //日期格式化
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        List<String> dateList = new ArrayList<>();
        //遍历给定的日期期间的每一天
        for (int i = 0; !Duration.between(startDate.plusDays(i), endDate).isNegative(); i++) {
            //添加日期
            dateList.add(startDate.plusDays(i).format(formatter));
        }
        return dateList;
    }

    /**
     * main.
     *
     * @param args
     */
    public static void main(String[] args) {
        //测试过去30天
//        List<String> date = completionDate(LocalDateTime.now().minusDays(29), LocalDateTime.now());
        List<String> date = completionDate(LocalDateTime.now().minusDays(29), LocalDateTime.now());
        for (int i = 0; i < date.size(); i++) {
            System.out.println(date.get(i));
        }
    }
}

