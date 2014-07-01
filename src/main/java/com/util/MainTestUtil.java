package com.util;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by chace.cai on 2014/7/1.
 */
public class MainTestUtil {
    static Logger logger = Logger.getLogger(MainTestUtil.class);
    private static final String bjurl="http://114.215.109.179:8888/payResult";
    //public static AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");

    public static void main(String[] args) throws Exception {
        URL url= null;
        String xml=getxml1();
        try {url = new URL(bjurl);
            URLConnection conn=  url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestProperty("Cache-Control", "no-cache");
            conn.setRequestProperty("Content-Type", "text/plain; charset=GB2312");
            conn.setRequestProperty("http.protocol.version", "HTTP/1.1");
            conn.setRequestProperty("http.socket.timeout", "60000");
            conn.setRequestProperty("http.conn-manager.max-total", "100");
            conn.setRequestProperty("http.protocol.allow-circular-redirects", "false");
            conn.setRequestProperty("http.connection.timeout", "10000");

            conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows; U; Windows NT 6.0; zh-CN; rv:1.9.1.8) Gecko/20100202 Firefox/3.5.8 (.NET CLR 3.5.30729)");
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

        } catch (Exception e) {
            logger.error(e.getMessage()+"xml:"+xml,e);
        }
    }



    private static String getxml1(){
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"GB2312\" ?>");
        sb.append("<SBMP_MO_MESSAGE>");
        sb.append("    <CONNECT_ID>100</CONNECT_ID>");
        sb.append("    <MO_MESSAGE_ID>");
        sb.append("1231231238856");
        sb.append("</MO_MESSAGE_ID>");
        sb.append("    <RECEIVE_TIME>");
        sb.append("1231231238856");
        sb.append("</RECEIVE_TIME>");
        sb.append("    <GATEWAY_ID>201</GATEWAY_ID>");
        sb.append("    <VALID>1</VALID>");
        sb.append("    <CITY_CODE>010</CITY_CODE>");
        sb.append("    <CITY_NAME>北京</CITY_NAME>");
        sb.append("    <STATE_CODE>010</STATE_CODE>");
        sb.append("    <STATE_NAME>北京</STATE_NAME>");
        sb.append("    <TP_PID>0</TP_PID>");
        sb.append("    <MSISDN>18610650144</MSISDN>");
        sb.append("    <MESSAGE_TYPE>8</MESSAGE_TYPE>");
        sb.append("    <MESSAGE>kt1_");
        sb.append("14510102073015051");
        sb.append("_成都联通</MESSAGE>");
        sb.append("    <LONG_CODE>3</LONG_CODE>");
        sb.append("    <SERVICE_CODE>chengduliantong</SERVICE_CODE>");
        sb.append("</SBMP_MO_MESSAGE>");

        return sb.toString();
    }

}
