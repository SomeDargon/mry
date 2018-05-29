package com.mry.json.store;

public class StoreJson {
	private Long id;

	//省
	private String provinceName;

	//省
	private Long provinceId;

	//城市
	private String cityName;

	//城市
	private Long cityId;

	//店名称
	private String storeName;

	//店编码
	private String code;

	//地址
	private String address;

	//电话
	private String telephone;

	//负责人
	private String staffName;

	//负责人Id
	private Long staffId;

	//负责人手机
	private String phoneNumber;

	//店面电话
//	private String telNumber;

	//门店类型（美容院、皮肤管理）
	private String storeType;

	//经营方式（单店／连锁）
	private String operationMode;

	//店平方数
	private String shopSquare;

	//年房租
	private String annualRent;

	//几家店
	private String severalStores;

	//房间数量
	private String numberOfRooms;

	//床位数量
	private String numberOfBeds;

	//员工数量
	private String numberOfEmployees;

	//有无销售顾问
	private String areThereAnySales;

	//有无店长
	private String areThereAnyShop;

	//连续十二个月店内现金流水
	private String cashFlow;

	//连续十二个月店内实操
	private String practiceInTheShop;

	//连续十二个月店内客流
	private String innPassengerFlow;

	//连续十二个月店内产品业绩
	private String productPerformance;

	//直营产品品牌
	private String directProductBrand;

	//直营产品品牌数量
	private String brandNumber;

	//仪器种类
	private String typeOfInstrument;

	//仪器数量
	private String numberOfInstruments;

	//仪器品牌
	private String instrumentBrand;

	//薪资制度
	private String salarySystem;

	//员工12个月薪资
	private String employeeSalary;

	//项目价格单
	private String projectPriceList;

	//卡项
	private String card;

	//拓客卡
	private String extensionCard;

	//留客卡
	private String oneCard1;

	//留客卡
	private String oneCard2;

	//留客卡
	private String oneCard3;

	//主要拓客方式
	private String extensionMethod;

	//每个月进店新顾客人数
	private String newCustomers;

	//成交人数
	private String numberOfTransactions;

	//第一次成交
	private String numberOfTransactions1;

	//第二次成交
	private String numberOfTransactions2;

	//顾客数量
	private String numberOfCustomers;

	//老顾客续费人数
	private String theNumberOfRenewals;

	//目前自己认为经营的最大问题是什么？
	private String theBiggestProblem;


	// 门店状态
	private String storeStatus;

	// 管理周期
	private String managementCycle;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

//	public String getTelNumber() {
//		return telNumber;
//	}
//
//	public void setTelNumber(String telNumber) {
//		this.telNumber = telNumber;
//	}

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

	public String getInnPassengerFlow() {
		return innPassengerFlow;
	}

	public void setInnPassengerFlow(String innPassengerFlow) {
		this.innPassengerFlow = innPassengerFlow;
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

	//	public StoreJson(StoreManagement data) {
//		this.id = data.getId();
//		this.provinceName = data.getProvinceName();
//		this.provinceId = data.getProvinceId();
//		this.cityName = data.getCityName();
//		this.cityId = data.getCityId();
//		this.storeName = data.getStoreName();
//		this.code = data.getCode();
//		this.address = data.getAddress();
//		this.telephone = data.getTelephone();
//		this.staffName = data.getStaffName();
//		this.staffId = data.getStaffId();
//		this.phoneNumber = data.getPhoneNumber();
//	}
}
