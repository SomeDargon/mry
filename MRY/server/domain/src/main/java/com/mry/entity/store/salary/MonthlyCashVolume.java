package com.mry.entity.store.salary;

import com.mry.entity.common.BaseEntity;
import com.mry.entity.store.card.ActivityCardManagement;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by kaik on 2018/1/15.
 * 月现金总量
 */
@ApiModel(value="月现金总量",description="月现金总量")
@Entity
@Table(name = MonthlyCashVolume.TABLE_NAME)
public class MonthlyCashVolume extends BaseEntity {

    public static final String TABLE_NAME = "monthly_cash_volume";

//    @ManyToOne(fetch= FetchType.LAZY)
//    @JoinColumn(name = "salarySystem_id")
//    private SalarySystem salarySystem;

    //注册店
    @ApiModelProperty(value="注册店",name="storeName")
    @Column(name = "store_Name")
    private String storeName;

    //注册店Id
    @ApiModelProperty(value="注册店Id",name="storeId")
    @Column(name = "store_id")
    private Long storeId;

//    //类型
//    @ApiModelProperty(value="类型",name="monthlyCashType")
//    @Column(name = "monthly_cash_type")
//    private String monthlyCashType;

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

//    public String getMonthlyCashType() {
//        return monthlyCashType;
//    }
//
//    public void setMonthlyCashType(String monthlyCashType) {
//        this.monthlyCashType = monthlyCashType;
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

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }

    public Boolean getDisable() {
        return disable;
    }

    public void setDisable(Boolean disable) {
        this.disable = disable;
    }
}
