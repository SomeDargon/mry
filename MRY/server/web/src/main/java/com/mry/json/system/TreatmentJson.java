package com.mry.json.system;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by kaik on 2018/1/7.
 */
@Api(description="疗程组合卡管理", value = "疗程组合卡管理")
public class TreatmentJson {


    private Long id;

    //注册店
    @ApiModelProperty(value="注册店",name="storeName")
    private String storeName;

    //注册店Id
    @ApiModelProperty(value="注册店Id",name="storeId")
    private Long storeId;

    //组合卡名称
    @ApiModelProperty(value="组合卡名称",name="treatmentName")
    private String treatmentName;

    //现金金额
    @ApiModelProperty(value="现金金额",name="cashPrice")
    private String cashPrice;

    //卡扣金额
    @ApiModelProperty(value="卡扣金额",name="bucklePrice")
    private String bucklePrice;

    // 次数
    @ApiModelProperty(value="次数",name="treatmentNumber")
    private Integer treatmentNumber ;

    //组合卡有效期(月)
    @ApiModelProperty(value="组合卡有效期(月)",name="treatmentCardValidity")
    private Integer treatmentCardValidity;

    //是否显示
    @ApiModelProperty(value="是否显示",name="isDisplay")
    private Boolean isDisplay;


    //会员项目
    @ApiModelProperty(value="会员项目",name="project")
    private List<ExtensionProjectJson> project;

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

    public String getTreatmentName() {
        return treatmentName;
    }

    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }

    public String getCashPrice() {
        return cashPrice;
    }

    public void setCashPrice(String cashPrice) {
        this.cashPrice = cashPrice;
    }

    public String getBucklePrice() {
        return bucklePrice;
    }

    public void setBucklePrice(String bucklePrice) {
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

    public List<ExtensionProjectJson> getProject() {
        return project;
    }

    public void setProject(List<ExtensionProjectJson> project) {
        this.project = project;
    }

    public Integer getTreatmentNumber() {
        return treatmentNumber;
    }

    public void setTreatmentNumber(Integer treatmentNumber) {
        this.treatmentNumber = treatmentNumber;
    }
}
