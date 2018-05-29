package com.mry.entity.store.card;

import com.mry.entity.common.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by kaik on 2018/1/3.
 * 拓客卡管理
 */
@Entity
@Table(name = ExtensionCardManagement.TABLE_NAME)
public class ExtensionCardManagement extends BaseEntity {

    public static final String TABLE_NAME = "extension_card_management";

    //注册店
    @Column(name = "store_Name")
    private String storeName;

    //注册店Id
    @Column(name = "store_id")
    private Long storeId;

    //拓客卡名称
    @Column(name = "extension_Name")
    private String extensionName;

    //现金金额
    @Column(name = "cash_price")
    private BigDecimal cashPrice;

    //卡扣金额
    @Column(name = "bckle_price")
    private BigDecimal bucklePrice;

    //拓客卡有效期(月)
    @Column(name = "extension_validity")
    private Integer extensionValidity;

    //业绩
    @Column(name = "performance")
    private BigDecimal performance;

    //实操
    @Column(name = "actual_operation")
    private BigDecimal actualOperation;

    //手工费
    @Column(name = "manual_fee")
    private BigDecimal manualFee;

    //会员尊享
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "card", fetch = FetchType.LAZY)
    private List<ExtensionCardProject> project;

    //每周销售M张
    @Column(name = "quantity")
    private Integer quantity;

    //达到奖励
    @Column(name = "reward")
    private BigDecimal reward;

    //超过奖励
    @Column(name = "exceed_reward")
    private BigDecimal exceedReward;

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

    public String getExtensionName() {
        return extensionName;
    }

    public void setExtensionName(String extensionName) {
        this.extensionName = extensionName;
    }

    public BigDecimal getCashPrice() {
        return cashPrice;
    }

    public void setCashPrice(BigDecimal cashPrice) {
        this.cashPrice = cashPrice;
    }

    public BigDecimal getBucklePrice() {
        return bucklePrice;
    }

    public void setBucklePrice(BigDecimal bucklePrice) {
        this.bucklePrice = bucklePrice;
    }

    public Integer getExtensionValidity() {
        return extensionValidity;
    }

    public void setExtensionValidity(Integer extensionValidity) {
        this.extensionValidity = extensionValidity;
    }

    public BigDecimal getPerformance() {
        return performance;
    }

    public void setPerformance(BigDecimal performance) {
        this.performance = performance;
    }

    public BigDecimal getActualOperation() {
        return actualOperation;
    }

    public void setActualOperation(BigDecimal actualOperation) {
        this.actualOperation = actualOperation;
    }

    public BigDecimal getManualFee() {
        return manualFee;
    }

    public void setManualFee(BigDecimal manualFee) {
        this.manualFee = manualFee;
    }

    public List<ExtensionCardProject> getProject() {
        return project;
    }

    public void setProject(List<ExtensionCardProject> project) {
        this.project = project;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getReward() {
        return reward;
    }

    public void setReward(BigDecimal reward) {
        this.reward = reward;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }

    public BigDecimal getExceedReward() {
        return exceedReward;
    }

    public void setExceedReward(BigDecimal exceedReward) {
        this.exceedReward = exceedReward;
    }
}
