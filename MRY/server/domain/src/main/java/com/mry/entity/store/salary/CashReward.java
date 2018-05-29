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
 * 现金业绩奖励
 */
@ApiModel(value="现金业绩奖励",description="现金业绩奖励")
@Entity
@Table(name = CashReward.TABLE_NAME)
public class CashReward extends BaseEntity {

    public static final String TABLE_NAME = "cash_reward";

    //注册店
    @ApiModelProperty(value="注册店",name="storeName")
    @Column(name = "store_Name")
    private String storeName;

    //注册店Id
    @ApiModelProperty(value="注册店Id",name="storeId")
    @Column(name = "store_id")
    private Long storeId;

//    //类型
//    @ApiModelProperty(value="类型",name="cashType")
//    @Column(name = "cash_type")
//    private String cashType;

    //低限
    @ApiModelProperty(value="低限",name="lowLimit")
    @Column(name = "low_limit")
    private String lowLimit;

    //高限
    @ApiModelProperty(value="高限",name="highLimit")
    @Column(name = "high_limit")
    private String highLimit;

    //奖励金额
    @ApiModelProperty(value="奖励金额",name="amountOfReward")
    @Column(name = "amount_of_reward")
    private BigDecimal amountOfReward;

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

//    public String getCashType() {
//        return cashType;
//    }
//
//    public void setCashType(String cashType) {
//        this.cashType = cashType;
//    }

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

    public BigDecimal getAmountOfReward() {
        return amountOfReward;
    }

    public void setAmountOfReward(BigDecimal amountOfReward) {
        this.amountOfReward = amountOfReward;
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
