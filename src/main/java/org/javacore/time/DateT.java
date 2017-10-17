package org.javacore.time;

import java.text.ParseException;
import java.util.Date;
import java.time.LocalDate;
/**
 * 测试java日期类的用法
 * java.sql.Date 只包含日期（年月日）
 * java.sql.Time 只包含时间（时分秒）
 * java.sql.Timestamp 包含日期和时间（年月日时分秒）
 * java.util.Date 包含日期和时间，并且具有无参的构造方法
 * java.text.SimpleDateFormat.format 用来格式化时间
 * java.text.SimpleDateFormat.parse  可以将字符串转换成date(需要抛出ParseException异常)
 */
public class DateT {
    public static void main(String[] args) throws ParseException{
//        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
//        System.out.println(sqlDate);
//        java.sql.Time sqlTime = new java.sql.Time(System.currentTimeMillis());
//        System.out.println(sqlTime);
//        java.sql.Timestamp sqlTimestap = new java.sql.Timestamp(System.currentTimeMillis());
//        System.out.println(sqlTimestap);
//        java.util.Date utilDate = new java.util.Date();
//        System.out.println(utilDate);
//        java.util.Calendar cl = java.util.Calendar.getInstance();
//        System.out.println(cl.getTime().toString());
//
//        java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(dateFormat.format(utilDate));
//        java.util.Date stringDate = dateFormat.parse("1995-7-27 12:00:00");
//        System.out.println(stringDate);

        java.time.LocalDate localDate = java.time.LocalDate.now();
        System.out.println(localDate);
        LocalDate localDate1 = LocalDate.of(2017, 1, 13);
        System.out.println(localDate1);
    }
}
