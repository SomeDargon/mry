package com.mry.entity.store.salary;

import com.mry.entity.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by admin on 2018/1/19.
 * 迟到早退罚金
 */
@ApiModel(value="迟到早退罚金",description="迟到早退罚金")
@Entity
@Table(name = LeaveEarlyFines.TABLE_NAME)
public class LeaveEarlyFines extends BaseEntity {

    public static final String TABLE_NAME = "leave_early_fines";

    //注册店
    @ApiModelProperty(value="注册店",name="storeName")
    @Column(name = "store_Name")
    private String storeName;

    //注册店Id
    @ApiModelProperty(value="注册店Id",name="storeId")
    @Column(name = "store_id")
    private Long storeId;

    //罚金总额
    @ApiModelProperty(value="罚金总额",name="totalBonus")
    @Column(name = "total_bonus")
    private BigDecimal totalBonus;

    //迟到早退时间
    @ApiModelProperty(value="迟到早退时间",name="LeaveEarlyTime")
    @Column(name = "leave_early_time")
    private Integer LeaveEarlyTime;


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

    public BigDecimal getTotalBonus() {
        return totalBonus;
    }

    public void setTotalBonus(BigDecimal totalBonus) {
        this.totalBonus = totalBonus;
    }

    public Integer getLeaveEarlyTime() {
        return LeaveEarlyTime;
    }

    public void setLeaveEarlyTime(Integer leaveEarlyTime) {
        LeaveEarlyTime = leaveEarlyTime;
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
