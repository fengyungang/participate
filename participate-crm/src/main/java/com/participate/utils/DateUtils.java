package com.participate.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间处理工具
 *        G 年代标志符
 *        y 年
 *        M 月
 *         d 日
 *        h 时 在上午或下午 (1~12)
 *        H 时 在一天中 (0~23)
 *        m 分
 *        s 秒
 *        S 毫秒
 *        E 星期
 *        D 一年中的第几天
 *        F 一月中第几个星期几
 *        w 一年中第几个星期
 *        W 一月中第几个星期
 *        a 上午 / 下午 标记符
 *        k 时 在一天中 (1~24)
 *        K 时 在上午或下午 (0~11)
 *        z 时区
 */
public class DateUtils {

    /**
     * 按照提供的格式将字符串转换成Date类型
     *
     * @param dateStr
     * @param formaterString
     * @return
     */
    public static Date StD(String dateStr, String formaterString) {
        Date date = null;
        SimpleDateFormat formater = new SimpleDateFormat();
        formater.applyPattern(formaterString);
        try {
            date = formater.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 按照参数提供的格式将Date类型时间转换为字符串
     *
     * @param date
     * @param formaterString
     * @return
     */
    public static String DtS(Date date, String formaterString) {
        String time;
        SimpleDateFormat formater = new SimpleDateFormat();
        formater.applyPattern(formaterString);
        time = formater.format(date);
        return time;
    }

    /**
     * date转换为unix时间
     * @param date
     * @return
     */
    public static Long Dtu(Date date){
        return date.getTime();
    }

    /**
     * unix时间转换为date
     * @param unixTime
     * @return
     */
    public static Date Utd(Long unixTime){
        return new Date(unixTime);
    }

    /**
     * 获取与现在的时间差
     * @param date
     * @return
     */

    public static Long timedifference(Date date){

        Date now = new Date();

        return (now.getTime()-date.getTime())/1000L;
    }
    /**
     * 根据时间获取星期几
     * @param date
     * @return
     */
    public static String getWeek(Date date){
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        return weekDays[w];
    }

}
