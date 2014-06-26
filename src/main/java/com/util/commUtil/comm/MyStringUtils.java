package com.util.commUtil.comm;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;

/**
 * Created by chace.cai on 2014/6/26.
 */
public class MyStringUtils {

    /**左填充
     *
     * @param s 需要填充的字符串
     * @param i 要填充到几位
     * @param f 用什么符号来填充
     * @return
     */
    public static String leftPad(String s,int i,String f){
        return StringUtils.leftPad(s,i,f);
    }

    /**
     * 获得指定位数的一个随机整数
     * @param i
     * @return
     */
    public static String randomNum(Integer i){
       return RandomStringUtils.randomNumeric(i) ;
    }
}
