package com.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by chace.cai on 2014/6/26.
 * 扣费结果vo
 */
@XStreamAlias("SBMP_REPORT_MESSAGE")
public class StepFourChargeStatusVO extends BaseVO{
    /**连接号*/
    private String CONNECT_ID;
    /**短信平台信息编号。与3中的bstrMoMessageID相同*/
    private String MO_MESSAGE_ID;
    /**业务编码。第五步中返回的bstrBusinessCode*/
    private String BUSINESS_CODE;
    /**手机号*/
    private String MSISDN;
    /**提交时间 字符串*/
    private String SUBMIT_TIME;
    /**完成时间*/
    private String DONE_TIME;
    /**状态（DELIVRD：送达成功，FAILURE:送达失败）*/
    private String STATUS;

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

    public String getBUSINESS_CODE() {
        return BUSINESS_CODE;
    }

    public void setBUSINESS_CODE(String BUSINESS_CODE) {
        this.BUSINESS_CODE = BUSINESS_CODE;
    }

    public String getMSISDN() {
        return MSISDN;
    }

    public void setMSISDN(String MSISDN) {
        this.MSISDN = MSISDN;
    }

    public String getSUBMIT_TIME() {
        return SUBMIT_TIME;
    }

    public void setSUBMIT_TIME(String SUBMIT_TIME) {
        this.SUBMIT_TIME = SUBMIT_TIME;
    }

    public String getDONE_TIME() {
        return DONE_TIME;
    }

    public void setDONE_TIME(String DONE_TIME) {
        this.DONE_TIME = DONE_TIME;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }
}
