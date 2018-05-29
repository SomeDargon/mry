package com.mry.entity.store.card;

import com.mry.entity.common.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by kaik on 2018/1/7.
 * 疗程组合卡管理
 */
@Entity
@Table(name = TreatmentCardManagement.TABLE_NAME)
public class TreatmentCardManagement extends BaseEntity {

    public static final String TABLE_NAME = "treatment_card_management";


    //注册店
    @Column(name = "store_name")
    private String storeName;

    //注册店Id
    @Column(name = "store_id")
    private Long storeId;

    //组合卡名称
    @Column(name = "treatment_name")
    private String treatmentName;

    // 次数
    @Column(name = "treatment_number")
    private Integer treatmentNumber ;


    //现金金额
    @Column(name = "cash_price")
    private BigDecimal cashPrice;

    //卡扣金额
    @Column(name = "bckle_price")
    private BigDecimal bucklePrice;

    //组合卡有效期(月)
    @Column(name = "treatment_card_validity")
    private Integer treatmentCardValidity;

    //是否显示
    @Column(name = "is_display")
    private Boolean isDisplay;


    //会员项目
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "treatment", fetch = FetchType.LAZY)
    private List<ExtensionCardProject> project;


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

    public String getTreatmentName() {
        return treatmentName;
    }

    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
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

    public Integer getTreatmentCardValidity() {
        return treatmentCardValidity;
    }

    public void setTreatmentCardValidity(Integer treatmentCardValidity) {
        this.treatmentCardValidity = treatmentCardValidity;
    }

    public Boolean getDisplay() {
        return isDisplay;
    }

    public void setDisplay(Boolean display) {
        isDisplay = display;
    }

    public List<ExtensionCardProject> getProject() {
        return project;
    }

    public void setProject(List<ExtensionCardProject> project) {
        this.project = project;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }

    public Integer getTreatmentNumber() {
        return treatmentNumber;
    }

    public void setTreatmentNumber(Integer treatmentNumber) {
        this.treatmentNumber = treatmentNumber;
    }
}
