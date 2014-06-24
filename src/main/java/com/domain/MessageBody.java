package com.domain;

import java.util.Date;

/**
 * Created by wula on 2014/6/23.
 */
public class MessageBody {
    /**服务号*/
    private String serviceCode;
    /**识别号*/
    private String reserve;
    /**手机号*/
    private String phoneNo;
    /**短信内容*/
    private String message;
    /**创建时间*/
    private Date createDate;
    /**同步成功时间*/
    private Date sendTime;


    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}
