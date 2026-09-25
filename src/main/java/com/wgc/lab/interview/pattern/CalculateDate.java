package com.wgc.lab.interview.pattern;


/**
 * 请你编写一个程序来计算两个日期之间隔了多少天。
 *
 * 日期以字符串形式给出，格式为 YYYY-MM-DD，如示例所示。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：date1 = "2019-06-29", date2 = "2019-06-30"
 * 输出：1
 * 示例 2：
 *
 * 输入：date1 = "2020-01-15", date2 = "2019-12-31"
 * 输出：15
 *  
 *
 * 提示：
 *
 * 给定的日期是 1971 年到 2100 年之间的有效日期。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-days-between-two-dates
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 2/29/2020
 **/
public class CalculateDate {
    public static void main(String[] args) {
        String dateStr1 = "2020-01-15", dateStr2 = "2019-12-31";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date1 = simpleDateFormat.parse(dateStr1);
            Date date2 = simpleDateFormat.parse(dateStr2);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date1);
            long dateMills1 = calendar.getTimeInMillis();
            calendar.setTime(date2);
            long dateMills2 = calendar.getTimeInMillis();
            long betweenDay = Math.abs(dateMills1-dateMills2)/(1000*60*60*24);
            System.out.println("相隔的天数是:"+betweenDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //方法2
//        int a = (int)Math.abs(LocalDate.parse("2020-01-15").until(LocalDate.parse("2019-12-31"), ChronoUnit.DAYS));
//        System.out.println("相差的日期天数是:"+a);

    }
}
