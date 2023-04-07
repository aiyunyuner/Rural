package com.TypeDelta.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
    public static String setTime() {
        Date date = new Date();//获取当前的日期
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");//设置日期格式
        String str = df.format(date);
        return str;
    }
}
