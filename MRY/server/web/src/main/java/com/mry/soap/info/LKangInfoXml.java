package com.mry.soap.info;

import javax.xml.bind.annotation.*;

/**
 * 涞康接收实体
 *
 * @author vito
 * @version 1.0
 * 创建时间 2016/5/18 16:43
 */
@XmlRootElement(name = "businessdata")
@XmlAccessorType(value = XmlAccessType.FIELD)
public class LKangInfoXml {
    //体检时间
    @XmlAttribute
    private String checkdate;
    //交易码
    private Integer functioncode;
    //医院ID（可以区分是哪一台机器上传的数据）
    private String icpcode;
    //身份证号
    private String cardNo;
    //姓名
    private String fullname;
    //性别
    private String gender;
    //民族
    private String nation;
    //生日
    private String birthday;
    //地址
    private String addr;
    //城市ID
    @XmlElement(name = "ID")
    private Long cityId;
    //是否使用调查问卷（内容为Y或N）
    private String usesurvey;
    //身份证截至日期
    private String expire;
    //base64编码后的照片数据
    private String photo;
    //收缩压
    private Integer sbp;
    //舒张压
    private Integer dbp;
    //脉搏
    private Integer pulse;
    //血氧
    private Integer bo;
    //血糖
    private Double glu;
    //测量时间与上次用餐时间的差(0为空腹血糖，1为随机，2为餐后)
    private Integer hoursAfterMeal;
    //脂肪
    private Double fat;
    //基础代谢率
    private Double bmr;
    //水分含量
    private Double water;
    //身高
    private Double height;
    //体重
    private Double weight;
    //bmi值
    private Double bmi;
    //胎心率
    private String fetalheart;
    //心电PDF文件
    private String ecg;
    //心电xml文件
    private String ecgxml;
    //心电图片
    private String ecgpng;
    //手机号
    private String phone;
    //总胆固醇
    @XmlElement(name = "CHOL")
    private Double chol;
    //高密度脂蛋白胆固醇
    @XmlElement(name = "HDL")
    private Double hdl;
    //低密度脂蛋白胆固醇
    @XmlElement(name = "LDL")
    private Double ldl;
    //甘油三酯
    @XmlElement(name = "TG")
    private Double tg;
    //尿酸
    @XmlElement(name = "UA")
    private Double ua;
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

    public String getCheckdate() {
        return checkdate;
    }

    public void setCheckdate(String checkdate) {
        this.checkdate = checkdate;
    }

    public Integer getFunctioncode() {
        return functioncode;
    }

    public void setFunctioncode(Integer functioncode) {
        this.functioncode = functioncode;
    }

    public String getIcpcode() {
        return icpcode;
    }

    public void setIcpcode(String icpcode) {
        this.icpcode = icpcode;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getUsesurvey() {
        return usesurvey;
    }

    public void setUsesurvey(String usesurvey) {
        this.usesurvey = usesurvey;
    }

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getBmi() {
        return bmi;
    }

    public void setBmi(Double bmi) {
        this.bmi = bmi;
    }

    public String getFetalheart() {
        return fetalheart;
    }

    public void setFetalheart(String fetalheart) {
        this.fetalheart = fetalheart;
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

    public String getEcgpng() {
        return ecgpng;
    }

    public void setEcgpng(String ecgpng) {
        this.ecgpng = ecgpng;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
}
