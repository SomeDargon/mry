package com.mry.json.system.activity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by kaik on 2018/1/11.
 */
@Api(description="产品秒杀", value = "产品秒杀")
public class ProductSecondKillJson {

    private Long id;
    // 现金秒杀价格
    @ApiModelProperty(value="产品秒杀",name="productSecondKill")
    private String cashSecondPrice ;

    // 卡扣秒杀价格
    @ApiModelProperty(value="卡扣秒杀价格",name="buckleTheSecondPrice")
    private String buckleTheSecondPrice ;

    //项目
    @ApiModelProperty(value="项目",name="projectId")
    private Long projectId;

    //项目
    @ApiModelProperty(value="项目",name="projectName")
    private String projectName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCashSecondPrice() {
        return cashSecondPrice;
    }

    public void setCashSecondPrice(String cashSecondPrice) {
        this.cashSecondPrice = cashSecondPrice;
    }

    public String getBuckleTheSecondPrice() {
        return buckleTheSecondPrice;
    }

    public void setBuckleTheSecondPrice(String buckleTheSecondPrice) {
        this.buckleTheSecondPrice = buckleTheSecondPrice;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
