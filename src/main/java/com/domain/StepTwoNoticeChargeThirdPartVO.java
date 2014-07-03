package com.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by wula on 2014/6/25.
 * 第二部，通知计费平台
 */
@XStreamAlias("SBMP_MO_MESSAGE")
public class StepTwoNoticeChargeThirdPartVO extends BaseVO {
    /**短信平台连接id*/
    public String CONNECT_ID;
    /**短信信息编号*/
    public String MO_MESSAGE_ID;
    /**受理时间*/
    public Long RECEIVE_TIME;
    /**网关编号*/
    public String GATEWAY_ID="232";
    /**有效性*/
    public String VALID="1";
    /**城市区号*/
    public String CITY_CODE="028";
    /**城市名称*/
    public String CITY_NAME="成都";
    /**省份区号*/
    public String STATE_CODE;
    /**省份名称*/
    public String STATE_NAME;
    public String TP_PID ;
    /**手机号*/
    public String MSISDN;
    /**信息内容*/
    public String MESSAGE;
    /***/
    public String LONG_CODE="3";
    /**通道号*/
    public String SERVICE_CODE;
    /***/
    public String MESSAGE_TYPE="9";


    public String getTP_PID() {
        return TP_PID;
    }

    public void setTP_PID(String TP_PID) {
        this.TP_PID = TP_PID;
    }

    public String getCONNECT_ID() {
        return CONNECT_ID;
    }

    public void setCONNECT_ID(String CONNECT_ID) {
        this.CONNECT_ID = CONNECT_ID;
    }

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

    public String getGATEWAY_ID() {
        return GATEWAY_ID;
    }

    public void setGATEWAY_ID(String GATEWAY_ID) {
        this.GATEWAY_ID = GATEWAY_ID;
    }

    public String getVALID() {
        return VALID;
    }

    public void setVALID(String VALID) {
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

    public String getMESSAGE_TYPE() {
        return MESSAGE_TYPE;
    }

    public void setMESSAGE_TYPE(String MESSAGE_TYPE) {
        this.MESSAGE_TYPE = MESSAGE_TYPE;
    }


}
