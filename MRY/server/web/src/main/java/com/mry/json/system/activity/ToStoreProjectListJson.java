package com.mry.json.system.activity;

import com.mry.entity.store.card.ToStoreProject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by kaik on 2018/1/12.
 */
@Api(description="到店赠送", value = "到店赠送")
public class ToStoreProjectListJson {

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


    public ToStoreProjectListJson(ToStoreProject a) {
        this.id = a.getId();
        this.activityNumber = a.getActivityNumber();
        if(a.getProject() !=null) {
            this.projectId = a.getProject().getId();
//            this.projectName = a.getProject().getProjectName();
        }
    }
}
