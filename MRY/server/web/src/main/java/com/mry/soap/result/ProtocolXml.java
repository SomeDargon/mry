package com.mry.soap.result;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 用户注册协议xml格式
 * @author vito
 * @version 1.0
 * 创建时间 2016/5/30 14:03
 */
@XmlRootElement(name = "businessdata")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class ProtocolXml {
    //提示码
    private Integer errCode;
    //提示信息
    private String errMsg;
    //标题
    private String title;
    //内容
    private String content;

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
