package com.mry.entity;

import com.mry.entity.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by kaik on 2017/10/18.
 * 门店管理
 */
@Entity
@Table(name = StoreManagement.TABLE_NAME)
public class StoreManagement extends BaseEntity {

    public static final String TABLE_NAME = "store_management";

    //审核状态(1：审核中；2：审核通过;3：注册失败)
    @Column(name = "audit_status")
    private String auditStatus;

    //失败原因
    @Column(name = "cause_of_failure")
    private String causeOfFailure;

    //省
    @Column(name = "province_name")
    private String provinceName;

    //省
    @Column(name = "province_id")
    private Long provinceId;

    //城市
    @Column(name = "city_name")
    private String cityName;

    //城市
    @Column(name = "city_id")
    private Long cityId;

    //店名称
    @Column(name = "store_name")
    private String storeName;

    //店编码
    @Column(name = "code")
    private String code;

    //地址
    @Column(name = "address")
    private String address;

    //电话
    @Column(name = "telephone")
    private String telephone;

    //负责人
    @Column(name = "staff_name")
    private String staffName;

    //负责人Id
    @Column(name = "staff_id")
    private Long staffId;

    //负责人手机
    @Column(name = "phone_number")
    private String phoneNumber;
//
//    //店面电话
//    @Column(name = "tel_number")
//    private String telNumber;

    //门店类型（美容院、皮肤管理）
    @Column(name = "store_type")
    private String storeType;

    //经营方式（单店／连锁）
    @Column(name = "operation_mode")
    private String operationMode;

    //店平方数
    @Column(name = "shop_square")
    private String shopSquare;

    //年房租
    @Column(name = "annual_rent")
    private String annualRent;

    //几家店
    @Column(name = "several_stores")
    private String severalStores;

    //房间数量
    @Column(name = "number_of_rooms")
    private String numberOfRooms;

    //床位数量
    @Column(name = "number_of_beds")
    private String numberOfBeds;

    //员工数量
    @Column(name = "number_of_employees")
    private String numberOfEmployees;

    //有无销售顾问
    @Column(name = "are_there_any_sales")
    private String areThereAnySales;

    //有无店长
    @Column(name = "are_there_any_shop")
    private String areThereAnyShop;

    //连续十二个月店内现金流水
    @Column(name = "cash_flow")
    private String cashFlow;

    //连续十二个月店内实操
    @Column(name = "practice_in_the_shop")
    private String practiceInTheShop;

    //连续十二个月店内客流
    @Column(name = "inn_passenger_flow")
    private String innPassengerFlow;

    //连续十二个月店内产品业绩
    @Column(name = "product_performance")
    private String productPerformance;

    //直营产品品牌
    @Column(name = "direct_product_brand")
    private String directProductBrand;

    //直营产品品牌数量
    @Column(name = "brand_number")
    private String brandNumber;

    //仪器种类
    @Column(name = "type_of_instrument")
    private String typeOfInstrument;

    //仪器数量
    @Column(name = "number_of_instruments")
    private String numberOfInstruments;

    //仪器品牌
    @Column(name = "instrument_brand")
    private String instrumentBrand;

    //薪资制度
    @Column(name = "salary_system")
    private String salarySystem;

    //员工12个月薪资
    @Column(name = "employee_salary")
    private String employeeSalary;

    //项目价格单
    @Column(name = "project_price_list")
    private String projectPriceList;

    //卡项
    @Column(name = "card")
    private String card;

    //拓客卡
    @Column(name = "extension_card")
    private String extensionCard;

    //留客卡
    @Column(name = "one_card1")
    private String oneCard1;

    //留客卡
    @Column(name = "one_card2")
    private String oneCard2;

    //留客卡
    @Column(name = "one_card3")
    private String oneCard3;

    //主要拓客方式
    @Column(name = "extension_method")
    private String extensionMethod;

    //每个月进店新顾客人数
    @Column(name = "new_customers")
    private String newCustomers;

    //成交人数
    @Column(name = "number_of_transactions")
    private String numberOfTransactions;

    //第一次成交
    @Column(name = "number_of_transactions1")
    private String numberOfTransactions1;

    //第二次成交
    @Column(name = "number_of_transactions2")
    private String numberOfTransactions2;

    //顾客数量
    @Column(name = "number_of_customers")
    private String numberOfCustomers;

    //老顾客续费人数
    @Column(name = "the_number_of_renewals")
    private String theNumberOfRenewals;

    //目前自己认为经营的最大问题是什么？
    @Column(name = "the_biggest_problem")
    private String theBiggestProblem;


    //建立联系的方式

    //排他性点单
    @Column(name = "exclusive_point_list")
    private Boolean exclusivePointList;

    // 某技师连续服务N次
    @Column(name = "continuous_service")
    private Boolean continuousService;

    // 某技师连续服务N次
    @Column(name = "service_times")
    private Integer serviceTimes;

