package com.mry.json.system;

import com.mry.entity.store.card.ExtensionCardProject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by kaik on 2018/1/4.
 */
@Api(description="会员尊享", value = "会员尊享")
public class ExtensionProjectListJson {

    private Long id;
    // 拓客卡有效期
    @ApiModelProperty(value="拓客卡有效期",name="extensionValidity")
    private Integer extensionValidity;

    // 次数
    @ApiModelProperty(value="次数",name="extensionNumber")
    private Integer extensionNumber ;

    //项目
    @ApiModelProperty(value="项目",name="projectId")
    private Long projectId;

    // 拓客卡有效期
    @ApiModelProperty(value="拓客卡有效期",name="projectName")
    private String projectName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getExtensionValidity() {
        return extensionValidity;
    }

    public void setExtensionValidity(Integer extensionValidity) {
        this.extensionValidity = extensionValidity;
    }

    public Integer getExtensionNumber() {
        return extensionNumber;
    }

    public void setExtensionNumber(Integer extensionNumber) {
        this.extensionNumber = extensionNumber;
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

    public ExtensionProjectListJson(ExtensionCardProject data) {
        this.id = data.getId();
        this.extensionValidity = data.getExtensionValidity();
        this.extensionNumber = data.getExtensionNumber();
        if(data.getProject() != null) {
            this.projectId = data.getProject().getId();
            this.projectName = data.getProject().getProjectName();
        }
    }
}
