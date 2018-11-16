package com.example.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat(
            "HH:mm:ss");

    public static Date now() {
        return new Date();
    }

    public static String currentTime() {
        return timeFormat.format(now());
    }
    private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public static Date parseDateTime(String strDate) throws ParseException {
        return threadLocal.get().parse(strDate);
    }

}
