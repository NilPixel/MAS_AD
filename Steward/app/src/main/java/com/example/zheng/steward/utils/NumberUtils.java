package com.example.zheng.steward.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by jarvis on 2018/4/3.
 * 数字处理的一些工具类
 */

public class NumberUtils {

    /**
     * 将超过万位的数字转换成万为单位的数字
     * @param num
     * @return
     */
    public static String convertToTenThousand(double num) {
        String price = String.valueOf(num);
        BigDecimal bigDecimal = new BigDecimal(price);
        if (Double.doubleToLongBits(num) > Double.doubleToLongBits(10000)) {
            // 转换为万元（除以10000）
            BigDecimal decimal = bigDecimal.divide(new BigDecimal("10000"));
            // 格式化完成之后得出结果
            return roundAndKeepDecimals(decimal, new DecimalFormat("0.00"));
        }
        return roundAndKeepDecimals(bigDecimal, new DecimalFormat("0.00"));
    }

    /**
     * 四舍五入并保留几位小数
     * @param decimal
     * @param formater
     * @return
     */
    private static String roundAndKeepDecimals(BigDecimal decimal, DecimalFormat formater) {
        // 四舍五入
        formater.setRoundingMode(RoundingMode.HALF_UP);
        // 格式化完成之后得出结果
        String formatNum = formater.format(decimal);
        return formatNum;
    }
}
