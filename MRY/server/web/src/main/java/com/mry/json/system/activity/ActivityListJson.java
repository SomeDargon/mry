package com.mry.json.system.activity;

import com.mry.entity.store.card.ActivityCardManagement;
import com.mry.entity.store.card.MembershipCardManagement;
import com.mry.util.DatetimeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/1/11.
 */
@Api(description="活动卡管理", value = "活动卡管理")
public class ActivityListJson {

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

//    //活动卡有效期(月)
//    @ApiModelProperty(value="活动卡有效期(月)",name="activityCardValidity")
//    private Integer activityCardValidity;


    @ApiModelProperty(value="活动开始时间",name="beginTime")
    private String beginTime;

    @ApiModelProperty(value="结束开始时间",name="endTime")
    private String endTime;

    //返现方式（1卡扣项目，2现金项目，3产品）
    @ApiModelProperty(value="返现方式（1卡扣项目，2现金项目，3产品）",name="returnMode")
    private String returnMode;

    //享受尊享
    @ApiModelProperty(value="享受尊享",name="project")
    private List<ActivityProjectListJson> project;

    //返现金额
    @ApiModelProperty(value="返现金额",name="returnAmount")
    private String returnAmount;

    //返现使用有效期
    @ApiModelProperty(value="返现使用有效期",name="returnValidity")
    private String returnValidity;

    //特价秒杀
    @ApiModelProperty(value="特价秒杀",name="apecialSecondKill")
    private List<SpecialSecondKillListJson> apecialSecondKill;

    //第N次到店
    @ApiModelProperty(value="第N次到店",name="memberDayNtoStore")
    private Integer memberDayNtoStore;

    //老客户带新客户参加活动
    @ApiModelProperty(value="老客户带新客户参加活动",name="toStoreProject")
    private List<NewCustomerParticipationListJson> newCustomerParticipation;


    //到店赠送
    @ApiModelProperty(value="到店赠送",name="toStoreProject")
    private List<ToStoreProjectListJson> toStoreProject;

    //活动卡疗程
    @ApiModelProperty(value="活动卡疗程",name="courseOfActivityCard")
    private List<CourseOfActivityListJson> courseOfActivityCard;

    //产品秒杀
    @ApiModelProperty(value="产品秒杀",name="productSecondKill")
    private List<ProductSecondKillListJson> productSecondKill;



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

    public Integer getMemberDayNtoStore() {
        return memberDayNtoStore;
    }

    public void setMemberDayNtoStore(Integer memberDayNtoStore) {
        this.memberDayNtoStore = memberDayNtoStore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ActivityProjectListJson> getProject() {
        return project;
    }

    public void setProject(List<ActivityProjectListJson> project) {
        this.project = project;
    }

    public List<SpecialSecondKillListJson> getApecialSecondKill() {
        return apecialSecondKill;
    }

    public void setApecialSecondKill(List<SpecialSecondKillListJson> apecialSecondKill) {
        this.apecialSecondKill = apecialSecondKill;
    }

    public List<ToStoreProjectListJson> getToStoreProject() {
        return toStoreProject;
    }

    public void setToStoreProject(List<ToStoreProjectListJson> toStoreProject) {
        this.toStoreProject = toStoreProject;
    }

    public List<CourseOfActivityListJson> getCourseOfActivityCard() {
        return courseOfActivityCard;
    }

    public void setCourseOfActivityCard(List<CourseOfActivityListJson> courseOfActivityCard) {
        this.courseOfActivityCard = courseOfActivityCard;
    }

    public List<ProductSecondKillListJson> getProductSecondKill() {
        return productSecondKill;
    }

    public void setProductSecondKill(List<ProductSecondKillListJson> productSecondKill) {
        this.productSecondKill = productSecondKill;
    }

    public List<NewCustomerParticipationListJson> getNewCustomerParticipation() {
        return newCustomerParticipation;
    }

    public void setNewCustomerParticipation(List<NewCustomerParticipationListJson> newCustomerParticipation) {
        this.newCustomerParticipation = newCustomerParticipation;
    }

    public ActivityListJson(ActivityCardManagement data) {
        this.id = data.getId();
        this.storeName = data.getStoreName();
        this.storeId = data.getStoreId();
        this.activityName = data.getActivityName();
        if(data.getActivityCashPrice() != null) {
            this.activityCashPrice = data.getActivityCashPrice().toString();
        }

        if(data.getActivityBucklePrice() != null) {
            this.activityBucklePrice = data.getActivityBucklePrice().toString();
        }

        this.activityValidity = data.getActivityValidity();
     //   this.activityCardValidity = data.getActivityCardValidity();
        if(data.getEndTime() != null) {
            this.endTime = DatetimeUtil.formatDate(data.getEndTime());
        }
        if(data.getEndTime() != null) {
            this.beginTime = DatetimeUtil.formatDate(data.getBeginTime());
        }

        this.returnMode = data.getReturnMode();
        if(data.getReturnAmount() != null) {
            this.returnAmount = data.getReturnAmount().toString();
        }
        this.returnValidity = data.getReturnValidity();
        this.memberDayNtoStore = data.getMemberDayNtoStore();
        if(data.getProject() !=null){
            this.project = new ArrayList<>();
            data.getProject().forEach(a  ->this.project.add(new ActivityProjectListJson(a)));
        }
        if(data.getApecialSecondKill() !=null){
            this.apecialSecondKill = new ArrayList<>();
            data.getApecialSecondKill().forEach(a  ->this.apecialSecondKill.add(new SpecialSecondKillListJson(a)));
        }

        if(data.getToStoreProject() !=null){
            this.toStoreProject = new ArrayList<>();
            data.getToStoreProject().forEach(a  ->this.toStoreProject.add(new ToStoreProjectListJson(a)));
        }
        if(data.getCourseOfActivityCard() !=null){
            this.courseOfActivityCard = new ArrayList<>();
            data.getCourseOfActivityCard().forEach(a  ->this.courseOfActivityCard.add(new CourseOfActivityListJson(a)));
        }

        if(data.getNewCustomerParticipation() !=null){
            this.newCustomerParticipation = new ArrayList<>();
            data.getNewCustomerParticipation().forEach(a  ->this.newCustomerParticipation.add(new NewCustomerParticipationListJson(a)));
        }

        if(data.getProductSecondKill() !=null){
            this.productSecondKill = new ArrayList<>();
            data.getProductSecondKill().forEach(a  ->this.productSecondKill.add(new ProductSecondKillListJson(a)));
        }


    }
}
