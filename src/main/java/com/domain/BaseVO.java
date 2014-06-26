package com.domain;

import com.thoughtworks.xstream.XStream;

/**
 * Created by chace.cai on 2014/6/26.
 */
public class BaseVO {
    public String getXML(){
        XStream xstream = new XStream();
        xstream.processAnnotations(this.getClass());
        xstream.setMode(XStream.NO_REFERENCES);
        String s=xstream.toXML(this);
        if(!s.startsWith ("<?xml")){
            s="<?xml version=\"1.0\" encoding=\"GB2312\"?>\n"+s;
        }
        return s;
    }
}
