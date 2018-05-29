package com.mry.json.system.activity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by kaik on 2018/1/11.
 */
@Api(description="到店赠送", value = "到店赠送")
public class ToStoreProjectJson {

    private Long id;
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
