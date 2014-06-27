package com.DataQueue;

import com.domain.StepTwoNoticeChargeThirdPartVO;
import com.service.impl.PostActionServiceRunAble;
import org.apache.log4j.Logger;

/**
 * Created by chace.cai on 2014/6/27.
 */
public class CycleForStepTwoThread extends Thread {
    static Logger logger = Logger.getLogger(CycleForStepTwoThread.class);
    private String threadName;
    public CycleForStepTwoThread(String threadName){
         this.threadName=threadName;
    }

    /**为第二步发送数据到第三方*/
    public void run(){
        Thread.currentThread().setName(this.threadName);
        System.out.println("post step2线程开始...");
        StepTwoNoticeChargeThirdPartVO stepTwoNoticeChargeThirdPartVO=null;
        while (true){
            try {
                stepTwoNoticeChargeThirdPartVO = QueueAndPool.stepTwoQueue.take();
                QueueAndPool.taskExecutor.execute(new PostActionServiceRunAble(stepTwoNoticeChargeThirdPartVO.getXML(),stepTwoNoticeChargeThirdPartVO.getMO_MESSAGE_ID(),"2"));
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                continue;
            }
        }

    }

}
