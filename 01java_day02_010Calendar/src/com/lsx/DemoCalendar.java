package com.lsx;

import javax.sound.midi.Soundbank;
import java.util.Calendar;
import java.util.Date;

public class DemoCalendar {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println(c);

        // 获取字段置
        int year = c.get(Calendar.YEAR);
        System.out.println("年 " + year);

        // 西方的月份 0 - 11
        int month = c.get(Calendar.MONTH);
        System.out.println("月" + (month+1));

        // 设置年
        c.set(Calendar.YEAR, 999);
        c.set(Calendar.MONTH,0);
        System.out.println(" 年 :" + c.get(Calendar.YEAR) + " 月 :" + c.get(Calendar.MONTH));

        c.add(Calendar.YEAR, 2);
        c.add(Calendar.MONTH, -3);
        System.out.println(" 年: " +c.get(Calendar.YEAR) + "月： " + c.get(Calendar.MONTH));


        Date time = c.getTime();
        System.out.println(" date = " +time);


    }
}
