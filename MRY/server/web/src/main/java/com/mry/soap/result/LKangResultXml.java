package com.mry.soap.result;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * 涞康返回xml实体
 *
 * @author vito
 * @version 1.0
 * 创建时间 2016/5/16 16:22
 */
@XmlRootElement(name = "businessdata")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class LKangResultXml {
    //提示码
    private Integer errCode;
    //提示信息
    private String errMsg;
    //用户名
    private String account;
    //密码
    private String password;
    //姓名
    private String name;
    //性别
    private String sex;
    //生日
    private String birthday;
    //身高
    private Integer height;
    //体重
    private Integer weight;
    //收缩压
    private Integer sbp;
    //舒张压
    private Integer dbp;
    //脉搏
    private Integer pulse;
    //血氧
    private Integer bo;
    //胎心
    private String fetalheart;
    //血糖
    private Double glu;
    //测量时间与上次用餐时间的差(0为空腹血糖，1为随机，2为餐后)
    private Integer hoursAfterMeal;
    //胆固醇
    @XmlElement(name = "CHOL")
    private Double chol;
    //高密度脂蛋白胆固醇
    @XmlElement(name = "HDL")
    private Double hdl;
    //低密度脂蛋白胆固醇
    @XmlElement(name = "LDL")
    private Double ldl;
    //甘油三脂
    @XmlElement(name = "TG")
    private Double tg;
    //尿酸
    @XmlElement(name = "UA")
    private Double ua;
    //脂肪
    private Double fat;
    //代谢
    private Double bmr;
    //水分
    private Double water;
    //bmi值
    private Double bmi;
    //腰围
    private Double waistline;
    //臀围
    private Double hipline;
    //腰臀比
    private Double whr;
    //骨密度t值
    private String bmd_t;
    //骨密度z值
    private String bmd_z;
    //心电pdf文件(string类型byte[]转换成字符串)
    private String ecg;
    //心电xml文件(string类型byte[]转换成字符串)
    private String ecgxml;
    //最近一个月血压数据集合
    @XmlElementWrapper(name = "result")
    @XmlElement(name = "checkdate")
    private List<com.mry.soap.result.LKbloodPressure> LKbloodPressures;
    //用户测量次数
    @XmlElementWrapper(name = "exams")
    @XmlElement(name = "exam")
    private List<com.mry.soap.result.LKExamCount> lkExamCounts;

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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
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

    public Integer getPulse() {
        return pulse;
    }

    public void setPulse(Integer pulse) {
        this.pulse = pulse;
    }

    public Integer getBo() {
        return bo;
    }

    public void setBo(Integer bo) {
        this.bo = bo;
    }

    public String getFetalheart() {
        return fetalheart;
    }

    public void setFetalheart(String fetalheart) {
        this.fetalheart = fetalheart;
    }

    public Double getGlu() {
        return glu;
    }

    public void setGlu(Double glu) {
        this.glu = glu;
    }

    public Integer getHoursAfterMeal() {
        return hoursAfterMeal;
    }

    public void setHoursAfterMeal(Integer hoursAfterMeal) {
        this.hoursAfterMeal = hoursAfterMeal;
    }

    public Double getChol() {
        return chol;
    }

    public void setChol(Double chol) {
        this.chol = chol;
    }

    public Double getHdl() {
        return hdl;
    }

    public void setHdl(Double hdl) {
        this.hdl = hdl;
    }

    public Double getLdl() {
        return ldl;
    }

    public void setLdl(Double ldl) {
        this.ldl = ldl;
    }

    public Double getTg() {
        return tg;
    }

    public void setTg(Double tg) {
        this.tg = tg;
    }

    public Double getUa() {
        return ua;
    }

    public void setUa(Double ua) {
        this.ua = ua;
    }

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public Double getBmr() {
        return bmr;
    }

    public void setBmr(Double bmr) {
        this.bmr = bmr;
    }

    public Double getWater() {
        return water;
    }

    public void setWater(Double water) {
        this.water = water;
    }

    public Double getBmi() {
        return bmi;
    }

    public void setBmi(Double bmi) {
        this.bmi = bmi;
    }

    public Double getWaistline() {
        return waistline;
    }

    public void setWaistline(Double waistline) {
        this.waistline = waistline;
    }

    public Double getHipline() {
        return hipline;
    }

    public void setHipline(Double hipline) {
        this.hipline = hipline;
    }

    public Double getWhr() {
        return whr;
    }

    public void setWhr(Double whr) {
        this.whr = whr;
    }

    public String getBmd_t() {
        return bmd_t;
    }

    public void setBmd_t(String bmd_t) {
        this.bmd_t = bmd_t;
    }

    public String getBmd_z() {
        return bmd_z;
    }

    public void setBmd_z(String bmd_z) {
        this.bmd_z = bmd_z;
    }

    public String getEcg() {
        return ecg;
    }

    public void setEcg(String ecg) {
        this.ecg = ecg;
    }

    public String getEcgxml() {
        return ecgxml;
    }

    public void setEcgxml(String ecgxml) {
        this.ecgxml = ecgxml;
    }

    public List<com.mry.soap.result.LKbloodPressure> getLKbloodPressures() {
        return LKbloodPressures;
    }

    public void setLKbloodPressures(List<com.mry.soap.result.LKbloodPressure> LKbloodPressures) {
        this.LKbloodPressures = LKbloodPressures;
    }

    public List<com.mry.soap.result.LKExamCount> getLkExamCounts() {
        return lkExamCounts;
    }

    public void setLkExamCounts(List<com.mry.soap.result.LKExamCount> lkExamCounts) {
        this.lkExamCounts = lkExamCounts;
    }
}