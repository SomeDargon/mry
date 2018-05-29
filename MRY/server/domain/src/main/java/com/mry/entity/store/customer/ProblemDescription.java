package com.mry.entity.store.customer;

import com.mry.entity.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by kaik on 2017/10/19.
 * 问题描述
 */
@Entity
@Table(name = ProblemDescription.TABLE_NAME)
public class ProblemDescription extends BaseEntity {

    public static final String TABLE_NAME = "problem_description";


    //注册店
    @Column(name = "store_Name")
    private String storeName;

    //注册店Id
    @Column(name = "store_id")
    private Long storeId;


    //问题
    @Column(name = "problem")
    private String problem;

    //排序
    @Column(name = "oder")
    private String oder;

//    //方案名称
//    @Column(name = "scheme_name")
//    private String schemeName;
//
//    //最优方案
//    @Column(name = "optimal_scheme")
//    private String optimalScheme;
//
//
//    //最优方案
//    @Column(name = "optimal_scheme_ids")
//    private String optimalSchemeIds;
//
//    //基础方案
//    @Column(name = "basic_programme")
//    private String basicProgramme;
//
//    //基础方案
//    @Column(name = "basic_programme_ids")
//    private String basicProgrammeIds;

    //症状类型
    @Column(name = "symptom_type")
    private String symptomType;

    //处理细节
    @Column(name = "handling_details")
    private String handlingDetails;

    //是否启用
    @Column(name = "is_enable")
    private Boolean isEnable;

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getOder() {
        return oder;
    }

    public void setOder(String oder) {
        this.oder = oder;
    }

    public Boolean getEnable() {
        return isEnable;
    }

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

    public String getSymptomType() {
        return symptomType;
    }

    public void setSymptomType(String symptomType) {
        this.symptomType = symptomType;
    }

    public String getHandlingDetails() {
        return handlingDetails;
    }

    public void setHandlingDetails(String handlingDetails) {
        this.handlingDetails = handlingDetails;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }
}
