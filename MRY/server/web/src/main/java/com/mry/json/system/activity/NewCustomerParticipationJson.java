package com.mry.json.system.activity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by kaik on 2018/1/30.
 */
@Api(description="老客户带新客户参加活动", value = "老客户带新客户参加活动")
public class NewCustomerParticipationJson {

    private Long id;

    // 尊享有效期
    @ApiModelProperty(value=" 尊享有效期",name="activityValidity")
    private Integer activityValidity;

    // 次数
    @ApiModelProperty(value="次数",name="activityNumber")
    private Integer activityNumber ;

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

    public Integer getActivityValidity() {
        return activityValidity;
    }

    public void setActivityValidity(Integer activityValidity) {
        this.activityValidity = activityValidity;
    }

    public Integer getActivityNumber() {
        return activityNumber;
    }

    public void setActivityNumber(Integer activityNumber) {
        this.activityNumber = activityNumber;
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
