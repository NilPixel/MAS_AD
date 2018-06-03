package com.example.zheng.steward.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jarvis on 2018/3/28.
 */

public class TimeUtils {

    /**
     * 获取系统时间戳
     * @return 时间戳字符串
     */
    public static String getTimestamp(){
        long timeStampSec = System.currentTimeMillis();
        return String.valueOf(timeStampSec);
    }

    /**
     * 时间戳转换成字符窜
     * @param milSecond
     * @param pattern
     * @return
     */
    public static String getDateToString(long milSecond, String pattern) {
        Date date = new Date(milSecond);
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }
}
