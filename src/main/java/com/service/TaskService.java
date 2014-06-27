package com.service;

import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by chace.cai on 2014/6/26.
 */
public interface TaskService {
    /**为第二步查询数据，从数据库*/
    void getDateFromForStepTwo() throws InterruptedException;


    @Scheduled(cron="0/10 * *  * * ?")
    void getDataForStepFourFromDB();
}
