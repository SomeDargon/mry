package com.mry.json.system;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by kaik on 2018/1/3.
 */
@Api(description="会员尊享", value = "会员尊享")
public class MembersEnjoyJson {


    private Long id;

    // 尊享有效期
    @ApiModelProperty(value=" 尊享有效期",name="enjoyValidity")
    private String enjoyValidity;

    // 尊享次数
    @ApiModelProperty(value="尊享次数",name="enjoyNumber")
    private Integer enjoyNumber ;

    //尊享项目
    @ApiModelProperty(value="尊享项目",name="projectName")
    private String projectName;

    //尊享项目
    @ApiModelProperty(value="尊享项目",name="projectId")
    private Long projectId;

    // 时效类型
    @ApiModelProperty(value="时效类型",name="agingType")
    private String agingType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnjoyValidity() {
        return enjoyValidity;
    }

    public void setEnjoyValidity(String enjoyValidity) {
        this.enjoyValidity = enjoyValidity;
    }

    public Integer getEnjoyNumber() {
        return enjoyNumber;
    }

    public void setEnjoyNumber(Integer enjoyNumber) {
        this.enjoyNumber = enjoyNumber;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getAgingType() {
        return agingType;
    }

    public void setAgingType(String agingType) {
        this.agingType = agingType;
    }


}
