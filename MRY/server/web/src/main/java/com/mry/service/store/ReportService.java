package com.mry.service.store;

import com.mry.entity.StoreManagement;
import com.mry.entity.dao.StoreDao;
import com.mry.entity.dao.store.ReportDao;
import com.mry.entity.dto.BeauticianMonthly;
import com.mry.entity.dto.DailyDetails;
import com.mry.entity.dto.MonthDetails;
import com.mry.entity.store.serviceOrders.ServiceOrders;
import com.mry.entity.store.serviceOrders.ServiceProduct;
import com.mry.entity.store.serviceOrders.ServiceProject;
import com.mry.entity.system.*;
import com.mry.entity.user.Customer;
import com.mry.entity.user.Staff;
import com.mry.json.store.BeauticianJson;
import com.mry.json.store.DailyListJson;
import com.mry.json.store.DaySumJson;
import com.mry.service.BaseService;
import com.mry.util.DatetimeUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by kaik on 2017/11/30.
 */
@Service
@Transactional
public class ReportService extends BaseService {

    @Resource
    public ReportDao reportDao;

    @Resource
    public StoreDao storeDao;

    public List<DailyListJson> findDayList(String authToken, String reportTime) {
        String date;
        if(reportTime != null){
          //  date = DatetimeUtil.parseDate(reportTime);
            date = reportTime;
        }else {
            date = DatetimeUtil.formatDate(new Date());
         //   date = DatetimeUtil.parseDate(DatetimeUtil.formatDate(new Date()));
        }
        Staff user = getStaffByAuthToken(authToken);
        List<DailyListJson> json = reportDao.findDayList(user.getStoreId(),date);
        return json;
    }

    public DaySumJson findDaySum(String authToken, String reportTime) {
        String date;
        if(reportTime != null){
            //  date = DatetimeUtil.parseDate(reportTime);
            date = reportTime;
        }else {
            date = DatetimeUtil.formatDate(new Date());
            //   date = DatetimeUtil.parseDate(DatetimeUtil.formatDate(new Date()));
        }

        Staff user = getStaffByAuthToken(authToken);
        DaySumJson sum = reportDao.findDaySum(user.getStoreId(),date);
        return sum;
    }

    public List<BeauticianJson> findBeauticianDaySum(String authToken, Long id, String reportTime) {
        String date;
        if(reportTime != null){
            //  date = DatetimeUtil.parseDate(reportTime);
            date = reportTime;
        }else {
            date = DatetimeUtil.formatDate(new Date());
            //   date = DatetimeUtil.parseDate(DatetimeUtil.formatDate(new Date()));
        }
        Staff user = getStaffByAuthToken(authToken);
        List<BeauticianJson> sum = reportDao.findBeauticianDaySum(user.getStoreId(),id,date);
        return sum;
    }

    public List<DaySumJson> findMouthList(String authToken, String reportTime) {
        String date;
        if(reportTime != null){
          //    date = DatetimeUtil.parseDate(reportTime);
            date = reportTime;
        }else {
            date = DatetimeUtil.formatDate(new Date());
           //    date = DatetimeUtil.parseDate(DatetimeUtil.formatDate(new Date()));
        }

        Staff user = getStaffByAuthToken(authToken);
        List<DaySumJson> sum = reportDao.findMouthList(user.getStoreId(),date);
        return sum;
    }

    public DaySumJson findMouthSum(String authToken, String reportTime) {
        String date;
        if(reportTime != null){
            //  date = DatetimeUtil.parseDate(reportTime);
            date = reportTime;
        }else {
            date = DatetimeUtil.formatDate(new Date());
            //   date = DatetimeUtil.parseDate(DatetimeUtil.formatDate(new Date()));
        }

        Staff user = getStaffByAuthToken(authToken);
        DaySumJson sum = reportDao.findMouthSum(user.getStoreId(),date);
        return sum;
    }

    public int saveDailyStoreDesign(DailyStoreDesign data) {
        data.setEnable(true);
        if(data.getId() == null){
            reportDao.saveObject(data);
        }else {
            reportDao.updateObject(data);
        }
        return 1;
    }


