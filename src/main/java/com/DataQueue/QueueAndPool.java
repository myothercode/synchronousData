package com.DataQueue;

import com.domain.StepFourChargeStatusVO;
import com.domain.StepTwoNoticeChargeThirdPartVO;
import org.springframework.core.task.TaskExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by chace.cai on 2014/6/27.
 */
public class QueueAndPool {

    /**第二步需要同步的数据队列*/
    public final static BlockingQueue<StepTwoNoticeChargeThirdPartVO> stepTwoQueue = new ArrayBlockingQueue<StepTwoNoticeChargeThirdPartVO>(60);

    /**第四步需要同步的数据队列*/
    public final static BlockingQueue<StepFourChargeStatusVO> stepFourQueue = new ArrayBlockingQueue<StepFourChargeStatusVO>(60);

    public static TaskExecutor taskExecutor;  //定时发送数据的线程



}
