package com.main;

import com.domain.StepOneSendPhoneNoToThird;
import com.domain.StepTwoNoticeChargeThirdPart;
import com.service.LogTestService;
import com.service.PostActionService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by wula on 2014/6/23.
 * 主切入口
 */
public class MainClass {
    public static ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
    public static void main(String[] args) throws Exception {

       /* LogTestService logTestService=applicationContext.getBean(LogTestService.class);
        logTestService.testLog();*/

        StepTwoNoticeChargeThirdPart stepTwoNoticeChargeThirdPart = new StepTwoNoticeChargeThirdPart();
        stepTwoNoticeChargeThirdPart.setCONNECT_ID("100");
        stepTwoNoticeChargeThirdPart.setCITY_CODE("028");
        stepTwoNoticeChargeThirdPart.setCITY_NAME("成都");
        stepTwoNoticeChargeThirdPart.setMO_MESSAGE_ID("100");
        stepTwoNoticeChargeThirdPart.setSERVICE_CODE("10628997");
        stepTwoNoticeChargeThirdPart.setMESSAGE("1_460029011219788_66666");
        stepTwoNoticeChargeThirdPart.setRECEIVE_TIME(new Date().getTime());
        stepTwoNoticeChargeThirdPart.setMSISDN("18602861176");
        PostActionService postActionService=applicationContext.getBean(PostActionService.class);
        postActionService.doPost(stepTwoNoticeChargeThirdPart.getXML());
    }
}