    // 有联系的顾客介绍
    @Column(name = "customer_introduction")
    private Boolean customerIntroduction;

    //技师直接拓客
    @Column(name = "technician")
    private Boolean technician;


    //顾客投诉
    @Column(name = "customer_complaint")
    private Boolean customerComplaint;

    //其他技师建立联系
    @Column(name = "establish_contact")
    private Boolean establishContact;

    //其他技师建立联系
    @Column(name = "establish_contactn")
    private Integer establishContactN;

    //顾客联系N个月不到店
    @Column(name = "no_store")
    private Boolean noStore;


    //顾客联系N个月不到店
    @Column(name = "no_store_n")
    private String noStoreN;

    // 顾客连续N月无现金
    @Column(name = "cash_poor")
    private Boolean cashPoor;

    // 顾客连续N月无现金
    @Column(name = "cash_poor_n")
    private String cashPoorN;

    //顾客分类
    @Column(name = "customer_classification")
    private Boolean customerClassification;

    //  A类
    @Column(name = "class_A")
    private Boolean classA;
//
//    //  B类
//    @Column(name = "class_B")
//    private Boolean classB;
//
//    //  C类
//    @Column(name = "class_C")
//    private Boolean classC;

    // 大客户
    @Column(name = "big_customer")
    private Boolean bigCustomer;

    // 大客户（消费达N元）
    @Column(name = "big_customer_n")
    private String bigCustomerN;

    // 普通客户（
    @Column(name = "ordinary_customer")
    private Boolean ordinaryCustomer;

    // 普通客户（消费不足N元） 睡眠客户
    @Column(name = "ordinary_customer_n")
    private String ordinaryCustomerN;

    // 睡眠客户
    @Column(name = "sleep_customer")
    private Boolean sleepCustomer;

    // 睡眠客户
    @Column(name = "sleep_customer_n")
    private String sleepCustomerN;

    // 常到店客户
    @Column(name = "regular_customers")
    private Boolean regularCustomers;

    // 常到店客户
    @Column(name = "regular_customers_n")
    private String regularCustomersN;

    // 冻结客户
    @Column(name = "frozen_customers")
    private Boolean frozenCustomers;

    // 冻结客户
    @Column(name = "frozen_customers_n")
    private String frozenCustomersN;

    // 客户分析
    @Column(name = "customer_analysis")
    private Boolean customerAnalysis;

    //血型
    @Column(name = "blood_type")
    private Boolean bloodType;

    //星座
    @Column(name = "constellation")
    private Boolean constellation;

    //收入方式
    @Column(name = "income_mode")
    private Boolean incomeMode;

    //年收入
    @Column(name = "annual_income")
    private Boolean annualIncome;

    // 到美容院的目的
    @Column(name = "objective")
    private Boolean objective;

    //  面部
    @Column(name = "face")
    private Boolean face;

    //身体
    @Column(name = "body")
    private Boolean body;

    //内因   外因
    @Column(name = "internal_cause")
    private Boolean internalCause;

    // 外因
    @Column(name = "external_cause")
    private Boolean externalcause;

    //  1）指定技师2）上次服务者3）服务最多者 前三项不能判断由4）店长顾问指定
    @Column(name = "advisor_designation")
    private String advisorDesignation;

    // 门店状态 1正在管理   2经营不善   3不再管理
    @Column(name = "store_status")
    private String storeStatus;

    // 管理周期
    @Column(name = "management_cycle")
    private String managementCycle;




    //是否启用
    @Column(name = "is_enable")
    private Boolean isEnable;

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    public String getOperationMode() {
        return operationMode;
    }

    public void setOperationMode(String operationMode) {
        this.operationMode = operationMode;
    }

    public String getShopSquare() {
        return shopSquare;
    }

    public void setShopSquare(String shopSquare) {
        this.shopSquare = shopSquare;
    }

    public String getAnnualRent() {
        return annualRent;
    }

    public void setAnnualRent(String annualRent) {
        this.annualRent = annualRent;
    }

    public String getSeveralStores() {
        return severalStores;
    }

    public void setSeveralStores(String severalStores) {
        this.severalStores = severalStores;
    }

