package com.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by chace.cai on 2014/6/26.
 * 第三部返回状态的VO
 */
@XStreamAlias("Data")
public class StepThreeResponseVO extends BaseVO {
    /**返回结果(0:成功，1：失败)*/
    private String Result;
    /**与请求中的bstrMoMessageID相同*/
    private String MessageID;
    private String Message;


    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    public String getMessageID() {
        return MessageID;
    }

    public void setMessageID(String messageID) {
        MessageID = messageID;
    }


}
