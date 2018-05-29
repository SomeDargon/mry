package com.mry.entity.store.customer;

import com.mry.entity.common.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by kaik on 2017/10/19.
 * 问题对应的解决办法
 */
@Entity
@Table(name = CorrespondencePlan.TABLE_NAME)
public class CorrespondencePlan extends BaseEntity {

    public static final String TABLE_NAME = "correspondence_plan";


    //问题
    @Column(name = "problem_id")
    private Long problemId;


    //项目名称
    @Column(name = "basic_program")
    private String basicProgram;

    //项目id
    @Column(name = "basic_program_id")
    private Long basicProgramId;

    //办法类型
    @Column(name = "program_type")
    private String programType;

//
//    //推荐方案
//    @Column(name = "recommended_program")
//    private String recommendedProgram;
//
//    //推荐方案
//    @Column(name = "recommended_program_id")
//    private Long[] recommendedProgramId;
//
//    //最优方案
//    @Column(name = "best_plan")
//    private String bestPlan;
//
//    //最优方案
//    @Column(name = "best_plan_id")
//    private Long[] bestPlanId;

    //备注
    @Column(name = "remarks")
    private String remarks;

    //是否启用
    @Column(name = "is_enable")
    private Boolean isEnable;

    public Long getProblemId() {
        return problemId;
    }

    public void setProblemId(Long problemId) {
        this.problemId = problemId;
    }

    public String getBasicProgram() {
        return basicProgram;
    }

    public void setBasicProgram(String basicProgram) {
        this.basicProgram = basicProgram;
    }

//    public String getRecommendedProgram() {
//        return recommendedProgram;
//    }
//
//    public void setRecommendedProgram(String recommendedProgram) {
//        this.recommendedProgram = recommendedProgram;
//    }
//
//    public String getBestPlan() {
//        return bestPlan;
//    }
//
//    public void setBestPlan(String bestPlan) {
//        this.bestPlan = bestPlan;
//    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Long getBasicProgramId() {
        return basicProgramId;
    }

    public void setBasicProgramId(Long basicProgramId) {
        this.basicProgramId = basicProgramId;
    }

    public String getProgramType() {
        return programType;
    }

    public void setProgramType(String programType) {
        this.programType = programType;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }

    //
//    public Long[] getRecommendedProgramId() {
//        return recommendedProgramId;
//    }
//
//    public void setRecommendedProgramId(Long[] recommendedProgramId) {
//        this.recommendedProgramId = recommendedProgramId;
//    }
//
//    public Long[] getBestPlanId() {
//        return bestPlanId;
//    }
//
//    public void setBestPlanId(Long[] bestPlanId) {
//        this.bestPlanId = bestPlanId;
//    }
}
