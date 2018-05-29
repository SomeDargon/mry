package com.mry.service.store;

import com.mry.entity.StoreManagement;
import com.mry.entity.common.City;
import com.mry.entity.common.Province;
import com.mry.entity.dao.StoreDao;
import com.mry.entity.dao.store.StaffDao;
import com.mry.entity.system.*;
import com.mry.entity.user.Staff;
import com.mry.json.CityJson;
import com.mry.json.ProvinceForJson;
import com.mry.json.ResultsWrapper;
import com.mry.json.StatusJson;
import com.mry.json.store.*;
import com.mry.json.system.StoreCustomerJson;
import com.mry.json.system.StoreCustomerManagement;
import com.mry.security.PooledStrongPasswordEncryptor;
import com.mry.service.BaseService;
import com.mry.util.Pinyin;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaik on 2017/10/30.
 */
@Service
@Transactional
public class StoreService extends BaseService {


    @Resource
    public StoreDao storeDao;
    @Resource
    public StaffDao staffDao;

    @Resource
    private StaffService staffService;

    /**
     * 门店的新增与修改
     * @param data
     * @return
     */
    public int save(StoreJson data) {
        int c=0;
        StoreManagement s = new StoreManagement();

        s.setCityId(data.getCityId());
        City city = storeDao.findCittByid(data.getCityId());
        s.setCityName(city.getName());
        ProvinceForJson province = storeDao.findProvinceById(data.getProvinceId());
        s.setProvinceId(data.getProvinceId());
        s.setProvinceName(province.getName());

        s.setAuditStatus("2");
        s.setStoreName(data.getStoreName());
        //获取编码
        //默认为正在经营
        s.setStoreStatus("1");
        s.setCode(getStoreCode());
        s.setAddress(data.getAddress());
        s.setTelephone(data.getTelephone());
        s.setStaffName(data.getStaffName());
        s.setPhoneNumber(data.getPhoneNumber());
        s.setManagementCycle(data.getManagementCycle());
        s.setTelephone(data.getTelephone());
        s.setStoreType(data.getStoreType());
        s.setOperationMode(data.getOperationMode());
        s.setShopSquare(data.getShopSquare());
        s.setAnnualRent(data.getAnnualRent());
        s.setSeveralStores(data.getSeveralStores());
        s.setNumberOfRooms(data.getNumberOfRooms());
        s.setNumberOfBeds(data.getNumberOfBeds());
        s.setNumberOfEmployees(data.getNumberOfEmployees());
        s.setAreThereAnySales(data.getAreThereAnySales());
        s.setAreThereAnyShop(data.getAreThereAnyShop());
        s.setCashFlow(data.getCashFlow());
        s.setPracticeInTheShop(data.getPracticeInTheShop());
        s.setInnPassengerFlow(data.getInnPassengerFlow());
        s.setDirectProductBrand(data.getDirectProductBrand());
        s.setBrandNumber(data.getBrandNumber());
        s.setTypeOfInstrument(data.getTypeOfInstrument());
        s.setNumberOfInstruments(data.getNumberOfInstruments());
        s.setInstrumentBrand(data.getInstrumentBrand());
        s.setSalarySystem(data.getSalarySystem());
        s.setEmployeeSalary(data.getEmployeeSalary());
        s.setProjectPriceList(data.getProjectPriceList());
        s.setCard(data.getCard());
        s.setExtensionCard(data.getExtensionCard());
        s.setOneCard1(data.getOneCard1());
        s.setOneCard2(data.getOneCard2());
        s.setOneCard3(data.getOneCard3());
        s.setExtensionMethod(data.getExtensionMethod());
        s.setNewCustomers(data.getNewCustomers());
        s.setNumberOfTransactions(data.getNumberOfTransactions());
        s.setNumberOfTransactions1(data.getNumberOfTransactions1());
        s.setNumberOfTransactions2(data.getNumberOfTransactions2());
        s.setNumberOfCustomers(data.getNumberOfCustomers());
        s.setTheBiggestProblem(data.getTheBiggestProblem());
        s.setTheNumberOfRenewals(data.getTheNumberOfRenewals());
        s.setEnable(true);

        s = storeDao.updateObject(s);
        Staff user = new Staff();
        //城市首字母+编号=账号
        String account = Pinyin.getPinYinHeadChar(city.getName())+getStoreCode();
        user.setAccount(account);
      //  user.setPassword(PooledStrongPasswordEncryptor.getInstance().encryptPassword(getPassword()));
        user.setSystem(false);
        user.setPassword(PooledStrongPasswordEncryptor.getInstance().encryptPassword("123456"));
        user.setRealName(data.getStaffName());
        user.setRoleId(2l);
        user.setCode(staffService.getCode(s.getId()));
        user.setStoreId(s.getId());
        user.setStoreName(data.getStoreName());
        user.setPhoneNumber(data.getPhoneNumber());
        user.setEnable(true);
        storeDao.saveObject(user);
        BeauticianMonthlyReport b = new BeauticianMonthlyReport();
        b.setEnable(true);
        b.setStoreId(s.getId());
        b.setStoreName(s.getStoreName());
        storeDao.saveObject(b);
        ConsultantMonthlyReport con = new ConsultantMonthlyReport();
        con.setEnable(true);
        con.setStoreId(s.getId());
        con.setStoreName(s.getStoreName());
        storeDao.saveObject(con);
        DailyStoreDesign dsd = new DailyStoreDesign();
        dsd.setEnable(true);
        dsd.setStoreId(s.getId());
        dsd.setStoreName(s.getStoreName());
        storeDao.saveObject(dsd);
        HairTechnicianMonthlyReport hair = new HairTechnicianMonthlyReport();
        hair.setEnable(true);
        hair.setStoreId(s.getId());
        hair.setStoreName(s.getStoreName());
        storeDao.saveObject(hair);
        ManagerOfTheMonthlyReport man = new ManagerOfTheMonthlyReport();
        man.setEnable(true);
        man.setStoreId(s.getId());
        man.setStoreName(s.getStoreName());
        storeDao.saveObject(man);
        ShopDailyDetails shopd = new ShopDailyDetails();
        shopd.setEnable(true);
        shopd.setStoreId(s.getId());
        shopd.setStoreName(s.getStoreName());
        storeDao.saveObject(shopd);
        ShopMonthlyReport shopm = new ShopMonthlyReport();
        shopm.setEnable(true);
        shopm.setStoreId(s.getId());
        shopm.setStoreName(s.getStoreName());
        storeDao.saveObject(shopm);
        c=1;

        return 1;
    }

