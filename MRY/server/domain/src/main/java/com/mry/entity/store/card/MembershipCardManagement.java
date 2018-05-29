package com.mry.entity.store.card;

import com.mry.entity.common.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by kaik on 2018/1/3.
 * 会员卡管理
 */
@Entity
@Table(name = MembershipCardManagement.TABLE_NAME)
public class MembershipCardManagement extends BaseEntity {

    public static final String TABLE_NAME = "membership_card_management";


    //注册店
    @Column(name = "store_Name")
    private String storeName;

    //注册店Id
    @Column(name = "store_id")
    private Long storeId;

    //会员卡级别名称
    @Column(name = "membership_Name")
    private String membershipName;

    //升卡原则设定：类型（累计现金，累计充值，增量充值，单次充值），充值金额
    @Column(name = "lift_card_type")
    private String liftCardType;

    //会员卡金额
    @Column(name = "membership_money")
    private BigDecimal membershipMoney;

    //项目单次折扣
    @Column(name = "project_discount")
    private double projectDiscount=0.00;

    //产品折扣
    @Column(name = "product_discount")
    private String productDiscount;

    //会员权限有效期(月)
    @Column(name = "membership_validity")
    private Integer membershipValidity;

    //会员尊享
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "card", fetch = FetchType.LAZY)
    private List<MembersEnjoy> enjoy;

    //是否设置时间
    @Column(name = "setting_time")
    private String settingTime;

    //会员日
    @Column(name = "member_day")
    private String memberDay;

    //会员日第M次到店
    @Column(name = "member_day_nto_store")
    private Integer memberDayNtoStore;

    //会员日第N个项目
    @Column(name = "member_day_n_project")
    private Integer memberDayNProject;

    //会员日折数
    @Column(name = "member_day_discount")
    private String memberDayDiscount;

    //会员返现第M次到店
    @Column(name = "member_return_nto_store")
    private Integer memberReturnNtoStore;

    //会员返现第N个项目
    @Column(name = "member_return_n_project")
    private Integer memberReturnNProject;

    //返现金额
    @Column(name = "return_amount")
    private BigDecimal returnAmount;

    //返现金额有效期(月)
    @Column(name = "return_validity")
    private Integer returnValidity;

    //注意事项
    @Column(name = "precautions")
    private String precautions;

    //是否启用
    @Column(name = "is_enable")
    private Boolean isEnable;



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

    public BigDecimal getMembershipMoney() {
        return membershipMoney;
    }

    public void setMembershipMoney(BigDecimal membershipMoney) {
        this.membershipMoney = membershipMoney;
    }

    public double getProjectDiscount() {
        return projectDiscount;
    }

    public void setProjectDiscount(double projectDiscount) {
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

    public List<MembersEnjoy> getEnjoy() {
        return enjoy;
    }

    public void setEnjoy(List<MembersEnjoy> enjoy) {
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

    public BigDecimal getReturnAmount() {
        return returnAmount;
    }

    public void setReturnAmount(BigDecimal returnAmount) {
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

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
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
