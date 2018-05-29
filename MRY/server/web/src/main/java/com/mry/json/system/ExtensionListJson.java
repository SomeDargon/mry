package com.mry.json.system;

import com.mry.entity.store.card.ExtensionCardManagement;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaik on 2018/1/4.
 */
public class ExtensionListJson {


    private Long id;
    //注册店
    @ApiModelProperty(value="注册店",name="storeName")
    private String storeName;

    //注册店Id
    @ApiModelProperty(value="注册店Id",name="storeId")
    private Long storeId;

    //拓客卡名称
    @ApiModelProperty(value="拓客卡名称",name="extensionName")
    private String extensionName;

    //现金金额
    @ApiModelProperty(value="现金金额",name="cashPrice")
    private String cashPrice;

    //卡扣金额
    @ApiModelProperty(value="卡扣金额",name="bucklePrice")
    private String bucklePrice;


    //拓客卡有效期(月)
    @ApiModelProperty(value="拓客卡有效期(月)",name="extensionValidity")
    private Integer extensionValidity;

    //业绩
    @ApiModelProperty(value="业绩",name="performance")
    private String performance;

    //实操
    @ApiModelProperty(value="实操",name="actualOperation")
    private String actualOperation;

    //手工费
    @ApiModelProperty(value="手工费",name="manualFee")
    private String manualFee;

    //会员尊享
    @ApiModelProperty(value="会员尊享",name="project")
    private List<ExtensionProjectListJson> project;

    //每周销售M张
    @ApiModelProperty(value="每周销售M张",name="quantity")
    private Integer quantity;

    //每周销售M张
    @ApiModelProperty(value="达到奖励",name="reward")
    private String reward;

    //超过奖励
    @ApiModelProperty(value="超过奖励",name="exceedReward")
    private String exceedReward;

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

    public String getExtensionName() {
        return extensionName;
    }

    public void setExtensionName(String extensionName) {
        this.extensionName = extensionName;
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

    public Integer getExtensionValidity() {
        return extensionValidity;
    }

    public void setExtensionValidity(Integer extensionValidity) {
        this.extensionValidity = extensionValidity;
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    public String getActualOperation() {
        return actualOperation;
    }

    public void setActualOperation(String actualOperation) {
        this.actualOperation = actualOperation;
    }

    public String getManualFee() {
        return manualFee;
    }

    public void setManualFee(String manualFee) {
        this.manualFee = manualFee;
    }

    public List<ExtensionProjectListJson> getProject() {
        return project;
    }

    public void setProject(List<ExtensionProjectListJson> project) {
        this.project = project;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public String getExceedReward() {
        return exceedReward;
    }

    public void setExceedReward(String exceedReward) {
        this.exceedReward = exceedReward;
    }

    public ExtensionListJson(ExtensionCardManagement data) {
        this.id = data.getId();
        this.storeName = data.getStoreName();
        this.storeId = data.getStoreId();
        this.extensionName = data.getExtensionName();
        this.extensionValidity = data.getExtensionValidity();
        this.quantity = data.getQuantity();
        if(data.getCashPrice() != null) {
            this.cashPrice = data.getCashPrice().toString();
        }

        if(data.getBucklePrice() != null) {
            this.bucklePrice = data.getBucklePrice().toString();
        }
        if(data.getPerformance() != null) {
            this.performance = data.getPerformance().toEngineeringString();
        }
        if(data.getActualOperation() != null) {
            this.actualOperation = data.getActualOperation().toString();
        }
        if(data.getManualFee() != null) {
            this.manualFee = data.getManualFee().toString();
        }
        if(data.getReward() != null) {
            this.reward = data.getReward().toString();
        }

        if(data.getExceedReward() != null) {
            this.exceedReward = data.getExceedReward().toString();
        }
       if(data.getProject() != null){
           this.project= new ArrayList<>();
           data.getProject().forEach(a ->this.project.add(new ExtensionProjectListJson(a)));
       }

    }
}