    public int edit(StoreJson data) {
        StoreManagement s = storeDao.findById(data.getId());
        s.setCityId(data.getCityId());
        City city = storeDao.findCittByid(data.getCityId());
        s.setCityName(city.getName());
        //     }

        //  if(null != data.getProvinceId()) {
        ProvinceForJson province = storeDao.findProvinceById(data.getProvinceId());
        s.setProvinceId(data.getProvinceId());
        s.setProvinceName(province.getName());

        s.setStoreName(data.getStoreName());
        //获取编码
     //   s.setCode(getStoreCode());
        s.setStoreStatus(data.getStoreStatus());
        s.setAddress(data.getAddress());
        s.setTelephone(data.getTelephone());
        s.setStaffName(data.getStaffName());
        s.setPhoneNumber(data.getPhoneNumber());
        s.setTelephone(data.getTelephone());
        s.setStoreType(data.getStoreType());
        s.setManagementCycle(data.getManagementCycle());
        s.setOperationMode(data.getOperationMode());
        s.setShopSquare(data.getShopSquare());
        s.setAnnualRent(data.getAnnualRent());
        s.setSeveralStores(data.getSeveralStores());
        s.setNumberOfRooms(data.getNumberOfRooms());
        s.setNumberOfBeds(data.getNumberOfBeds());
        s.setNumberOfEmployees(data.getNumberOfEmployees());
        s.setAreThereAnySales(data.getAreThereAnySales());
        s.setAreThereAnyShop(data.getAreThereAnyShop());
        s.setCashFlow(data.getCashFlow());
        s.setPracticeInTheShop(data.getPracticeInTheShop());
        s.setInnPassengerFlow(data.getInnPassengerFlow());
        s.setDirectProductBrand(data.getDirectProductBrand());
        s.setBrandNumber(data.getBrandNumber());
        s.setTypeOfInstrument(data.getTypeOfInstrument());
        s.setNumberOfInstruments(data.getNumberOfInstruments());
        s.setInstrumentBrand(data.getInstrumentBrand());
        s.setSalarySystem(data.getSalarySystem());
        s.setEmployeeSalary(data.getEmployeeSalary());
        s.setProjectPriceList(data.getProjectPriceList());
        s.setCard(data.getCard());
        s.setExtensionCard(data.getExtensionCard());
        s.setOneCard1(data.getOneCard1());
        s.setOneCard2(data.getOneCard2());
        s.setOneCard3(data.getOneCard3());
        s.setExtensionMethod(data.getExtensionMethod());
        s.setNewCustomers(data.getNewCustomers());
        s.setNumberOfTransactions(data.getNumberOfTransactions());
        s.setNumberOfTransactions1(data.getNumberOfTransactions1());
        s.setNumberOfTransactions2(data.getNumberOfTransactions2());
        s.setNumberOfCustomers(data.getNumberOfCustomers());
        s.setTheBiggestProblem(data.getTheBiggestProblem());
        s.setTheNumberOfRenewals(data.getTheNumberOfRenewals());
        s.setEnable(true);

        storeDao.updateObject(s);
        Staff user = staffDao.findStoreUser(data.getId(),2l);
        //根据门店id和角色删除原来的门店责任人
    //    staffDao.deleteStoreUser(data.getId(),2l);
     //   Staff user = new Staff();
        user.setSystem(false);
      //  user.setAccount(data.getPhoneNumber());
        //  user.setPassword(PooledStrongPasswordEncryptor.getInstance().encryptPassword(getPassword()));
        user.setPassword(PooledStrongPasswordEncryptor.getInstance().encryptPassword("123456"));
        user.setRealName(data.getStaffName());
        user.setRoleId(2l);
        user.setCode(staffService.getCode(data.getId()));
        user.setStoreId(data.getId());
        user.setStoreName(data.getStoreName());
        user.setPhoneNumber(data.getPhoneNumber());
        user.setEnable(true);
        storeDao.saveObject(user);
        return 1;
    }

