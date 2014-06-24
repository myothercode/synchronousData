package com.domain;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by wula on 2014/6/24.
 * 第一步，同步手机号码VO
 */
@XStreamAlias("SBMP_MO_MESSAGE")
public class StepOneSendPhoneNoToThird {
    /**短信平台连接编号（不重复）*/
    private String CONNECT_ID;
    /**短信平台信息编号（不重复）*/
    private String MO_MESSAGE_ID;
    /**受理时间*/
    private Long RECEIVE_TIME;
    /**网关编号(移动101,电信310,联通232)*/
    private Integer GATEWAY_ID = 232;
    /**有效性*/
    private Integer VALID=1;
    private String CITY_CODE="028";
    private String CITY_NAME="";
    private String STATE_CODE="";
    private String STATE_NAME="";
    /**手机号*/
    private String MSISDN;
    private String MESSAGE_TYPE="8";
    /**消息内容*/
    private String MESSAGE;
    private String LONG_CODE="1";
    /*短信平台编号*/
    private String SERVICE_CODE;


    public String getMO_MESSAGE_ID() {
        return MO_MESSAGE_ID;
    }

    public void setMO_MESSAGE_ID(String MO_MESSAGE_ID) {
        this.MO_MESSAGE_ID = MO_MESSAGE_ID;
    }

    public Long getRECEIVE_TIME() {
        return RECEIVE_TIME;
    }

    public void setRECEIVE_TIME(Long RECEIVE_TIME) {
        this.RECEIVE_TIME = RECEIVE_TIME;
    }

    public Integer getGATEWAY_ID() {
        return GATEWAY_ID;
    }

    public void setGATEWAY_ID(Integer GATEWAY_ID) {
        this.GATEWAY_ID = GATEWAY_ID;
    }

    public Integer getVALID() {
        return VALID;
    }

    public void setVALID(Integer VALID) {
        this.VALID = VALID;
    }

    public String getCITY_CODE() {
        return CITY_CODE;
    }

    public void setCITY_CODE(String CITY_CODE) {
        this.CITY_CODE = CITY_CODE;
    }

    public String getCITY_NAME() {
        return CITY_NAME;
    }

    public void setCITY_NAME(String CITY_NAME) {
        this.CITY_NAME = CITY_NAME;
    }

    public String getSTATE_CODE() {
        return STATE_CODE;
    }

    public void setSTATE_CODE(String STATE_CODE) {
        this.STATE_CODE = STATE_CODE;
    }

    public String getSTATE_NAME() {
        return STATE_NAME;
    }

    public void setSTATE_NAME(String STATE_NAME) {
        this.STATE_NAME = STATE_NAME;
    }

    public String getMSISDN() {
        return MSISDN;
    }

    public void setMSISDN(String MSISDN) {
        this.MSISDN = MSISDN;
    }

    public String getMESSAGE_TYPE() {
        return MESSAGE_TYPE;
    }

    public void setMESSAGE_TYPE(String MESSAGE_TYPE) {
        this.MESSAGE_TYPE = MESSAGE_TYPE;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public String getLONG_CODE() {
        return LONG_CODE;
    }

    public void setLONG_CODE(String LONG_CODE) {
        this.LONG_CODE = LONG_CODE;
    }

    public String getSERVICE_CODE() {
        return SERVICE_CODE;
    }

    public void setSERVICE_CODE(String SERVICE_CODE) {
        this.SERVICE_CODE = SERVICE_CODE;
    }

    public String getCONNECT_ID() {
        return CONNECT_ID;
    }

    public void setCONNECT_ID(String CONNECT_ID) {
        this.CONNECT_ID = CONNECT_ID;
    }

    public String getXML(){
        XStream xstream = new XStream();
        xstream.processAnnotations(StepOneSendPhoneNoToThird.class);
        xstream.setMode(XStream.NO_REFERENCES);
        String s=xstream.toXML(this);
        if(!s.startsWith ("<?xml")){
          s="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+s;
        }
        return s;
    }
}
