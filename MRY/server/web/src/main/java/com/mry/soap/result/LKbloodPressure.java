package com.mry.soap.result;


import com.mry.util.DatetimeUtil;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.Date;

/**
 * 涞康血压数据
 *
 * @author vito
 * @version 1.0
 * 创建时间 2016/5/19 11:27
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class LKbloodPressure {

    public LKbloodPressure() {
    }

    public LKbloodPressure(Date checkDate, Integer sbp, Integer dbp) {
        this.checkDate = DatetimeUtil.formatDate(checkDate);
        this.sbp = sbp;
        this.dbp = dbp;
    }

    //测量时间
    @XmlAttribute(name = "value")
    private String checkDate;
    //收缩压
    private Integer sbp;
    //舒张压
    private Integer dbp;

    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    public Integer getSbp() {
        return sbp;
    }

    public void setSbp(Integer sbp) {
        this.sbp = sbp;
    }

    public Integer getDbp() {
        return dbp;
    }

    public void setDbp(Integer dbp) {
        this.dbp = dbp;
    }
}