    public StoreManagement findById(Long storeId) {

        StoreManagement store = storeDao.findById(storeId);
        return store;

    }

    /**
     * 门店列表与查找
     * @param authToken
     * @param name（门店名称）
     * @param page
     * @param pageSize
     * @return
     */
    public ResultsWrapper<StoreListJson> findStoreList(String authToken, String name,Long id, Integer page, Integer pageSize) {
        List<StoreManagement> store = storeDao.findList(id,name,page,pageSize);
        List<StoreListJson> json = new ArrayList<StoreListJson>();
        if (store.size()>0) {
            store.forEach(a -> json.add(new StoreListJson(a)));
        }
        Long count = storeDao.findListCount(id,name);

        ResultsWrapper<StoreListJson> h = new ResultsWrapper<StoreListJson>();
        h.setResults(json);
        h.setTotal(count);
        h.setPages(calcPages(count, pageSize));
        return h;
    }


    //随机生成6位数当成密码（生成6位数）
    public static String getPassword(){
        int intFlag = (int)(Math.random() * 1000000);

        String flag = String.valueOf(intFlag);
        if (flag.length() == 6 && flag.substring(0, 1).equals("9"))
        {
            System.out.println(intFlag);
        }
        else
        {
            intFlag = intFlag + 100000;
            System.out.println(intFlag);
        }
        return flag;
    }


    /**
     * 门店编码生成
     * @return
     */
    public String getStoreCode(){
        String code ="0000";
        Long count = storeDao.findMax();
        if(count>=0 && count <= 9){
            code ="000"+count;
        }else  if(count>=10 && count <=99){
            code = "00"+count;
        }else  if(count>=100 && count <=999){
            code = "0"+count;
        }else {
            code = ""+count;
        }
        return code;
    }


    public int delete(Long id) {
        return storeDao.delete(id);
    }


    public Boolean checkStoreName(String storeName) {
        if(storeDao.checkStoreName(storeName) == true) {
            return true;
        }
        return  false;
    }

