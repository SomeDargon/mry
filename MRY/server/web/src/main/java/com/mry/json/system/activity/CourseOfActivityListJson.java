package com.mry.json.system.activity;

import com.mry.entity.store.card.CourseOfActivityCard;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by admin on 2018/1/12.
 * 活动卡疗程
 */
@Api(description="活动卡疗程", value = "活动卡疗程")
public class CourseOfActivityListJson {

    private Long id;

    @ApiModelProperty(value="疗程组合卡",name="treatmentName")
    private String treatmentName;

    @ApiModelProperty(value="疗程组合卡ID",name="treatmentId")
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



    public CourseOfActivityListJson(CourseOfActivityCard a) {
        this.id = a.getId();
        if(a.getTreatment() != null) {
            this.treatmentName = a.getTreatment().getTreatmentName();
            this.treatmentId = a.getTreatment().getId();
        }
    }
}
