package com.mry.json.store;

import com.mry.entity.store.project.ProjectManagement;
import com.mry.entity.store.project.ProjectProduct;
import com.mry.entity.user.Customer;
import com.mry.util.DatetimeUtil;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by kaik on 2017/10/27.
 */
public class ProjectJson {

    private Long id;

    //注册店
    private String storeName;

    //注册店Id
    private Long storeId;

    //名字
    private String projectName;

    //现金金额
    private String cashMoney;
    //疗程金额
    private String courseMoney;
    //卡扣金额
    private String buckleMoney;
    //体验金额
    private String experienceMoney;

    //是否收填
    private String isCalculate;

    //编号
    private String code;

    //效果  解决症状问题（和顾客症状关联）
    private String effect;

    //项目专业说明（项目原理、专业）
    private String projectDescription;

    //项目操作技术要点（和员工管理技术管理关联）
    private String technicalPoints;

    //可搭配项目和搭配后解决问题（和疗程组合设计关联）
    private String collocationItems;

    //类型 项目类别（身体类、面护类）
    private String type;

    //项目属性（到店率、功效类、保养类）
    private String projectAttributes;

    //次数
    private String frequency;

    //间隔
    private String intervalTime;

    //操作人
    private String operator;
    // 操作人Id
    private Long operatorId;

    //  操作时间
    private String operatorTime;

    //  修改人

    private String updatePeople;

    //  修改人Id
    private Long updatePeopleId;

    //  操作时间
    private String modifierTime;



    public List<ProjectProductNewJson> product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getCashMoney() {
        return cashMoney;
    }

    public void setCashMoney(String cashMoney) {
        this.cashMoney = cashMoney;
    }

    public String getCourseMoney() {
        return courseMoney;
    }

    public void setCourseMoney(String courseMoney) {
        this.courseMoney = courseMoney;
    }

    public String getBuckleMoney() {
        return buckleMoney;
    }

    public void setBuckleMoney(String buckleMoney) {
        this.buckleMoney = buckleMoney;
    }

    public String getExperienceMoney() {
        return experienceMoney;
    }

    public void setExperienceMoney(String experienceMoney) {
        this.experienceMoney = experienceMoney;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }


    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperatorTime() {
        return operatorTime;
    }

    public void setOperatorTime(String operatorTime) {
        this.operatorTime = operatorTime;
    }

    public String getModifierTime() {
        return modifierTime;
    }

    public void setModifierTime(String modifierTime) {
        this.modifierTime = modifierTime;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public String getIntervalTime() {
        return intervalTime;
    }

    public void setIntervalTime(String intervalTime) {
        this.intervalTime = intervalTime;
    }

    public String getUpdatePeople() {
        return updatePeople;
    }

    public void setUpdatePeople(String updatePeople) {
        this.updatePeople = updatePeople;
    }

    public Long getUpdatePeopleId() {
        return updatePeopleId;
    }

    public void setUpdatePeopleId(Long updatePeopleId) {
        this.updatePeopleId = updatePeopleId;
    }

    public List<ProjectProductNewJson> getProduct() {
        return product;
    }

    public void setProduct(List<ProjectProductNewJson> product) {
        this.product = product;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getTechnicalPoints() {
        return technicalPoints;
    }

    public void setTechnicalPoints(String technicalPoints) {
        this.technicalPoints = technicalPoints;
    }

    public String getCollocationItems() {
        return collocationItems;
    }

    public void setCollocationItems(String collocationItems) {
        this.collocationItems = collocationItems;
    }

    public String getProjectAttributes() {
        return projectAttributes;
    }

    public void setProjectAttributes(String projectAttributes) {
        this.projectAttributes = projectAttributes;
    }

    public String getIsCalculate() {
        return isCalculate;
    }

    public void setIsCalculate(String isCalculate) {
        this.isCalculate = isCalculate;
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

    //    public ProjectJson(ProjectManagement data) {
//        this.id = data.getId();
//        this.projectName = data.getProjectName();
//        this.money = data.getMoney();
//        this.code = data.getCode();
//        this.effect = data.getEffect();
//        this.type = data.getType();
//        this.count = data.getCount();
//        this.interval = data.getInterval();
//        this.operator = data.getOperator();
//        this.operatorId = data.getOperatorId();
//        this.operatorTime = data.getOperatorTime();
//        this.modifier = data.getModifier();
//        this.modifierId = data.getModifierId();
//        this.modifierTime = data.getModifierTime();
//
//    }
}