    public int editStoreCustomer(StoreCustomerManagement data) {
        StoreManagement s = storeDao.findById(data.getId());

        s.setExclusivePointList(data.getExclusivePointList());
        s.setContinuousService(data.getContinuousService());
        s.setServiceTimes(data.getServiceTimes());
        s.setCustomerIntroduction(data.getCustomerIntroduction());
        s.setTechnician(data.getTechnician());
        s.setCustomerComplaint(data.getCustomerComplaint());
        s.setEstablishContact(data.getEstablishContact());
        s.setEstablishContactN(data.getEstablishContactN());
        s.setNoStore(data.getNoStore());
        s.setNoStoreN(data.getNoStoreN());
        s.setCashPoor(data.getCashPoor());
        s.setCashPoorN(data.getCashPoorN());
        s.setClassA(data.getClassA());
        s.setManagementCycle(data.getManagementCycle());
        s.setCustomerClassification(data.getCustomerClassification());
        s.setRegularCustomers(data.getRegularCustomers());
        s.setRegularCustomersN(data.getRegularCustomersN());
        s.setSleepCustomerN(data.getSleepCustomerN());
        s.setFrozenCustomers(data.getFrozenCustomers());
        s.setFrozenCustomersN(data.getFrozenCustomersN());
        s.setCustomerAnalysis(data.getCustomerAnalysis());
//        s.setClassB(data.getClassB());
//        s.setClassC(data.getClassC());
        s.setBigCustomer(data.getBigCustomer());
        s.setBigCustomerN(data.getBigCustomerN());
        s.setOrdinaryCustomer(data.getOrdinaryCustomer());
        s.setOrdinaryCustomerN(data.getOrdinaryCustomerN());
        s.setSleepCustomer(data.getSleepCustomer());
        s.setBloodType(data.getBloodType());
        s.setConstellation(data.getConstellation());
        s.setIncomeMode(data.getIncomeMode());
        s.setAnnualIncome(data.getAnnualIncome());
        s.setObjective(data.getObjective());
        s.setFace(data.getFace());
        s.setBody(data.getBody());
        s.setInternalCause(data.getInternalCause());
        s.setExternalcause(data.getExternalcause());
        s.setAdvisorDesignation(data.getAdvisorDesignation());
        storeDao.updateObject(s);
        return 1;

    }

    public StoreCustomerJson findStoreById(Long id) {
        StoreManagement s = storeDao.findById(id);
        if(s != null){
            StoreCustomerJson cus = new StoreCustomerJson(s);
            return cus;
        }
        return null;

    }

    public List<ProvinceForJson> getAllProvinces() {
        List<Province> list = storeDao.getAllProvinces();

        List<ProvinceForJson> ps = new ArrayList<ProvinceForJson>();
        list.forEach(p -> ps.add(new ProvinceForJson(p.getId(), p.getName())));
        return ps;
    }

    public List<CityJson> findCitiesByProvinceId(Long provinceId) {
        List<City> cities = storeDao.findCitiesByProvinceId(provinceId);

        List<CityJson> list = new ArrayList<CityJson>();
        cities.forEach(c -> list.add(new CityJson(c.getId(), c.getName(), provinceId)));
        return list;
    }

    public List<CityJson> findAllCities() {
        List<City> cities = storeDao.findAllCities();

        List<CityJson> list = new ArrayList<CityJson>();
        for (City c : cities) {
            list.add(new CityJson(c.getId(), c.getName()));
        }
        return list;
    }

