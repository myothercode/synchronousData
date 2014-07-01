package com.util;

import com.util.commUtil.comm.JSONSimpler;
import org.apache.log4j.Logger;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by chace.cai on 2014/7/1.
 */
public class MainTestUtil {
    static Logger logger = Logger.getLogger(MainTestUtil.class);
    private static final String bjurl="http://114.215.109.179:8888/payResult";
    //public static AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");

    public static void main(String[] args) throws Exception {
        URL url= null;
        String xml=getJson2();
        try {url = new URL(bjurl);
            HttpURLConnection conn=  (HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestProperty("Cache-Control", "no-cache");
            conn.setRequestProperty("Content-Type", "text/plain; charset=GB2312");
            conn.setRequestProperty("http.protocol.version", "HTTP/1.1");
            conn.setRequestProperty("http.socket.timeout", "60000");
            conn.setRequestProperty("http.conn-manager.max-total", "100");
            conn.setRequestProperty("http.protocol.allow-circular-redirects", "false");
            conn.setRequestProperty("http.connection.timeout", "10000");
            conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows; U; Windows NT 6.0; zh-CN; rv:1.9.1.8) Gecko/20100202 Firefox/3.5.8 (.NET CLR 3.5.30729)");
            conn.setRequestMethod("POST");
            conn.connect();

            //OutputStreamWriter opw=new OutputStreamWriter(conn.getOutputStream(),"GB2312");
            DataOutputStream out = new DataOutputStream(conn.getOutputStream());
            out.writeBytes(xml); //写入请求的字符串
            out.flush();
            out.close();


            InputStream in=conn.getInputStream();
            System.out.println(in.available());
            byte[] data1 = new byte[in.available()];
            String a="";
            in.read(data1);
            //转成字符串
            a = new String(data1);
            System.out.println(a);
            /*opw.write(new String( xml.getBytes(),"GB2312"));
            opw.flush();
            opw.close();*/

            /*InputStreamReader read=new InputStreamReader(conn.getInputStream(),"GB2312");
            BufferedReader reader=new BufferedReader(read);
            String result="";
            String responseTEXT="";
            while((result = reader.readLine())!= null)
            {

                System.out.println(result);
                responseTEXT+=result;

            }*/

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


    public static String getJson2(){
        SdkParams sdkParams = new SdkParams();
        sdkParams.setAppId("FA6F7EA9678DAD0BC77296CF871C4A4A");
        sdkParams.setBillingCode("10000024");
        sdkParams.setChannel("test-chengdu");
        sdkParams.setImsi("1861065014418610650144");
        sdkParams.setP_mid("18610650144");
        sdkParams.setP_money("3");
        sdkParams.setHmac("dsdawsda");
        return JSONSimpler.toJson(sdkParams);
    }
    static class SdkParams{
        private String orderId;
        private String AppId;
        private String billingCode;
        private String Imsi;
        private String p_str;
        private String Channel;
        private String p_money;
        private String p_sp_money;
        private String p_channel_id;
        private String p_mid;
        private String p_res;
        private String hmac;

        public String getOrderId() {
            return orderId;
        }
        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }
        public String getAppId() {
            return AppId;
        }
        public void setAppId(String appId) {
            AppId = appId;
        }
        public String getBillingCode() {
            return billingCode;
        }
        public void setBillingCode(String billingCode) {
            this.billingCode = billingCode;
        }
        public String getImsi() {
            return Imsi;
        }
        public void setImsi(String imsi) {
            Imsi = imsi;
        }
        public String getP_str() {
            return p_str;
        }
        public void setP_str(String p_str) {
            this.p_str = p_str;
        }
        public String getChannel() {
            return Channel;
        }
        public void setChannel(String channel) {
            Channel = channel;
        }
        public String getP_money() {
            return p_money;
        }
        public void setP_money(String p_money) {
            this.p_money = p_money;
        }
        public String getP_sp_money() {
            return p_sp_money;
        }
        public void setP_sp_money(String p_sp_money) {
            this.p_sp_money = p_sp_money;
        }
        public String getP_channel_id() {
            return p_channel_id;
        }
        public void setP_channel_id(String p_channel_id) {
            this.p_channel_id = p_channel_id;
        }
        public String getP_mid() {
            return p_mid;
        }
        public void setP_mid(String p_mid) {
            this.p_mid = p_mid;
        }
        public String getP_res() {
            return p_res;
        }
        public void setP_res(String p_res) {
            this.p_res = p_res;
        }
        public String getHmac() {
            return hmac;
        }
        public void setHmac(String hmac) {
            this.hmac = hmac;
        }
    }

}
