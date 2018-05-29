package com.mry.json.store;

import com.mry.entity.store.customer.MyProduct;
import com.mry.entity.store.customer.MyProject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by kaik on 2017/12/4.
 */
@ApiModel(value = "项目")
public class MyProjectJson {


    private Long id;

    @ApiModelProperty(value = "客户id")
    private Long customerId;

    @ApiModelProperty(value = "客户名字")
    private String customer;

    @ApiModelProperty(value = "卡项目id")
    private Long projectId;
    @ApiModelProperty(value = "卡项目名")
    private String projectName;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @ApiModelProperty(value = "卡id")
    private Long cardId;

    @ApiModelProperty(value = "剩余次数")
    private Integer remaining;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public Integer getRemaining() {
        return remaining;
    }

    public void setRemaining(Integer remaining) {
        this.remaining = remaining;
    }

    public MyProjectJson(MyProject data) {
        this.id = data.getId();
        this.customerId = data.getCustomerId();
        this.customer = data.getCustomer();
        this.projectId = data.getProjectId();
        this.cardId = data.getId();
        this.remaining = data.getRemaining();
        this.projectName = data.getProject();
    }


}
