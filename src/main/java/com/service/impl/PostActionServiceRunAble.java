package com.service.impl;

import com.main.MainClass;
import com.service.GetAndUpdateDataFromDBService;
import com.util.commUtil.comm.MyApplicationContextUtil;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

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
        this.xml=xml;
        this.messageId = m;
        this.stepOrder = stepOrder;
    }

    public void run(){
        URL url= null;
        try {url = new URL(bjurl);
        URLConnection conn=  url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestProperty("Cache-Control", "no-cache");
        conn.setRequestProperty("Content-Type", "text/xml");
       // conn.setRequestMethod("POST");

        OutputStreamWriter opw=new OutputStreamWriter(conn.getOutputStream(),"GB2312");

        opw.write(new String( xml.getBytes(),"GB2312"));
        opw.flush();
        opw.close();

        InputStreamReader read=new InputStreamReader(conn.getInputStream(),"GB2312");
        BufferedReader reader=new BufferedReader(read);
        String result="";
        String responseTEXT="";
        while((result = reader.readLine())!= null)
        {

            System.out.println(result);
            responseTEXT+=result;

        }
            /**发送完毕更改状态*/
            GetAndUpdateDataFromDBService gserv= MyApplicationContextUtil.getContext().getBean(GetAndUpdateDataFromDBService.class);
            if("2".equals(stepOrder)){
                gserv.updateFlagForStepTwo(messageId,responseTEXT);
            } else if("4".equals(stepOrder)) {
                gserv.updateFlagForStepFour(messageId,responseTEXT);
            }
        } catch (Exception e) {
            logger.error(e.getMessage()+"xml:"+xml,e);
        }




    }
}