    public String getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(String numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public String getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(String numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public String getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(String numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public String getAreThereAnySales() {
        return areThereAnySales;
    }

    public void setAreThereAnySales(String areThereAnySales) {
        this.areThereAnySales = areThereAnySales;
    }

    public String getAreThereAnyShop() {
        return areThereAnyShop;
    }

    public void setAreThereAnyShop(String areThereAnyShop) {
        this.areThereAnyShop = areThereAnyShop;
    }

    public String getCashFlow() {
        return cashFlow;
    }

    public void setCashFlow(String cashFlow) {
        this.cashFlow = cashFlow;
    }

    public String getPracticeInTheShop() {
        return practiceInTheShop;
    }

    public void setPracticeInTheShop(String practiceInTheShop) {
        this.practiceInTheShop = practiceInTheShop;
    }

    public String getInnPassengerFlow() {
        return innPassengerFlow;
    }

    public void setInnPassengerFlow(String innPassengerFlow) {
        this.innPassengerFlow = innPassengerFlow;
    }

    public String getProductPerformance() {
        return productPerformance;
    }

    public void setProductPerformance(String productPerformance) {
        this.productPerformance = productPerformance;
    }

    public String getDirectProductBrand() {
        return directProductBrand;
    }

    public void setDirectProductBrand(String directProductBrand) {
        this.directProductBrand = directProductBrand;
    }

    public String getBrandNumber() {
        return brandNumber;
    }

    public void setBrandNumber(String brandNumber) {
        this.brandNumber = brandNumber;
    }

    public String getTypeOfInstrument() {
        return typeOfInstrument;
    }

    public void setTypeOfInstrument(String typeOfInstrument) {
        this.typeOfInstrument = typeOfInstrument;
    }

    public String getNumberOfInstruments() {
        return numberOfInstruments;
    }

    public void setNumberOfInstruments(String numberOfInstruments) {
        this.numberOfInstruments = numberOfInstruments;
    }

    public String getInstrumentBrand() {
        return instrumentBrand;
    }

    public void setInstrumentBrand(String instrumentBrand) {
        this.instrumentBrand = instrumentBrand;
    }

    public String getSalarySystem() {
        return salarySystem;
    }

    public void setSalarySystem(String salarySystem) {
        this.salarySystem = salarySystem;
    }

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getProjectPriceList() {
        return projectPriceList;
    }

    public void setProjectPriceList(String projectPriceList) {
        this.projectPriceList = projectPriceList;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getExtensionCard() {
        return extensionCard;
    }

    public void setExtensionCard(String extensionCard) {
        this.extensionCard = extensionCard;
    }

    public String getOneCard1() {
        return oneCard1;
    }

    public void setOneCard1(String oneCard1) {
        this.oneCard1 = oneCard1;
    }

    public String getOneCard2() {
        return oneCard2;
    }

    public void setOneCard2(String oneCard2) {
        this.oneCard2 = oneCard2;
    }

    public String getOneCard3() {
        return oneCard3;
    }

    public void setOneCard3(String oneCard3) {
        this.oneCard3 = oneCard3;
    }

    public String getExtensionMethod() {
        return extensionMethod;
    }

    public void setExtensionMethod(String extensionMethod) {
        this.extensionMethod = extensionMethod;
    }

    public String getNewCustomers() {
        return newCustomers;
    }

    public void setNewCustomers(String newCustomers) {
        this.newCustomers = newCustomers;
    }

    public String getNumberOfTransactions() {
        return numberOfTransactions;
    }

    public void setNumberOfTransactions(String numberOfTransactions) {
        this.numberOfTransactions = numberOfTransactions;
    }

    public String getNumberOfTransactions1() {
        return numberOfTransactions1;
    }

    public void setNumberOfTransactions1(String numberOfTransactions1) {
        this.numberOfTransactions1 = numberOfTransactions1;
    }

    public String getNumberOfTransactions2() {
        return numberOfTransactions2;
    }

    public void setNumberOfTransactions2(String numberOfTransactions2) {
        this.numberOfTransactions2 = numberOfTransactions2;
    }

    public String getNumberOfCustomers() {
        return numberOfCustomers;
    }

    public void setNumberOfCustomers(String numberOfCustomers) {
        this.numberOfCustomers = numberOfCustomers;
    }

    public String getTheNumberOfRenewals() {
        return theNumberOfRenewals;
    }

    public void setTheNumberOfRenewals(String theNumberOfRenewals) {
        this.theNumberOfRenewals = theNumberOfRenewals;
    }

    public String getTheBiggestProblem() {
        return theBiggestProblem;
    }

    public void setTheBiggestProblem(String theBiggestProblem) {
        this.theBiggestProblem = theBiggestProblem;
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

    public Boolean getCustomerClassification() {
        return customerClassification;
    }

    public void setCustomerClassification(Boolean customerClassification) {
        this.customerClassification = customerClassification;
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

    public String getStoreStatus() {
        return storeStatus;
    }

    public void setStoreStatus(String storeStatus) {
        this.storeStatus = storeStatus;
    }

    public String getManagementCycle() {
        return managementCycle;
    }

    public void setManagementCycle(String managementCycle) {
        this.managementCycle = managementCycle;
    }

    public Integer getEstablishContactN() {
        return establishContactN;
    }

    public void setEstablishContactN(Integer establishContactN) {
        this.establishContactN = establishContactN;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getCauseOfFailure() {
        return causeOfFailure;
    }

    public void setCauseOfFailure(String causeOfFailure) {
        this.causeOfFailure = causeOfFailure;
    }
}