    public DailyStoreDesign findDailyStoreDesign(Long id) {
        DailyStoreDesign d = reportDao.findDailyStoreDesign(id);
        if(d != null) {
            return d;
        }else {
            return null;
        }
    }

    public int saveShopMonthlyReport(ShopMonthlyReport data) {
        data.setEnable(true);
        if(data.getId() == null){
            reportDao.saveObject(data);
        }else {
            reportDao.updateObject(data);
        }
        return 1;
    }

    public ShopMonthlyReport findShopMonthlyReport(Long id) {
        ShopMonthlyReport s = reportDao.findShopMonthlyReport(id);
        if(s != null) {
            return s;
        }else {
            return null;
        }

    }

    public int saveConsultantMonthlyReport(ConsultantMonthlyReport data) {
        StoreManagement store =storeDao.findById(data.getStoreId());
        data.setStoreName(store.getStoreName());
        data.setEnable(true);
        if(data.getId() == null){
            reportDao.saveObject(data);
        }else {
            reportDao.updateObject(data);
        }
        return 1;
    }

    public ConsultantMonthlyReport findConsultantMonthlyReport(Long id) {

        ConsultantMonthlyReport s = reportDao.findConsultantMonthlyReport(id);
        if(s != null) {
            return s;
        }else {
            return null;
        }
    }

    public int saveBeauticianMonthlyReport(BeauticianMonthlyReport data) {
        StoreManagement store =storeDao.findById(data.getStoreId());
        data.setStoreName(store.getStoreName());
        data.setEnable(true);
        if(data.getId() == null){
            reportDao.saveObject(data);
        }else {
            reportDao.updateObject(data);
        }
        return 1;
    }

    public BeauticianMonthlyReport findBeauticianMonthlyReport(Long id) {

        BeauticianMonthlyReport s = reportDao.findBeauticianMonthlyReport(id);
        if(s != null) {
            return s;
        }else {
            return null;
        }
    }

    public int saveHairTechnicianMonthlyReport(HairTechnicianMonthlyReport data) {
        StoreManagement store =storeDao.findById(data.getStoreId());
        data.setStoreName(store.getStoreName());
        data.setEnable(true);
        if(data.getId() == null){
            reportDao.saveObject(data);
        }else {
            reportDao.updateObject(data);
        }
        return 1;
    }

    public HairTechnicianMonthlyReport findHairTechnicianMonthlyReport(Long id) {

        HairTechnicianMonthlyReport s = reportDao.findHairTechnicianMonthlyReport(id);
        if(s != null) {
            return s;
        }else {
            return null;
        }
    }

    public int saveManagerOfTheMonthlyReport(ManagerOfTheMonthlyReport data) {
        StoreManagement store =storeDao.findById(data.getStoreId());
        data.setStoreName(store.getStoreName());
        data.setEnable(true);
        if(data.getId() == null){
            reportDao.saveObject(data);
        }else {
            reportDao.updateObject(data);
        }
        return 1;
    }

    public ManagerOfTheMonthlyReport findManagerOfTheMonthlyReport(Long id) {

        ManagerOfTheMonthlyReport s = reportDao.findManagerOfTheMonthlyReport(id);
        if(s != null) {
            return s;
        }else {
            return null;
        }
    }

    public int saveShopDailyDetails(ShopDailyDetails data) {
        StoreManagement store =storeDao.findById(data.getStoreId());
        data.setStoreName(store.getStoreName());
        data.setEnable(true);
        if(data.getId() == null){
            reportDao.saveObject(data);
        }else {
            reportDao.updateObject(data);
        }
        return 1;
    }

    public ShopDailyDetails findShopDailyDetails(Long id) {

        ShopDailyDetails s = reportDao.findShopDailyDetails(id);
        if(s != null) {
            return s;
        }else {
            return null;
        }
    }

    @Resource
    private ServiceOrdersService serviceOrdersService;
    @Resource
    private StaffService staffService;

