package com.util;

import com.domain.StepThreeResponseVO;
import com.thoughtworks.xstream.XStream;
import com.util.commUtil.comm.JSONSimpler;
import org.apache.log4j.Logger;

/**
 * Created by chace.cai on 2014/7/1.
 */
public class MainTestUtil {
    static Logger logger = Logger.getLogger(MainTestUtil.class);
    private static final String bjurl="http://114.215.109.179:8888/payResult";
    //public static AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");

    public static void main(String[] args) throws Exception {
     String xmls="<?xml version=\"1.0\" encoding=\"GB2312\" ?><Data><Result>0</Result><Message>成功</Message></Data>";
        XStream xStream = new XStream();
        xStream.alias("Data", StepThreeResponseVO.class);
        StepThreeResponseVO stepThreeResponseVO= (StepThreeResponseVO) xStream.fromXML(xmls);
        System.out.println("over");






        /*StepTwoNoticeChargeThirdPartVO stepTwoNoticeChargeThirdPart = new StepTwoNoticeChargeThirdPartVO();
        stepTwoNoticeChargeThirdPart.setCONNECT_ID("1001111");
        stepTwoNoticeChargeThirdPart.setCITY_CODE("028");
        stepTwoNoticeChargeThirdPart.setCITY_NAME("成都");
        stepTwoNoticeChargeThirdPart.setMO_MESSAGE_ID("1231231238851");
        stepTwoNoticeChargeThirdPart.setSERVICE_CODE("10628997");
        stepTwoNoticeChargeThirdPart.setMESSAGE("kt1_14080302074538205_成都联通");
        stepTwoNoticeChargeThirdPart.setRECEIVE_TIME(new Date().getTime());
        stepTwoNoticeChargeThirdPart.setMSISDN("18602861176");
        stepTwoNoticeChargeThirdPart.setTP_PID("0");
        stepTwoNoticeChargeThirdPart.setSTATE_CODE("028");
        stepTwoNoticeChargeThirdPart.setSTATE_NAME("成都");
        if(QueueAndPool.taskExecutor==null){
            QueueAndPool.taskExecutor= MyApplicationContextUtil.getContext().getBean("taskExecutor", TaskExecutor.class);
        }
        QueueAndPool.taskExecutor.execute(new PostActionServiceRunAble(stepTwoNoticeChargeThirdPart.getXML().replaceAll("__","_"),"dddcc","2"));*/

        /*String xml=getxml1();
        try {HttpClient client = HttpClientUtil.getHttpClient();
            String res = HttpClientUtil.post(client, bjurl, xml,"gb2312");
            System.err.println(res);

        } catch (Exception e) {
            logger.error(e.getMessage()+"xml:"+xml,e);
        }*/
    }



    private static String getxml1(){
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"GB2312\" ?>");
        sb.append("<SBMP_MO_MESSAGE>");
        sb.append("    <CONNECT_ID>100</CONNECT_ID>");
        sb.append("    <MO_MESSAGE_ID>");
        sb.append("1231231238851");
        sb.append("</MO_MESSAGE_ID>");
        sb.append("    <RECEIVE_TIME>");
        sb.append("1231231238851");
        sb.append("</RECEIVE_TIME>");
        sb.append("    <GATEWAY_ID>201</GATEWAY_ID>");
        sb.append("    <VALID>1</VALID>");
        sb.append("    <CITY_CODE>028</CITY_CODE>");
        sb.append("    <CITY_NAME>北京</CITY_NAME>");
        sb.append("    <STATE_CODE>028</STATE_CODE>");
        sb.append("    <STATE_NAME>北京</STATE_NAME>");
        sb.append("    <TP_PID>0</TP_PID>");
        sb.append("    <MSISDN>18610650144</MSISDN>");
        sb.append("    <MESSAGE_TYPE>8</MESSAGE_TYPE>");
        sb.append("    <MESSAGE>kt1_");
        sb.append("14080302074538205");
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
