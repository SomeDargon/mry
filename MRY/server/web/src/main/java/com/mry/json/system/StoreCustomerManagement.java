package com.mry.json.system;

/**
 * Created by kaik on 2017/12/25.
 */
public class StoreCustomerManagement {

    //门店id
    private Long id;

    //排他性点单
    private Boolean exclusivePointList;

    // 某技师连续服务N次
    private Boolean continuousService;

    // 某技师连续服务N次
    private Integer serviceTimes;

    // 有联系的顾客介绍
    private Boolean customerIntroduction;

    //技师直接拓客
    private Boolean technician;


    //顾客投诉
    private Boolean customerComplaint;

    //其他技师建立联系
    private Boolean establishContact;

    //其他技师建立联系
    private Integer establishContactN;

    //顾客联系N个月不到店
    private Boolean noStore;

    // 管理周期
    private String managementCycle;


    //顾客联系N个月不到店
    private String noStoreN;

    // 顾客连续N月无现金
    private Boolean cashPoor;

    // 顾客连续N月无现金
    private String cashPoorN;

    //  A类
    private Boolean classA;

//    //  B类
//    private Boolean classB;
//
//    //  C类
//    private Boolean classC;

    // 大客户
    private Boolean bigCustomer;

    // 大客户（消费达N元）
    private String bigCustomerN;

    // 普通客户（
    private Boolean ordinaryCustomer;

    // 普通客户（消费不足N元） 睡眠客户
    private String ordinaryCustomerN;


    //顾客分类
    private Boolean customerClassification;

    // 睡眠客户
    private Boolean sleepCustomer;

    // 睡眠客户
    private String sleepCustomerN;

    // 常到店客户
    private Boolean regularCustomers;

    // 常到店客户
    private String regularCustomersN;

    // 冻结客户
    private Boolean frozenCustomers;

    // 冻结客户
    private String frozenCustomersN;

    // 客户分析
    private Boolean customerAnalysis;

    //血型
    private Boolean bloodType;

    //星座
    private Boolean constellation;

    //收入方式
    private Boolean incomeMode;

    //年收入
    private Boolean annualIncome;

    // 到美容院的目的
    private Boolean objective;

    //  面部
    private Boolean face;

    //身体
    private Boolean body;

    //内因   外因
    private Boolean internalCause;

    // 外因
    private Boolean externalcause;

    //  1）指定技师2）上次服务者3）服务最多者 前三项不能判断由4）店长顾问指定
    private String advisorDesignation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getExclusivePointList() {
        return exclusivePointList;
    }

    public void setExclusivePointList(Boolean exclusivePointList) {
        this.exclusivePointList = exclusivePointList;
    }

    public Boolean getContinuousService() {
        return continuousService;
    }

    public void setContinuousService(Boolean continuousService) {
        this.continuousService = continuousService;
    }

    public Integer getServiceTimes() {
        return serviceTimes;
    }

    public void setServiceTimes(Integer serviceTimes) {
        this.serviceTimes = serviceTimes;
    }

    public Boolean getCustomerIntroduction() {
        return customerIntroduction;
    }

    public void setCustomerIntroduction(Boolean customerIntroduction) {
        this.customerIntroduction = customerIntroduction;
    }

    public Boolean getTechnician() {
        return technician;
    }

    public void setTechnician(Boolean technician) {
        this.technician = technician;
    }

    public Boolean getCustomerComplaint() {
        return customerComplaint;
    }

    public void setCustomerComplaint(Boolean customerComplaint) {
        this.customerComplaint = customerComplaint;
    }

    public Boolean getEstablishContact() {
        return establishContact;
    }

    public void setEstablishContact(Boolean establishContact) {
        this.establishContact = establishContact;
    }

    public Boolean getNoStore() {
        return noStore;
    }

    public void setNoStore(Boolean noStore) {
        this.noStore = noStore;
    }

    public String getNoStoreN() {
        return noStoreN;
    }

    public void setNoStoreN(String noStoreN) {
        this.noStoreN = noStoreN;
    }

    public Boolean getCashPoor() {
        return cashPoor;
    }

    public void setCashPoor(Boolean cashPoor) {
        this.cashPoor = cashPoor;
    }

    public String getCashPoorN() {
        return cashPoorN;
    }

    public void setCashPoorN(String cashPoorN) {
        this.cashPoorN = cashPoorN;
    }

