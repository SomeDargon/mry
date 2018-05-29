package com.mry.json.store;


import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by kaik on 2017/12/4.
 */
public class OwningCardJson {

    private Long id;

    //卡名
    @ApiModelProperty(value = "卡名")
    private String cardName;

    //卡名
    private Long cardId;

    private Long customerId;

    @ApiModelProperty(value = "开卡时间")
    private String openTime;

    @ApiModelProperty(value = "结束时间")
    private String endTime;

    @ApiModelProperty(value = "卡包含的项目")
    private List<MyProjectJson> project;

    @ApiModelProperty(value = "是否启用")
    private Boolean isEnable;

    @ApiModelProperty(value = "备注")
    private String bz;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public List<MyProjectJson> getProject() {
        return project;
    }

    public void setProject(List<MyProjectJson> project) {
        this.project = project;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }
}
