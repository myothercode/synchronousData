package com.service.impl;

import com.DataQueue.CycleForStepFourThread;
import com.DataQueue.CycleForStepTwoThread;
import com.DataQueue.QueueAndPool;
import com.domain.StepFourChargeStatusVO;
import com.domain.StepTwoNoticeChargeThirdPartVO;
import com.service.GetAndUpdateDataFromDBService;
import com.util.commUtil.comm.DateUtils;
import com.util.commUtil.comm.MyStringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by chace.cai on 2014/6/26.
 * * CRON表达式    含义
 * 30 10 * * * ?  每小时的10分30秒
 "0 0 12 * * ?"    每天中午十二点触发
 "0 15 10 ? * *"    每天早上10：15触发
 "0 15 10 * * ?"    每天早上10：15触发
 "0 15 10 * * ? *"    每天早上10：15触发
 "0 15 10 * * ? 2005"    2005年的每天早上10：15触发
 "0 * 14 * * ?"    每天从下午2点开始到2点59分每分钟一次触发
 "0 0/5 14 * * ?"    每天从下午2点开始到2：55分结束每5分钟一次触发
 "0 0/5 14,18 * * ?"    每天的下午2点至2：55和6点至6点55分两个时间段内每5分钟一次触发
 "0 0-5 14 * * ?"    每天14:00至14:05每分钟一次触发
 "0 10,44 14 ? 3 WED"    三月的每周三的14：10和14：44触发
 "0 15 10 ? * MON-FRI"    每个周一、周二、周三、周四、周五的10：15触发
 */
@Component
public class TaskServiceImpl implements com.service.TaskService {
    static Logger logger = Logger.getLogger(TaskServiceImpl.class);
    private Thread thread1=null;
    private Thread thread2=null;

    @Autowired
    private GetAndUpdateDataFromDBService getAndUpdateDataFromDBService;

    @Scheduled(cron="0/10 * *  * * ?")
    @Override
    public void getDateFromForStepTwo()  { //获取数据放入队列中
       /* StepTwoNoticeChargeThirdPartVO stepTwoNoticeChargeThirdPart = new StepTwoNoticeChargeThirdPartVO();
        stepTwoNoticeChargeThirdPart.setCONNECT_ID("100");
        stepTwoNoticeChargeThirdPart.setCITY_CODE("028");
        stepTwoNoticeChargeThirdPart.setCITY_NAME("成都");
        stepTwoNoticeChargeThirdPart.setMO_MESSAGE_ID("100");
        stepTwoNoticeChargeThirdPart.setSERVICE_CODE("10628997");
        stepTwoNoticeChargeThirdPart.setMESSAGE("1_460029011219788_66666");
        stepTwoNoticeChargeThirdPart.setRECEIVE_TIME(new Date().getTime());
        stepTwoNoticeChargeThirdPart.setMSISDN("18602861176");

        StepFourChargeStatusVO stepFourChargeStatusVO = new StepFourChargeStatusVO();

        try {
            QueueAndPool.stepTwoQueue.put(stepTwoNoticeChargeThirdPart);
            QueueAndPool.stepTwoQueue.put(stepTwoNoticeChargeThirdPart);
            QueueAndPool.stepTwoQueue.put(stepTwoNoticeChargeThirdPart);
            QueueAndPool.stepFourQueue.put(stepFourChargeStatusVO);
        } catch (Exception e) {
           logger.error(e.getMessage(),e);
        }*/
        /*如果队列中的任务大于50个，那么不再往队列中放入*/
        if(QueueAndPool.stepTwoQueue.size()>50){
            return;
        }
        List<StepTwoNoticeChargeThirdPartVO> sList = getAndUpdateDataFromDBService.getDataForStepTwo();
        if(sList.isEmpty()){
            return;
        }
        else {
            for (StepTwoNoticeChargeThirdPartVO s2:sList){
                try {
                    s2.setCONNECT_ID(DateUtils.formatDateTimeForBill(new Date())+"x"+ MyStringUtils.randomNum(6));
                    QueueAndPool.stepTwoQueue.put(s2);
                } catch (Exception e) {
                    logger.error(e.getMessage(),e);
                    continue;
                }
            }
        }

        /**判断线程是否还是活动的如果不是，则重新开启线程*/
        if(thread1==null || !thread1.isAlive()){
            thread1 = new Thread(new CycleForStepTwoThread("caixu-step2-thread"));
            thread1.start();
        }
        if(thread2==null || !thread2.isAlive()){
            thread2 = new Thread(new CycleForStepFourThread("caixu-step4-thread"));
            thread2.start();
        }


    }

    @Scheduled(cron="0/12 * *  * * ?")
    @Override
    public void getDataForStepFourFromDB(){
        if(QueueAndPool.stepFourQueue.size()>50){
            return;
        }
        List<StepFourChargeStatusVO> sList = getAndUpdateDataFromDBService.getDataForStepFour();
        if(sList.isEmpty()){
            return;
        }else {
            for (StepFourChargeStatusVO s2:sList){
                try {
                    s2.setCONNECT_ID(DateUtils.formatDateTimeForBill(new Date())+"x"+ MyStringUtils.randomNum(6));
                    QueueAndPool.stepFourQueue.put(s2);
                } catch (Exception e) {
                    logger.error(e.getMessage(),e);
                    continue;
                }
            }
        }
    }


}
