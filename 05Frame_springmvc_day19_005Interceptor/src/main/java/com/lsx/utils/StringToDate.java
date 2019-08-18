package com.lsx.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDate implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        try {
            return df.parse(s);
        } catch (ParseException e) {
            System.out.println("转换异常");
            e.printStackTrace();
        }

        return null;
    }
}
