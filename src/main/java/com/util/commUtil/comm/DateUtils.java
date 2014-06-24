package com.util.commUtil.comm;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * Created by wula on 2014/6/24.
 * 时间处理类
 */
public class DateUtils {
    private static final Pattern datePattern = Pattern
            .compile("(?:19|20)[0-9]{2}-(?:0?[1-9]|1[012])-(?:0?[1-9]|[12][0-9]|3[01])");
    private static final Pattern timePattern = Pattern.compile("(?:[01]?[0-9]|2[0-3]):[0-5]?[0-9]:[0-5]?[0-9]");
    private static final Pattern dateTimePattern = Pattern.compile(datePattern.pattern() + " " + timePattern.pattern());
    private static final BiMap<Integer, Integer> dayOfWeekMap;//处理星期几的双向转换

    static {
        ImmutableBiMap.Builder<Integer, Integer> biMap = ImmutableBiMap.builder();
        biMap.put(Calendar.MONDAY, 1);
        biMap.put(Calendar.TUESDAY, 2);
        biMap.put(Calendar.WEDNESDAY, 3);
        biMap.put(Calendar.THURSDAY, 4);
        biMap.put(Calendar.FRIDAY, 5);
        biMap.put(Calendar.SATURDAY, 6);
        biMap.put(Calendar.SUNDAY, 7);
        dayOfWeekMap = biMap.build();
    }

    private static final ThreadLocal<DateFormat> dateFormatThreadLocal = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        }
    };

    private static final ThreadLocal<DateFormat> timeFormatThreadLocal = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("HH:mm:ss");
        }
    };

    private static final ThreadLocal<DateFormat> dateTimeFormatThreadLocal = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };
    private static final ThreadLocal<DateFormat> dateTimeFormatForHM = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm");
        }
    };
    private static final ThreadLocal<Calendar> calendarThreadLocal = new ThreadLocal<Calendar>() {
        @Override
        protected Calendar initialValue() {
            Calendar calendar = Calendar.getInstance(Locale.CHINA);
            calendar.setFirstDayOfWeek(Calendar.MONDAY);
            return calendar;
        }
    };

    /** 转换日期至年月日时分 */
    public static String formatDateHM(Date date) {
        return dateTimeFormatForHM.get().format(date);
    }

    /** 时间转年月日 */
    public static String formatDate(Date date) {
        return dateFormatThreadLocal.get().format(date);
    }

    /** 时间转时分秒 */
    public static String formatTime(Date date) {
        return timeFormatThreadLocal.get().format(date);
    }

    /** 时间转年月日 时分秒 */
    public static String formatDateTime(Date date) {
        return dateTimeFormatThreadLocal.get().format(date);
    }

    /**时间转为long*/
    public static Long formatDateToLong(Date date){
        return date.getTime();
    }

    /**long转为时间 date类型*/
    public static Date formatLongToDate(Long l){
       return  new Date(l * 1000);
    }
}
