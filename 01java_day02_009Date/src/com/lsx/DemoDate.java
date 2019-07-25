package com.lsx;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DemoDate {

    public static void main(String[] args) throws ParseException {
        // 时间日期的基本操作

        // 时间戳
        // 时区
        // 日期格式化

        // 字符串转换为时间
        // 获取 日 天 月 周 等等

        // 根据毫秒级时间戳生成日期
        Date d1 = new Date(0L);
        System.out.println(d1);

        // 生成当前日期
        Date d2 = new Date(System.currentTimeMillis());
        System.out.println(d2);

        Date d3 = new Date();
        System.out.println(d3);

        System.out.println(d3.getTime());

        // 日期格式化
        DateFormat df = new SimpleDateFormat("yyyy年MM月dd日 H时m分s秒");
        String ts = df.format(new Date());
        System.out.println("格式化的日期是" + ts);

        // 解析日期
        Date dd = df.parse(ts);
        System.out.println("解析后的日期是 " + dd);


        // 联系，计算人的s


    }
}
