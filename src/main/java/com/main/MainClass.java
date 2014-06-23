package com.main;

import com.service.LogTestService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wula on 2014/6/23.
 * 主切入口
 */
public class MainClass {
    public static ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
    public static void main(String[] args) {

        LogTestService logTestService=applicationContext.getBean(LogTestService.class);
        logTestService.testLog();
    }
}
