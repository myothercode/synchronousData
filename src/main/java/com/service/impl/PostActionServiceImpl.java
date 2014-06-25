package com.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by wula on 2014/6/25.
 */
@Service("PostActionService")
@Scope("prototype")
public class PostActionServiceImpl implements com.service.PostActionService {
    private static final String bjurl="http://114.215.109.179:8888/payResult";

    @Override
    public void doPost(String xml) throws Exception{

        URL url=new URL(bjurl);
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
        while((result = reader.readLine())!= null)
        {

            System.out.println(result);

        }


    }
}
