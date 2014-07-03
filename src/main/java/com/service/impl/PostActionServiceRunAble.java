package com.service.impl;

import com.service.GetAndUpdateDataFromDBService;
import com.util.commUtil.comm.HttpClientUtil;
import com.util.commUtil.comm.MyApplicationContextUtil;
import org.apache.http.client.HttpClient;
import org.apache.log4j.Logger;

/**
 * Created by wula on 2014/6/25.
 */

public class PostActionServiceRunAble implements Runnable {
    private String xml; //xml内容
    private String messageId;//消息id
    private String stepOrder;//步骤序号,2或者4
    static Logger logger = Logger.getLogger(PostActionServiceRunAble.class);
    private static final String bjurl="http://114.215.109.179:8888/payResult";


    public PostActionServiceRunAble(String xml,String m,String stepOrder){
        this.xml=xml.replaceAll("__","_");
        this.messageId = m;
        this.stepOrder = stepOrder;
    }

    public void run(){
        try {
            System.out.println(xml);
            HttpClient client = HttpClientUtil.getHttpClient();
            String res = HttpClientUtil.post(client, bjurl, xml,"gb2312");
            System.out.println(res);
            /**发送完毕更改状态*/
            GetAndUpdateDataFromDBService gserv= MyApplicationContextUtil.getContext().getBean(GetAndUpdateDataFromDBService.class);
            if("2".equals(stepOrder)){
                gserv.updateFlagForStepTwo(messageId,res);
            } else if("4".equals(stepOrder)) {
                gserv.updateFlagForStepFour(messageId,res);
            }
        } catch (Exception e) {
            logger.error(e.getMessage()+"xml:"+xml,e);
        }




    }
}
