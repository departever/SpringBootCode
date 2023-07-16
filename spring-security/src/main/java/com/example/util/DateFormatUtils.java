package com.example.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtils {

    /**
     *  将日期类型的转成字符串格式的日期
     * @param pattern
     * @param date
     * @return
     */
    public static String dateFormat(String pattern, Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String format = sdf.format(date);
        return format;
    }

    /**
     *  将字符格式的日期转成日期对象
     * @param pattern
     * @param date
     * @return
     */
    public static Date ParesDate(String pattern, String date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date format = null;
        try {
            format = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return format;
    }

}