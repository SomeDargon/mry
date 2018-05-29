package com.mry.json.system.activity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by kaik on 2018/1/11.
 */
@Api(description="活动卡疗程", value = "活动卡疗程")
public class CourseOfActivityCardJson {

    private Long id;

    @ApiModelProperty(value="活动卡疗程",name="treatmentName")
    private String treatmentName;
    @ApiModelProperty(value="活动卡疗程id",name="treatmentId")
    private Long treatmentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTreatmentName() {
        return treatmentName;
    }

    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }

    public Long getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(Long treatmentId) {
        this.treatmentId = treatmentId;
    }
}
