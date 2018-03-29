package com.example.zheng.steward.utils;

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
}
