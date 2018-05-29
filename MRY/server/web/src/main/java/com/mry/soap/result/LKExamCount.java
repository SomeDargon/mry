package com.mry.soap.result;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * 涞康测量次数
 * @author vito
 * @version 1.0
 * 创建时间 2016/6/22 16:00
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class LKExamCount {
    private String type;
    private Integer count;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
