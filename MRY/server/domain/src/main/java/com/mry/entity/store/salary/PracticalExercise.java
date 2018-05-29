package com.mry.entity.store.salary;

import com.mry.entity.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * Created by kaik on 2018/1/17.
 * 实操提成
 */
@ApiModel(value="实操提成",description="实操提成")
@Entity
@Table(name = PracticalExercise.TABLE_NAME)
public class PracticalExercise extends BaseEntity {

    public static final String TABLE_NAME = "practical_exercise";
//
//    @ManyToOne(fetch= FetchType.LAZY)
//    @JoinColumn(name = "salarySystem_id")
//    private SalarySystem salarySystem;

    //注册店
    @ApiModelProperty(value="注册店",name="storeName")
    @Column(name = "store_Name")
    private String storeName;

    //注册店Id
    @ApiModelProperty(value="注册店Id",name="storeId")
    @Column(name = "store_id")
    private Long storeId;

    //低限
    @ApiModelProperty(value="低限",name="lowLimit")
    @Column(name = "low_limit")
    private String lowLimit;

    //高限
    @ApiModelProperty(value="高限",name="highLimit")
    @Column(name = "high_limit")
    private String highLimit;

    //面部实操指定
    @ApiModelProperty(value="面部实操指定",name="facialPracticeAppoint")
    @Column(name = "facial_practice_appoint")
    private String facialPracticeAppoint;

    //面部实操非指定
    @ApiModelProperty(value="面部实操非指定",name="facialPracticeNonSpecifiedt")
    @Column(name = "facial_practice_non_specified")
    private String facialPracticeNonSpecifiedt;

    //身体实操指定
    @ApiModelProperty(value="身体实操指定",name="physicalExerciseAppoint")
    @Column(name = "physical_exercise_appoint")
    private String physicalExerciseAppoint;

    //身体实操非指定
    @ApiModelProperty(value="身体实操非指定",name="physicalExerciseNonSpecifiedt")
    @Column(name = "physical_exercise_non_specified")
    private String physicalExerciseNonSpecifiedt;

    //是否启用
    @ApiModelProperty(value="是否启用",name="disable")
    @Column(name = "disable")
    private Boolean disable;

    //是否注销
    @ApiModelProperty(value="是否注销",name="isEnable")
    @Column(name = "is_enable")
    private Boolean isEnable;

//    public SalarySystem getSalarySystem() {
//        return salarySystem;
//    }
//
//    public void setSalarySystem(SalarySystem salarySystem) {
//        this.salarySystem = salarySystem;
//    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getLowLimit() {
        return lowLimit;
    }

    public void setLowLimit(String lowLimit) {
        this.lowLimit = lowLimit;
    }

    public String getHighLimit() {
        return highLimit;
    }

    public void setHighLimit(String highLimit) {
        this.highLimit = highLimit;
    }

    public String getFacialPracticeAppoint() {
        return facialPracticeAppoint;
    }

    public void setFacialPracticeAppoint(String facialPracticeAppoint) {
        this.facialPracticeAppoint = facialPracticeAppoint;
    }

    public String getFacialPracticeNonSpecifiedt() {
        return facialPracticeNonSpecifiedt;
    }

    public void setFacialPracticeNonSpecifiedt(String facialPracticeNonSpecifiedt) {
        this.facialPracticeNonSpecifiedt = facialPracticeNonSpecifiedt;
    }

    public String getPhysicalExerciseAppoint() {
        return physicalExerciseAppoint;
    }

    public void setPhysicalExerciseAppoint(String physicalExerciseAppoint) {
        this.physicalExerciseAppoint = physicalExerciseAppoint;
    }

    public String getPhysicalExerciseNonSpecifiedt() {
        return physicalExerciseNonSpecifiedt;
    }

    public void setPhysicalExerciseNonSpecifiedt(String physicalExerciseNonSpecifiedt) {
        this.physicalExerciseNonSpecifiedt = physicalExerciseNonSpecifiedt;
    }

    public Boolean getDisable() {
        return disable;
    }

    public void setDisable(Boolean disable) {
        this.disable = disable;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }
}
