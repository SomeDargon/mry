package com.mry.json.system;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by kaik on 2018/1/3.
 */
@Api(description="会员卡管理", value = "会员卡管理")
public class MembershipJson {


    //Id
    private Long id;

    //注册店
    @ApiModelProperty(value="注册店",name="storeName")
    private String storeName;

    //注册店Id
    @ApiModelProperty(value="注册店Id",name="storeId")
    private Long storeId;

    //会员卡级别名称
    @ApiModelProperty(value="会员卡级别名称",name="membershipName")
    private String membershipName;

    //升卡原则设定：类型（累计现金，累计充值，增量充值，单次充值），充值金额
    @ApiModelProperty(value="类型（累计现金，累计充值，增量充值，单次充值），充值金额",name="liftCardType")
    private String liftCardType;

    //会员卡金额
    @ApiModelProperty(value="会员卡金额",name="membershipMoney")
    private String membershipMoney;

    //项目单次折扣
    @ApiModelProperty(value="项目单次折扣",name="projectDiscount")
    private String projectDiscount;

    //产品折扣
    @ApiModelProperty(value="产品折扣",name="productDiscount")
    private String productDiscount;

    //会员权限有效期(月)
    @ApiModelProperty(value="会员权限有效期(月)",name="membershipValidity")
    private Integer membershipValidity;

    //会员尊享
    @ApiModelProperty(value="会员尊享",name="enjoy")
    private List<MembersEnjoyJson> enjoy;

    //是否设置时间
    @ApiModelProperty(value="是否设置时间",name="settingTime")
    private String settingTime;

    //会员日
    @ApiModelProperty(value="会员日",name="memberDay")
    private String memberDay;

    //会员日第M次到店
    @ApiModelProperty(value="会员日第M次到店",name="memberDayNtoStore")
    private Integer memberDayNtoStore;

    //会员日第N个项目
    @ApiModelProperty(value="会员日第N个项目",name="memberDayNProject")
    private Integer memberDayNProject;

    //会员日折数
    @ApiModelProperty(value="会员日折数",name="memberDayDiscount")
    private String memberDayDiscount;

    //会员返现第M次到店
    @ApiModelProperty(value="会员返现第M次到店",name="memberReturnNtoStore")
    private Integer memberReturnNtoStore;

    //会员返现第N个项目
    @ApiModelProperty(value="会员返现第N个项目",name="memberReturnNProject")
    private Integer memberReturnNProject;

    //返现金额
    @ApiModelProperty(value="返现金额",name="returnAmount")
    private String returnAmount;

    //返现金额有效期(月)
    @ApiModelProperty(value="返现金额有效期(月)",name="returnValidity")
    private Integer returnValidity;

    //注意事项
    @ApiModelProperty(value="注意事项",name="precautions")
    private String precautions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getMembershipName() {
        return membershipName;
    }

    public void setMembershipName(String membershipName) {
        this.membershipName = membershipName;
    }

    public String getMembershipMoney() {
        return membershipMoney;
    }

    public void setMembershipMoney(String membershipMoney) {
        this.membershipMoney = membershipMoney;
    }

    public String getProjectDiscount() {
        return projectDiscount;
    }

    public void setProjectDiscount(String projectDiscount) {
        this.projectDiscount = projectDiscount;
    }

    public String getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(String productDiscount) {
        this.productDiscount = productDiscount;
    }

    public Integer getMembershipValidity() {
        return membershipValidity;
    }

    public void setMembershipValidity(Integer membershipValidity) {
        this.membershipValidity = membershipValidity;
    }

    public List<MembersEnjoyJson> getEnjoy() {
        return enjoy;
    }

    public void setEnjoy(List<MembersEnjoyJson> enjoy) {
        this.enjoy = enjoy;
    }

    public String getMemberDay() {
        return memberDay;
    }

    public void setMemberDay(String memberDay) {
        this.memberDay = memberDay;
    }

    public Integer getMemberDayNtoStore() {
        return memberDayNtoStore;
    }

    public void setMemberDayNtoStore(Integer memberDayNtoStore) {
        this.memberDayNtoStore = memberDayNtoStore;
    }

    public Integer getMemberDayNProject() {
        return memberDayNProject;
    }

    public void setMemberDayNProject(Integer memberDayNProject) {
        this.memberDayNProject = memberDayNProject;
    }

    public String getMemberDayDiscount() {
        return memberDayDiscount;
    }

    public void setMemberDayDiscount(String memberDayDiscount) {
        this.memberDayDiscount = memberDayDiscount;
    }

    public Integer getMemberReturnNtoStore() {
        return memberReturnNtoStore;
    }

    public void setMemberReturnNtoStore(Integer memberReturnNtoStore) {
        this.memberReturnNtoStore = memberReturnNtoStore;
    }

    public Integer getMemberReturnNProject() {
        return memberReturnNProject;
    }

    public void setMemberReturnNProject(Integer memberReturnNProject) {
        this.memberReturnNProject = memberReturnNProject;
    }

    public String getReturnAmount() {
        return returnAmount;
    }

    public void setReturnAmount(String returnAmount) {
        this.returnAmount = returnAmount;
    }

    public Integer getReturnValidity() {
        return returnValidity;
    }

    public void setReturnValidity(Integer returnValidity) {
        this.returnValidity = returnValidity;
    }

    public String getPrecautions() {
        return precautions;
    }

    public void setPrecautions(String precautions) {
        this.precautions = precautions;
    }

    public String getLiftCardType() {
        return liftCardType;
    }

    public void setLiftCardType(String liftCardType) {
        this.liftCardType = liftCardType;
    }

    public String getSettingTime() {
        return settingTime;
    }

    public void setSettingTime(String settingTime) {
        this.settingTime = settingTime;
    }
}