    public int register(StoreJson data) {

        int c=0;
        StoreManagement s = new StoreManagement();
        if(data.getId() != null){
            s.setId(data.getId());
        }
        //   if(null != data.getCityId()) {
        //    City city =
        s.setCityId(data.getCityId());
        City city = storeDao.findCittByid(data.getCityId());
        s.setCityName(city.getName());
        //     }

        //  if(null != data.getProvinceId()) {
        ProvinceForJson province = storeDao.findProvinceById(data.getProvinceId());
        s.setProvinceId(data.getProvinceId());
        s.setProvinceName(province.getName());
//        }
//            if(null != data.getProvinceName()) {
//                s.setProvinceName(data.getProvinceName());
//            }

        s.setAuditStatus("1");
        s.setStoreName(data.getStoreName());
        //获取编码
        s.setCode(getStoreCode());
        s.setAddress(data.getAddress());
        s.setTelephone(data.getTelephone());
        s.setStaffName(data.getStaffName());
        s.setPhoneNumber(data.getPhoneNumber());
        s.setManagementCycle(data.getManagementCycle());
        s.setTelephone(data.getTelephone());
        s.setStoreType(data.getStoreType());
        s.setOperationMode(data.getOperationMode());
        s.setShopSquare(data.getShopSquare());
        s.setAnnualRent(data.getAnnualRent());
        s.setSeveralStores(data.getSeveralStores());
        s.setNumberOfRooms(data.getNumberOfRooms());
        s.setNumberOfBeds(data.getNumberOfBeds());
        s.setNumberOfEmployees(data.getNumberOfEmployees());
        s.setAreThereAnySales(data.getAreThereAnySales());
        s.setAreThereAnyShop(data.getAreThereAnyShop());
        s.setCashFlow(data.getCashFlow());
        s.setPracticeInTheShop(data.getPracticeInTheShop());
        s.setInnPassengerFlow(data.getInnPassengerFlow());
        s.setDirectProductBrand(data.getDirectProductBrand());
        s.setBrandNumber(data.getBrandNumber());
        s.setTypeOfInstrument(data.getTypeOfInstrument());
        s.setNumberOfInstruments(data.getNumberOfInstruments());
        s.setInstrumentBrand(data.getInstrumentBrand());
        s.setSalarySystem(data.getSalarySystem());
        s.setEmployeeSalary(data.getEmployeeSalary());
        s.setProjectPriceList(data.getProjectPriceList());
        s.setCard(data.getCard());
        s.setExtensionCard(data.getExtensionCard());
        s.setOneCard1(data.getOneCard1());
        s.setOneCard2(data.getOneCard2());
        s.setOneCard3(data.getOneCard3());
        s.setExtensionMethod(data.getExtensionMethod());
        s.setNewCustomers(data.getNewCustomers());
        s.setNumberOfTransactions(data.getNumberOfTransactions());
        s.setNumberOfTransactions1(data.getNumberOfTransactions1());
        s.setNumberOfTransactions2(data.getNumberOfTransactions2());
        s.setNumberOfCustomers(data.getNumberOfCustomers());
        s.setTheBiggestProblem(data.getTheBiggestProblem());
        s.setTheNumberOfRenewals(data.getTheNumberOfRenewals());
        s.setEnable(true);

        s = storeDao.updateObject(s);
     /*   Staff user = new Staff();
        //城市首字母+编号=账号
        String account = Pinyin.getPinYinHeadChar(city.getName())+getStoreCode();
        user.setAccount(account);
        user.setPassword(PooledStrongPasswordEncryptor.getInstance().encryptPassword("123456"));
        user.setRealName(data.getStaffName());
        user.setRoleId(2l);
        user.setCode(staffService.getCode(s.getId()));
        user.setStoreId(s.getId());
        user.setStoreName(data.getStoreName());
        user.setPhoneNumber(data.getPhoneNumber());
        user.setEnable(true);
        storeDao.saveObject(user);
        BeauticianMonthlyReport b = new BeauticianMonthlyReport();
        b.setEnable(true);
        b.setStoreId(s.getId());
        b.setStoreName(s.getStoreName());
        storeDao.saveObject(b);
        ConsultantMonthlyReport con = new ConsultantMonthlyReport();
        con.setEnable(true);
        con.setStoreId(s.getId());
        con.setStoreName(s.getStoreName());
        storeDao.saveObject(con);
        DailyStoreDesign dsd = new DailyStoreDesign();
        dsd.setEnable(true);
        dsd.setStoreId(s.getId());
        dsd.setStoreName(s.getStoreName());
        storeDao.saveObject(dsd);
        HairTechnicianMonthlyReport hair = new HairTechnicianMonthlyReport();
        hair.setEnable(true);
        hair.setStoreId(s.getId());
        hair.setStoreName(s.getStoreName());
        storeDao.saveObject(hair);
        ManagerOfTheMonthlyReport man = new ManagerOfTheMonthlyReport();
        man.setEnable(true);
        man.setStoreId(s.getId());
        man.setStoreName(s.getStoreName());
        storeDao.saveObject(man);
        ShopDailyDetails shopd = new ShopDailyDetails();
        shopd.setEnable(true);
        shopd.setStoreId(s.getId());
        shopd.setStoreName(s.getStoreName());
        storeDao.saveObject(shopd);
        ShopMonthlyReport shopm = new ShopMonthlyReport();
        shopm.setEnable(true);
        shopm.setStoreId(s.getId());
        shopm.setStoreName(s.getStoreName());
        storeDao.saveObject(shopm);
        c=1;*/

        return 1;
    }

    public ResultsWrapper<StoreListJson> findStoreRegister(String name, Long id, Integer page, Integer pageSize) {

        List<StoreManagement> store = storeDao.findStoreRegister(id,name,page,pageSize);
        List<StoreListJson> json = new ArrayList<StoreListJson>();
        if (store.size()>0) {
            store.forEach(a -> json.add(new StoreListJson(a)));
        }
        Long count = storeDao.findRegisterCount(id,name);

        ResultsWrapper<StoreListJson> h = new ResultsWrapper<StoreListJson>();
        h.setResults(json);
        h.setTotal(count);
        h.setPages(calcPages(count, pageSize));
        return h;
    }