    public  Map<Object, Object> findDailyDetails( String authToken, String d) {
        Staff user = getStaffByAuthToken(authToken);
        ShopDailyDetails s = reportDao.findShopDailyDetails(user.getStoreId());
        Calendar cal = Calendar.getInstance();
        Date date = DatetimeUtil.parseDate(d);
        cal.setTime(date);
        Date begin = cal.getTime();
        cal.add(Calendar.DATE, 1);
        Date end = cal.getTime();
        List<ServiceOrders> serviceOrderses = serviceOrdersService.findByStoreId(user.getStoreId(), begin, end);
        List<Map<String, Object>> maps = new ArrayList<>();
        //查询店员
        for (ServiceOrders serviceOrders:serviceOrderses){
            Map map = DailyDetails.getValue(s, serviceOrders);
            if (map!=null){
                maps.add(map);
            }
        }
        //获取头部 标题
        List<String> title = DailyDetails.getTitle(s);
        Map<Object, Object> result = new HashMap<>();
        result.put("title", title);
        result.put("data", maps);
       return result;
    }

    public Map<String, Object> findMonthDetails(String authToken, String d){
        Staff user = getStaffByAuthToken(authToken);
        Date firstDate = startDate(d);
        Date lastDate = endDate(firstDate);
        ManagerOfTheMonthlyReport s = reportDao.findManagerOfTheMonthlyReport(user.getStoreId());
        List<ServiceOrders> serviceOrderses = serviceOrdersService.findByStoreId(user.getStoreId(), firstDate, lastDate);
        //查询店员
        MonthDetails m = new MonthDetails();
        for (ServiceOrders serviceOrders:serviceOrderses){
           MonthDetails.getDate(m, serviceOrders, user);
        }
        return MonthDetails.getTitle(s, m);
    }

    public Map<String, Object> findBeauticianMonthlyDetails(String authToken, String d){
        Staff user = getStaffByAuthToken(authToken);
        List<Map<String, Object>> maps = new ArrayList<>();
        BeauticianMonthlyReport s = reportDao.findBeauticianMonthlyReport(user.getStoreId());
        Date firstDate = startDate(d);
        Date lastDate = endDate(firstDate);
        List<ServiceOrders> serviceOrderses = serviceOrdersService.findByStoreId(user.getStoreId(), firstDate, lastDate);
        List<Staff> staffs = staffService.findStoreId(user.getStoreId());
        for (Staff customer:staffs){
            BeauticianMonthly b = new BeauticianMonthly();
            for (ServiceOrders service : serviceOrderses) {
                BeauticianMonthly.setData(b, service, customer);
            }
            maps.add(BeauticianMonthly.getData(b, s));
        }
        Map<String, Object> result = new HashMap<>();
        result.put("title", BeauticianMonthly.getTitle(s));
        result.put("data", maps);
        return result;
    }
    public Map<String, Object> findConsultantMonthlyDetails(String authToken, String d){
        Staff user = getStaffByAuthToken(authToken);
        List<Map<String, Object>> maps = new ArrayList<>();
        ConsultantMonthlyReport s = reportDao.findConsultantMonthlyReport(user.getStoreId());
        Date firstDate = startDate(d);
        Date lastDate = endDate(firstDate);
        List<ServiceOrders> serviceOrderses = serviceOrdersService.findByStoreId(user.getStoreId(), firstDate, lastDate);
        List<Staff> staffs = staffService.findStoreId(user.getStoreId());
        for (Staff customer:staffs){
            if (customer.getRealName().equals("")){

            }
            BeauticianMonthly b = new BeauticianMonthly();
            for (ServiceOrders service : serviceOrderses) {
                BeauticianMonthly.setData(b, service, customer);
            }
//            maps.add(ConsultantMonthly.getData(b, s));
        }
        Map<String, Object> result = new HashMap<>();
//        result.put("title", ConsultantMonthly.getTitle(s));
        result.put("data", maps);
        return result;
    }




    public  Date startDate(String d){
        Calendar cal = Calendar.getInstance();
        Date date = DatetimeUtil.parseMonthWithException(d);
        cal.setTime(date);
        cal.set(Calendar.DATE, 1);
        return cal.getTime();
    }

    public  Date endDate(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }
}
