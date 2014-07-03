package com.DataQueue;

import com.domain.StepFourChargeStatusVO;
import com.service.impl.PostActionServiceRunAble;
import org.apache.log4j.Logger;

/**
 * Created by chace.cai on 2014/6/27.
 */
public class CycleForStepFourThread extends Thread {
    static Logger logger = Logger.getLogger(CycleForStepFourThread.class);
    private String threadName;
    public CycleForStepFourThread(String threadName){
         this.threadName=threadName;
    }

    /**为第二步发送数据到第三方*/
    public void run(){
        Thread.currentThread().setName(this.threadName);
        System.out.println("post step4线程开始...");
        StepFourChargeStatusVO stepFourNoticeChargeThirdPartVO=null;
        while (true){
            try {
                System.out.println("stepFourQueue中有"+QueueAndPool.stepFourQueue.size()+"条数据");
                stepFourNoticeChargeThirdPartVO = QueueAndPool.stepFourQueue.take();
                QueueAndPool.taskExecutor.execute(new PostActionServiceRunAble(stepFourNoticeChargeThirdPartVO.getXML(),stepFourNoticeChargeThirdPartVO.getMO_MESSAGE_ID(),"4"));
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                continue;
            }
        }

    }

}
