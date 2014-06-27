package com.main;

import com.DataQueue.QueueAndPool;
import com.domain.StepThreeResponseVO;
import com.domain.StepTwoNoticeChargeThirdPartVO;
import com.util.commUtil.comm.DateUtils;
import com.util.commUtil.comm.MyApplicationContextUtil;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.TaskExecutor;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by wula on 2014/6/23.
 * 主切入口
 */
public class MainClass {
    static Logger logger = Logger.getLogger(MainClass.class);
    public static AbstractApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
    public static void main(String[] args) throws Exception {
        if(QueueAndPool.taskExecutor==null){
            QueueAndPool.taskExecutor= MyApplicationContextUtil.getContext().getBean("taskExecutor", TaskExecutor.class);
        }




       // logger.error("fff");

       /* LogTestService logTestService=applicationContext.getBean(LogTestService.class);
        logTestService.testLog();*/

        /*StepTwoNoticeChargeThirdPartVO stepTwoNoticeChargeThirdPart = new StepTwoNoticeChargeThirdPartVO();
        stepTwoNoticeChargeThirdPart.setCONNECT_ID("100");
        stepTwoNoticeChargeThirdPart.setCITY_CODE("028");
        stepTwoNoticeChargeThirdPart.setCITY_NAME("成都");
        stepTwoNoticeChargeThirdPart.setMO_MESSAGE_ID("100");
        stepTwoNoticeChargeThirdPart.setSERVICE_CODE("10628997");
        stepTwoNoticeChargeThirdPart.setMESSAGE("1_460029011219788_66666");
        stepTwoNoticeChargeThirdPart.setRECEIVE_TIME(new Date().getTime());
        stepTwoNoticeChargeThirdPart.setMSISDN("18602861176");
        PostActionService postActionService=applicationContext.getBean(PostActionService.class);
        postActionService.doPost(stepTwoNoticeChargeThirdPart.getXML());*/

        /*StepThreeResponseVO stepThreeResponseVO=new StepThreeResponseVO();
        stepThreeResponseVO.setMessageID("0");
        stepThreeResponseVO.setResult("dgfd");
        System.out.println(stepThreeResponseVO.getXML());*/
    }
}
