package com.mry.json.system.activity;

import com.mry.entity.store.card.ProductSecondKill;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by kaik on 2018/1/12.
 */
@Api(description="产品秒杀", value = "产品秒杀")
public class ProductSecondKillListJson {

    private Long id;

    // 现金秒杀价格
    @ApiModelProperty(value="现金秒杀价格",name="cashSecondPrice")
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


    public ProductSecondKillListJson(ProductSecondKill a) {
        this.id = a.getId();
        if(a.getCashSecondPrice() != null) {
            this.cashSecondPrice = a.getCashSecondPrice().toString();
        }
        if(a.getBuckleTheSecondPrice()!= null) {
            this.buckleTheSecondPrice = a.getBuckleTheSecondPrice().toString();
        }
        if(a.getProduct() !=null) {
            this.projectId = a.getProduct().getId();
            this.projectName = a.getProduct().getProductName();
        }
    }
}