    public int auditStoreCustomer(ResonOfAuditJson data) {
        StoreManagement s = storeDao.findById(data.getId());
        s.setAuditStatus(data.getAuditStatus());
        s.setCauseOfFailure(data.getCauseOfFailure());
        s.setStoreStatus("1");
        if(data.getAuditStatus().equals("2")){
            Staff user = new Staff();
            //城市首字母+编号=账号
            String account = Pinyin.getPinYinHeadChar(s.getCityName())+getStoreCode();
            user.setAccount(account);
         //   user.setPassword(PooledStrongPasswordEncryptor.getInstance().encryptPassword(getPassword()));
            user.setSystem(false);
            user.setPassword(PooledStrongPasswordEncryptor.getInstance().encryptPassword("123456"));
            user.setRealName(s.getStaffName());
            user.setRoleId(2l);
            user.setCode(staffService.getCode(s.getId()));
            user.setStoreId(s.getId());
            user.setStoreName(s.getStoreName());
            user.setPhoneNumber(s.getPhoneNumber());
            user.setEnable(true);
            storeDao.saveObject(user);
            BeauticianMonthlyReport b = new BeauticianMonthlyReport();
            b.setEnable(true);
            b.setStoreId(s.getId());
            b.setStoreName(s.getStoreName());
            storeDao.saveObject(b);
            ConsultantMonthlyReport con = new ConsultantMonthlyReport();
            con.setEnable(true);
            con.setStoreId(s.getId());
            con.setStoreName(s.getStoreName());
            storeDao.saveObject(con);
            DailyStoreDesign dsd = new DailyStoreDesign();
            dsd.setEnable(true);
            dsd.setStoreId(s.getId());
            dsd.setStoreName(s.getStoreName());
            storeDao.saveObject(dsd);
            HairTechnicianMonthlyReport hair = new HairTechnicianMonthlyReport();
            hair.setEnable(true);
            hair.setStoreId(s.getId());
            hair.setStoreName(s.getStoreName());
            storeDao.saveObject(hair);
            ManagerOfTheMonthlyReport man = new ManagerOfTheMonthlyReport();
            man.setEnable(true);
            man.setStoreId(s.getId());
            man.setStoreName(s.getStoreName());
            storeDao.saveObject(man);
            ShopDailyDetails shopd = new ShopDailyDetails();
            shopd.setEnable(true);
            shopd.setStoreId(s.getId());
            shopd.setStoreName(s.getStoreName());
            storeDao.saveObject(shopd);
            ShopMonthlyReport shopm = new ShopMonthlyReport();
            shopm.setEnable(true);
            shopm.setStoreId(s.getId());
            shopm.setStoreName(s.getStoreName());
            storeDao.saveObject(shopm);
        }
        storeDao.updateObject(s);
        return 1;

    }

    public StoreListJson findAuditOfFailure(String phoneNumber) {
        StoreManagement s = storeDao.findByNumber(phoneNumber);
        if(s != null && s.getId() != null) {
            StoreListJson json = new StoreListJson(s);
            return json;
        }
        return null;
    }

    public StatusJson updataByPhone(VerificationJson data) {

        Staff user = staffService.findStoreByPhone(data.getPhoneNumber());

      //  user.setPassword(PooledStrongPasswordEncryptor.getInstance().encryptPassword(getPassword()));
    if(user != null && user.getVerification().equals(data.getVerification())) {
        user.setPassword(PooledStrongPasswordEncryptor.getInstance().encryptPassword("123456"));
        user.setVerification("");
        staffService.save(user);
        StatusJson json = new StatusJson();
        json.setStatus(1);
        json.setMessage("修改成功");
        return json;
    }else {
        StatusJson json = new StatusJson();
        json.setStatus(2);
        json.setMessage("该用户不存在");
        return json;
    }

    }

    public Boolean checkStorePhone(String phoneNumber) {
        if(storeDao.checkStorePhone(phoneNumber) == true) {
            return true;
        }
        return  false;
    }

    public StatusJson getVerification(String phoneNumber) {

        Staff user = staffService.findStoreByPhone(phoneNumber);
        StatusJson json = new StatusJson();
        if(user != null) {
            int intFlag = (int) (Math.random() * 1000);

            String flag = String.valueOf(intFlag);
            user.setVerification(flag);
            storeDao.updateObject(user);
            //  user.setPassword(PooledStrongPasswordEncryptor.getInstance().encryptPassword(getPassword()));
           json.setMessage(flag);
            json.setStatus(3);
        }else {
            json.setMessage("该用户不存在");
            json.setStatus(2);
        }
        return json;
    }
}
