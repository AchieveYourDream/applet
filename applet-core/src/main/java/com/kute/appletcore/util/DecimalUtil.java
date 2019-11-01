package com.kute.appletcore.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 提供精确计算的工具类
 *
 * @author xiaqing
 * @date 2017/11/25.
 */
public class DecimalUtil {
    /**
     * 格式化输出结果
     */
    private static final DecimalFormat df = new DecimalFormat("0.00");

    /**
     * 精确的加法
     * @param x double类型的数字
     * @param y double类型的数字
     * @return
     */
    public static String add(double x, double y) {
        BigDecimal b1 = new BigDecimal(Double.toString(x));
        BigDecimal b2 = new BigDecimal(Double.toString(y));
        return df.format(b1.add(b2));
    }

    /**
     * 精确的加法
     * @param x String类型的数字
     * @param y String类型的数字
     * @return
     */
    public static String add(String x, String y) {
        BigDecimal b1 = new BigDecimal(x);
        BigDecimal b2 = new BigDecimal(y);
        return df.format(b1.add(b2));
    }

    /**
     * 精确的减法
     * @param x double类型的数字
     * @param y double类型的数字
     * @return
     */
    public static String subtract(double x, double y) {
        BigDecimal b1 = new BigDecimal(Double.toString(x));
        BigDecimal b2 = new BigDecimal(Double.toString(y));
        return df.format(b1.subtract(b2));
    }

    /**
     * 精确的减法
     * @param x String类型的数字
     * @param y String类型的数字
     * @return
     */
    public static String subtract(String x, String y) {
        BigDecimal b1 = new BigDecimal(x);
        BigDecimal b2 = new BigDecimal(y);
        return df.format(b1.subtract(b2));
    }

    /**
     * 精确的乘法
     * @param x double类型的数字
     * @param y double类型的数字
     * @return
     */
    public static String multiply(double x, double y) {
        BigDecimal b1 = new BigDecimal(Double.toString(x));
        BigDecimal b2 = new BigDecimal(Double.toString(y));
        return df.format(b1.multiply(b2));
    }

    /**
     * 精确的乘法
     * @param x String类型的数字
     * @param y String类型的数字
     * @return
     */
    public static String multiply(String x, String y) {
        BigDecimal b1 = new BigDecimal(x);
        BigDecimal b2 = new BigDecimal(y);
        return df.format(b1.multiply(b2));
    }

    /**
     * 精确的除法
     * @param x String类型的数字
     * @param y String类型的数字
     * @return
     */
    public static String divide(double x, double y) {
        BigDecimal b1 = new BigDecimal(Double.toString(x));
        BigDecimal b2 = new BigDecimal(Double.toString(y));
        //scale指的是小数点后的位数,这里的2表示精确到小数点后面的两位小数
        //roundingMode是小数的保留模式。它们都是BigDecimal中的常量字段,有很多种。
        //比如：BigDecimal.ROUND_HALF_UP表示的就是4舍5入
        return df.format(b1.divide(b2,2,BigDecimal.ROUND_HALF_UP));
    }

    /**
     * 精确的除法
     * @param x String类型的数字
     * @param y String类型的数字
     * @return
     */
    public static String divide(String x, String y) {
        BigDecimal b1 = new BigDecimal(x);
        BigDecimal b2 = new BigDecimal(y);
        return df.format(b1.divide(b2,2,BigDecimal.ROUND_HALF_UP));
    }
}
