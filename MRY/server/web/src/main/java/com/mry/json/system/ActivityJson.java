package com.mry.json.system;

import com.mry.json.system.activity.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by kaik on 2018/1/11.
 */
@Api(description="活动卡管理", value = "活动卡管理")
public class ActivityJson {


    private Long id;

    //注册店
    @ApiModelProperty(value="注册店",name="storeName")
    private String storeName;

    //注册店Id
    @ApiModelProperty(value="注册店Id",name="storeId")
    private Long storeId;

    //活动卡名称
    @ApiModelProperty(value="活动卡名称",name="activityName")
    private String activityName;


    //活动卡现金金额
    @ApiModelProperty(value="活动卡现金金额",name="activityCashPrice")
    private String activityCashPrice;

    //活动卡卡扣金额
    @ApiModelProperty(value="活动卡卡扣金额",name="activityBucklePrice")
    private String activityBucklePrice;

    //活动有效期(月)
    @ApiModelProperty(value="活动有效期(月)",name="activityValidity")
    private Integer activityValidity;
//
//    //活动卡有效期(月)
//    @ApiModelProperty(value="活动卡有效期(月)",name="activityCardValidity")
//    private Integer activityCardValidity;

    @ApiModelProperty(value="活动开始时间",name="beginTime")
    private String beginTime;

    @ApiModelProperty(value="结束开始时间",name="endTime")
    private String endTime;

    //享受尊享
    @ApiModelProperty(value="享受尊享",name="project")
    private List<ActivityProjectJson> project;

    //返现方式（1卡扣项目，2现金项目，3产品）
    @ApiModelProperty(value="返现方式（1卡扣项目，2现金项目，3产品）",name="returnMode")
    private String returnMode;

    //返现金额
    @ApiModelProperty(value="返现金额",name="returnAmount")
    private String returnAmount;

    //返现使用有效期
    @ApiModelProperty(value="返现使用有效期",name="returnValidity")
    private String returnValidity;

    //特价秒杀
    @ApiModelProperty(value="特价秒杀",name="apecialSecondKill")
    private List<SpecialSecondKillJson> apecialSecondKill;

    //第N次到店
    @ApiModelProperty(value="第N次到店",name="memberDayNtoStore")
    private Integer memberDayNtoStore;

    //到店赠送
    @ApiModelProperty(value="到店赠送",name="toStoreProject")
    private List<ToStoreProjectJson> toStoreProject;

    //老客户带新客户参加活动
    @ApiModelProperty(value="老客户带新客户参加活动",name="toStoreProject")
    private List<NewCustomerParticipationJson> newCustomerParticipation;

    //活动卡疗程
    @ApiModelProperty(value="活动卡疗程",name="courseOfActivityCard")
    private List<CourseOfActivityCardJson> courseOfActivityCard;

    //产品秒杀
    @ApiModelProperty(value="产品秒杀",name="productSecondKill")
    private List<ProductSecondKillJson> productSecondKill;

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

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityCashPrice() {
        return activityCashPrice;
    }

    public void setActivityCashPrice(String activityCashPrice) {
        this.activityCashPrice = activityCashPrice;
    }

    public String getActivityBucklePrice() {
        return activityBucklePrice;
    }

    public void setActivityBucklePrice(String activityBucklePrice) {
        this.activityBucklePrice = activityBucklePrice;
    }

    public Integer getActivityValidity() {
        return activityValidity;
    }

    public void setActivityValidity(Integer activityValidity) {
        this.activityValidity = activityValidity;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public List<ActivityProjectJson> getProject() {
        return project;
    }

    public void setProject(List<ActivityProjectJson> project) {
        this.project = project;
    }

    public String getReturnMode() {
        return returnMode;
    }

    public void setReturnMode(String returnMode) {
        this.returnMode = returnMode;
    }

    public String getReturnAmount() {
        return returnAmount;
    }

    public void setReturnAmount(String returnAmount) {
        this.returnAmount = returnAmount;
    }

    public String getReturnValidity() {
        return returnValidity;
    }

    public void setReturnValidity(String returnValidity) {
        this.returnValidity = returnValidity;
    }

    public List<SpecialSecondKillJson> getApecialSecondKill() {
        return apecialSecondKill;
    }

    public void setApecialSecondKill(List<SpecialSecondKillJson> apecialSecondKill) {
        this.apecialSecondKill = apecialSecondKill;
    }

    public Integer getMemberDayNtoStore() {
        return memberDayNtoStore;
    }

    public void setMemberDayNtoStore(Integer memberDayNtoStore) {
        this.memberDayNtoStore = memberDayNtoStore;
    }

    public List<ToStoreProjectJson> getToStoreProject() {
        return toStoreProject;
    }

    public void setToStoreProject(List<ToStoreProjectJson> toStoreProject) {
        this.toStoreProject = toStoreProject;
    }

    public List<CourseOfActivityCardJson> getCourseOfActivityCard() {
        return courseOfActivityCard;
    }

    public void setCourseOfActivityCard(List<CourseOfActivityCardJson> courseOfActivityCard) {
        this.courseOfActivityCard = courseOfActivityCard;
    }

    public List<ProductSecondKillJson> getProductSecondKill() {
        return productSecondKill;
    }

    public void setProductSecondKill(List<ProductSecondKillJson> productSecondKill) {
        this.productSecondKill = productSecondKill;
    }

    public List<NewCustomerParticipationJson> getNewCustomerParticipation() {
        return newCustomerParticipation;
    }

    public void setNewCustomerParticipation(List<NewCustomerParticipationJson> newCustomerParticipation) {
        this.newCustomerParticipation = newCustomerParticipation;
    }
}
