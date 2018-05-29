package com.mry.entity.store.card;

import com.mry.entity.common.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by kaik on 2018/1/4.
 * 活动卡管理
 */
@Entity
@Table(name = ActivityCardManagement.TABLE_NAME)
public class ActivityCardManagement extends BaseEntity {

    public static final String TABLE_NAME = "activity_card_management";


    //注册店
    @Column(name = "store_Name")
    private String storeName;

    //注册店Id
    @Column(name = "store_id")
    private Long storeId;

    //活动卡名称
    @Column(name = "activity_name")
    private String activityName;

    //活动卡现金金额
    @Column(name = "activity_cash_price")
    private BigDecimal activityCashPrice;

    //活动卡卡扣金额
    @Column(name = "activity_bckle_price")
    private BigDecimal activityBucklePrice;

    //活动有效期(月)
    @Column(name = "activity_validity")
    private Integer activityValidity;

//    //活动卡有效期(月)
//    @Column(name = "activity_card_validity")
//    private Integer activityCardValidity;

    @Column(name = "begin_time")
    private Date beginTime;

    @Column(name = "end_time")
    private Date endTime;

    //享受尊享
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activity", fetch = FetchType.LAZY)
    private List<ActivityProject> project;

    //返现方式（1卡扣项目，2现金项目，3产品）
    @Column(name = "return_mode")
    private String returnMode;

    //返现金额
    @Column(name = "return_amount")
    private BigDecimal returnAmount;

    //返现使用有效期
    @Column(name = "return_validity")
    private String returnValidity;

    //特价秒杀
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activity", fetch = FetchType.LAZY)
    private List<SpecialSecondKill> apecialSecondKill;

    //第N次到店
    @Column(name = "member_day_nto_store")
    private Integer memberDayNtoStore;

    //到店赠送
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activity", fetch = FetchType.LAZY)
    private List<ToStoreProject> toStoreProject;


    //老客户带新客户参加活动
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activity", fetch = FetchType.LAZY)
    private List<NewCustomerParticipation> newCustomerParticipation;

    //活动卡疗程
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activity", fetch = FetchType.LAZY)
    private List<CourseOfActivityCard> courseOfActivityCard;

    //产品秒杀
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activity", fetch = FetchType.LAZY)
    private List<ProductSecondKill> productSecondKill;

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

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public BigDecimal getActivityCashPrice() {
        return activityCashPrice;
    }

    public void setActivityCashPrice(BigDecimal activityCashPrice) {
        this.activityCashPrice = activityCashPrice;
    }

    public BigDecimal getActivityBucklePrice() {
        return activityBucklePrice;
    }

    public void setActivityBucklePrice(BigDecimal activityBucklePrice) {
        this.activityBucklePrice = activityBucklePrice;
    }

    public Integer getActivityValidity() {
        return activityValidity;
    }

    public void setActivityValidity(Integer activityValidity) {
        this.activityValidity = activityValidity;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public List<ActivityProject> getProject() {
        return project;
    }

    public void setProject(List<ActivityProject> project) {
        this.project = project;
    }

    public String getReturnMode() {
        return returnMode;
    }

    public void setReturnMode(String returnMode) {
        this.returnMode = returnMode;
    }

    public BigDecimal getReturnAmount() {
        return returnAmount;
    }

    public void setReturnAmount(BigDecimal returnAmount) {
        this.returnAmount = returnAmount;
    }

    public String getReturnValidity() {
        return returnValidity;
    }

    public void setReturnValidity(String returnValidity) {
        this.returnValidity = returnValidity;
    }

    public List<SpecialSecondKill> getApecialSecondKill() {
        return apecialSecondKill;
    }

    public void setApecialSecondKill(List<SpecialSecondKill> apecialSecondKill) {
        this.apecialSecondKill = apecialSecondKill;
    }

    public Integer getMemberDayNtoStore() {
        return memberDayNtoStore;
    }

    public void setMemberDayNtoStore(Integer memberDayNtoStore) {
        this.memberDayNtoStore = memberDayNtoStore;
    }

    public List<ToStoreProject> getToStoreProject() {
        return toStoreProject;
    }

    public void setToStoreProject(List<ToStoreProject> toStoreProject) {
        this.toStoreProject = toStoreProject;
    }

    public List<CourseOfActivityCard> getCourseOfActivityCard() {
        return courseOfActivityCard;
    }

    public void setCourseOfActivityCard(List<CourseOfActivityCard> courseOfActivityCard) {
        this.courseOfActivityCard = courseOfActivityCard;
    }

    public List<ProductSecondKill> getProductSecondKill() {
        return productSecondKill;
    }

    public void setProductSecondKill(List<ProductSecondKill> productSecondKill) {
        this.productSecondKill = productSecondKill;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }

    public List<NewCustomerParticipation> getNewCustomerParticipation() {
        return newCustomerParticipation;
    }

    public void setNewCustomerParticipation(List<NewCustomerParticipation> newCustomerParticipation) {
        this.newCustomerParticipation = newCustomerParticipation;
    }
}