    public Boolean getClassA() {
        return classA;
    }

    public void setClassA(Boolean classA) {
        this.classA = classA;
    }

    public Boolean getBigCustomer() {
        return bigCustomer;
    }

    public void setBigCustomer(Boolean bigCustomer) {
        this.bigCustomer = bigCustomer;
    }

    public String getBigCustomerN() {
        return bigCustomerN;
    }

    public void setBigCustomerN(String bigCustomerN) {
        this.bigCustomerN = bigCustomerN;
    }

    public Boolean getOrdinaryCustomer() {
        return ordinaryCustomer;
    }

    public void setOrdinaryCustomer(Boolean ordinaryCustomer) {
        this.ordinaryCustomer = ordinaryCustomer;
    }

    public String getOrdinaryCustomerN() {
        return ordinaryCustomerN;
    }

    public void setOrdinaryCustomerN(String ordinaryCustomerN) {
        this.ordinaryCustomerN = ordinaryCustomerN;
    }

    public Boolean getCustomerClassification() {
        return customerClassification;
    }

    public void setCustomerClassification(Boolean customerClassification) {
        this.customerClassification = customerClassification;
    }

    public Boolean getSleepCustomer() {
        return sleepCustomer;
    }

    public void setSleepCustomer(Boolean sleepCustomer) {
        this.sleepCustomer = sleepCustomer;
    }

    public String getSleepCustomerN() {
        return sleepCustomerN;
    }

    public void setSleepCustomerN(String sleepCustomerN) {
        this.sleepCustomerN = sleepCustomerN;
    }

    public Boolean getRegularCustomers() {
        return regularCustomers;
    }

    public void setRegularCustomers(Boolean regularCustomers) {
        this.regularCustomers = regularCustomers;
    }

    public String getRegularCustomersN() {
        return regularCustomersN;
    }

    public void setRegularCustomersN(String regularCustomersN) {
        this.regularCustomersN = regularCustomersN;
    }

    public Boolean getFrozenCustomers() {
        return frozenCustomers;
    }

    public void setFrozenCustomers(Boolean frozenCustomers) {
        this.frozenCustomers = frozenCustomers;
    }

    public String getFrozenCustomersN() {
        return frozenCustomersN;
    }

    public void setFrozenCustomersN(String frozenCustomersN) {
        this.frozenCustomersN = frozenCustomersN;
    }

    public Boolean getCustomerAnalysis() {
        return customerAnalysis;
    }

    public void setCustomerAnalysis(Boolean customerAnalysis) {
        this.customerAnalysis = customerAnalysis;
    }

    public Boolean getBloodType() {
        return bloodType;
    }

    public void setBloodType(Boolean bloodType) {
        this.bloodType = bloodType;
    }

    public Boolean getConstellation() {
        return constellation;
    }

    public void setConstellation(Boolean constellation) {
        this.constellation = constellation;
    }

    public Boolean getIncomeMode() {
        return incomeMode;
    }

    public void setIncomeMode(Boolean incomeMode) {
        this.incomeMode = incomeMode;
    }

    public Boolean getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(Boolean annualIncome) {
        this.annualIncome = annualIncome;
    }

    public Boolean getObjective() {
        return objective;
    }

    public void setObjective(Boolean objective) {
        this.objective = objective;
    }

    public Boolean getFace() {
        return face;
    }

    public void setFace(Boolean face) {
        this.face = face;
    }

    public Boolean getBody() {
        return body;
    }

    public void setBody(Boolean body) {
        this.body = body;
    }

    public Boolean getInternalCause() {
        return internalCause;
    }

    public void setInternalCause(Boolean internalCause) {
        this.internalCause = internalCause;
    }

    public Boolean getExternalcause() {
        return externalcause;
    }

    public void setExternalcause(Boolean externalcause) {
        this.externalcause = externalcause;
    }

    public String getAdvisorDesignation() {
        return advisorDesignation;
    }

    public void setAdvisorDesignation(String advisorDesignation) {
        this.advisorDesignation = advisorDesignation;
    }

    public Integer getEstablishContactN() {
        return establishContactN;
    }

    public void setEstablishContactN(Integer establishContactN) {
        this.establishContactN = establishContactN;
    }

    public String getManagementCycle() {
        return managementCycle;
    }

    public void setManagementCycle(String managementCycle) {
        this.managementCycle = managementCycle;
    }
}
