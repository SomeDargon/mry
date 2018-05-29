package com.mry.entity.store.salary;

import com.mry.entity.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by kaik on 2018/1/19.
 * 事假罚金
 */
@ApiModel(value="事假罚金",description="事假罚金")
@Entity
@Table(name = LeaveAfine.TABLE_NAME)
public class LeaveAfine extends BaseEntity {

    public static final String TABLE_NAME = "Leave_afine";

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

    //事假天数
    @ApiModelProperty(value="事假天数",name="personalLeave")
    @Column(name = "personal_leave")
    private Integer personalLeave;


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

    public Integer getPersonalLeave() {
        return personalLeave;
    }

    public void setPersonalLeave(Integer personalLeave) {
        this.personalLeave = personalLeave;
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
