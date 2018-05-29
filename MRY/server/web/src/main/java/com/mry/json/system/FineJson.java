package com.mry.json.system;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * Created by kaik on 2018/1/29.
 * 罚金
 */
@Api(description="罚金", value = "罚金")
public class FineJson {

    //薪资id
    private Long id;


    //投诉罚金
    @ApiModelProperty(value="投诉罚金",name="complaintFinesAmount")
    private BigDecimal complaintFinesAmount;

    //旷工罚金
    @ApiModelProperty(value="旷工罚金",name="absenteeismFineAmount")
    private BigDecimal absenteeismFineAmount;

    //事假罚金
    @ApiModelProperty(value="固定罚金金额",name="leaveThePenaltyRules")
    private BigDecimal leaveThePenaltyRules;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getLeaveThePenaltyRules() {
        return leaveThePenaltyRules;
    }

    public void setLeaveThePenaltyRules(BigDecimal leaveThePenaltyRules) {
        this.leaveThePenaltyRules = leaveThePenaltyRules;
    }

    public BigDecimal getComplaintFinesAmount() {
        return complaintFinesAmount;
    }

    public void setComplaintFinesAmount(BigDecimal complaintFinesAmount) {
        this.complaintFinesAmount = complaintFinesAmount;
    }

    public BigDecimal getAbsenteeismFineAmount() {
        return absenteeismFineAmount;
    }

    public void setAbsenteeismFineAmount(BigDecimal absenteeismFineAmount) {
        this.absenteeismFineAmount = absenteeismFineAmount;
    }
}
