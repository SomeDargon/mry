package com.mry.entity.store.customer;

import com.mry.entity.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by kaik on 2018/2/12.
 */
@Entity
@Table(name = Solution.TABLE_NAME)
public class Solution extends BaseEntity {

    public static final String TABLE_NAME = "solution";


    //注册店
    @Column(name = "store_Name")
    private String storeName;

    //注册店Id
    @Column(name = "store_id")
    private Long storeId;


    //注册店
    @Column(name = "problem_Name")
    private String problemName;

    //注册店Id
    @Column(name = "problem_id")
    private Long problemId;



    //方案名称
    @Column(name = "scheme_name")
    private String schemeName;

    //最优方案
    @Column(name = "optimal_scheme")
    private String optimalScheme;


    //最优方案
    @Column(name = "optimal_scheme_ids")
    private String optimalSchemeIds;

    //基础方案
    @Column(name = "basic_programme")
    private String basicProgramme;

    //基础方案
    @Column(name = "basic_programme_ids")
    private String basicProgrammeIds;

    //症状类型
    @Column(name = "symptom_type")
    private String symptomType;

    //处理细节
    @Column(name = "handling_details")
    private String handlingDetails;


    //是否启用
    @Column(name = "is_enable")
    private Boolean isEnable;

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

    public String getProblemName() {
        return problemName;
    }

    public void setProblemName(String problemName) {
        this.problemName = problemName;
    }

    public Long getProblemId() {
        return problemId;
    }

    public void setProblemId(Long problemId) {
        this.problemId = problemId;
    }

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public String getOptimalScheme() {
        return optimalScheme;
    }

    public void setOptimalScheme(String optimalScheme) {
        this.optimalScheme = optimalScheme;
    }

    public String getOptimalSchemeIds() {
        return optimalSchemeIds;
    }

    public void setOptimalSchemeIds(String optimalSchemeIds) {
        this.optimalSchemeIds = optimalSchemeIds;
    }

    public String getBasicProgramme() {
        return basicProgramme;
    }

    public void setBasicProgramme(String basicProgramme) {
        this.basicProgramme = basicProgramme;
    }

    public String getBasicProgrammeIds() {
        return basicProgrammeIds;
    }

    public void setBasicProgrammeIds(String basicProgrammeIds) {
        this.basicProgrammeIds = basicProgrammeIds;
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

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }
}
