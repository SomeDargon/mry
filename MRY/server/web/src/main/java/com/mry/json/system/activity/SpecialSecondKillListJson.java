package com.mry.json.system.activity;

import com.mry.entity.store.card.SpecialSecondKill;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by kaik on 2018/1/12.
 *     特价秒杀
 */
public class SpecialSecondKillListJson {

    private Long id;

    //特价金额
    @ApiModelProperty(value="特价金额",name="specialMoney")
    private String specialMoney;


    // 套数次数
    @ApiModelProperty(value="套数次数",name="specialNumber")
    private Integer specialNumber ;

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

    public String getSpecialMoney() {
        return specialMoney;
    }

    public void setSpecialMoney(String specialMoney) {
        this.specialMoney = specialMoney;
    }

    public Integer getSpecialNumber() {
        return specialNumber;
    }

    public void setSpecialNumber(Integer specialNumber) {
        this.specialNumber = specialNumber;
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


    public SpecialSecondKillListJson(SpecialSecondKill a) {
        this.id = a.getId();
        if(a.getSpecialMoney() != null) {
            this.specialMoney = a.getSpecialMoney().toString();
        }
        this.specialNumber = a.getSpecialNumber();
        if(a.getProject() != null) {
            this.projectId = a.getProject().getId();
            this.projectName = a.getProject().getProjectName();
        }
    }
}
