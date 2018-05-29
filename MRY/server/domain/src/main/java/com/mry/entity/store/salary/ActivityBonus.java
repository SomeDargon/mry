package com.mry.entity.store.salary;

import com.mry.entity.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by kaik on 2018/1/18.
 * 活动奖金
 */
@ApiModel(value="活动奖金",description="活动奖金")
@Entity
@Table(name = ActivityBonus.TABLE_NAME)
public class ActivityBonus extends BaseEntity {

    public static final String TABLE_NAME = "activity_bonus";

    //注册店
    @ApiModelProperty(value="注册店",name="storeName")
    @Column(name = "store_Name")
    private String storeName;

    //注册店Id
    @ApiModelProperty(value="注册店Id",name="storeId")
    @Column(name = "store_id")
    private Long storeId;

    //开始时间
    @ApiModelProperty(value="开始时间",name="startingTime")
    @Column(name = "starting_time")
    private String startingTime;

    //结束时间
    @ApiModelProperty(value="结束时间",name="endTime")
    @Column(name = "end_time")
    private String endTime;

    //计算类型
    @ApiModelProperty(value="计算类型",name="calculateTheType")
    @Column(name = "calculate_the_type")
    private String calculateTheType;

    //奖金总额
    @ApiModelProperty(value="奖金总额",name="totalBonus")
    @Column(name = "total_bonus")
    private BigDecimal totalBonus;

    //低限
    @ApiModelProperty(value="低限",name="lowLimit")
    @Column(name = "low_limit")
    private String lowLimit;

    //高限
    @ApiModelProperty(value="高限",name="highLimit")
    @Column(name = "high_limit")
    private String highLimit;

    //分配类型
    @ApiModelProperty(value="奖金总额",name="assignmentType")
    @Column(name = "assignment_type")
    private String assignmentType;


    //是否启用
    @ApiModelProperty(value="是否启用",name="disable")
    @Column(name = "disable")
    private Boolean disable;

    //是否注销
    @ApiModelProperty(value="是否注销",name="isEnable")
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

    public String getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(String startingTime) {
        this.startingTime = startingTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCalculateTheType() {
        return calculateTheType;
    }

    public void setCalculateTheType(String calculateTheType) {
        this.calculateTheType = calculateTheType;
    }

    public BigDecimal getTotalBonus() {
        return totalBonus;
    }

    public void setTotalBonus(BigDecimal totalBonus) {
        this.totalBonus = totalBonus;
    }

    public String getLowLimit() {
        return lowLimit;
    }

    public void setLowLimit(String lowLimit) {
        this.lowLimit = lowLimit;
    }

    public String getHighLimit() {
        return highLimit;
    }

    public void setHighLimit(String highLimit) {
        this.highLimit = highLimit;
    }

    public String getAssignmentType() {
        return assignmentType;
    }

    public void setAssignmentType(String assignmentType) {
        this.assignmentType = assignmentType;
    }

    public Boolean getDisable() {
        return disable;
    }

    public void setDisable(Boolean disable) {
        this.disable = disable;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }
}
