package com.magic.pay.builder;

import com.magic.vider.util.XStreamUtil;

public abstract class WxRequestBuilder {
    public abstract Object getBizContent();
    //微信签名返回值
    public abstract String toSignString();
    //对象转成xml
    public String toXmlString() {
    	String result = XStreamUtil.objectToXml(this.getBizContent());
    	return result;
    }
}
