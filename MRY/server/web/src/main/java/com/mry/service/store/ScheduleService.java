package com.mry.service.store;

import com.mry.entity.dao.store.*;
import com.mry.entity.store.RoomManagement;
import com.mry.entity.store.customer.MyProduct;
import com.mry.entity.store.customer.MyProject;
import com.mry.entity.store.project.ProjectManagement;
import com.mry.entity.store.serviceOrders.ServiceOrders;
import com.mry.entity.store.serviceOrders.ServiceProject;
import com.mry.entity.user.Customer;
import com.mry.entity.user.Schedule;
import com.mry.entity.user.Staff;
import com.mry.json.store.*;
import com.mry.json.store.serviceOrder.ServiceOrderListJson;
import com.mry.json.store.serviceOrder.ServiceProjectJson;
import com.mry.service.BaseService;
import com.mry.util.DatetimeUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by kaik on 2017/11/21.
 */
@Service
@Transactional
public class ScheduleService extends BaseService {

    @Resource
    public ScheduleDao scheduleDao;
    @Resource
    public StaffDao staffDao;
    @Resource
    public CustomerDao customerDao;
    @Resource
    public RoomDao roomDao;
    @Resource
    public ProjectDao projectDao;
    @Resource
    private ServiceOrdersService serviceOrdersService;

    public int save(String authToken, ScheduleJson data) {
        Staff user = getStaffByAuthToken(authToken);
        Schedule s = new Schedule();
        s.setProjectId(data.getProjectId());
        s.setScheduleStatus("2");
        s.setScheduleDate(DatetimeUtil.parseDateHourWithException(data.getScheduleDate()));
        s.setScheduleEndDate(DatetimeUtil.parseDateHourWithException(data.getScheduleEndDate()));
        if(null != user && null != user.getStoreName() ) {
            s.setStoreName(user.getStoreName());
            s.setStoreId(user.getStoreId());
        }
        if(null != data.getStaffId()) {
            Staff sta = staffDao.findById(data.getStaffId());
            if(null != sta && null !=sta.getRealName()) {
                s.setStaff(sta.getRealName());
                s.setStaffId(data.getStaffId());
            }
        }
        if(null != data.getCustomerId()) {
            Customer cus = customerDao.findById(data.getCustomerId());
            if(null != cus && null !=cus.getRealName()) {
                s.setCustomer(cus.getRealName());
                s.setCustomerId(data.getCustomerId());
            }
        }
        if(null != data.getRoomId()) {
            RoomManagement r = roomDao.findById(data.getRoomId());
            if(null != r && null !=r.getRoomName()) {
                s.setRoom(r.getRoomName());
                s.setRoomId(data.getRoomId());
            }
            r.setRoomStatus("1");
            roomDao.update(r);
        }
        s.setEnable(true);
        scheduleDao.saveObject(s);

        return 1;
    }

    public int edit(String authToken, ScheduleJson data) {
        Staff user = getStaffByAuthToken(authToken);
        Schedule s = scheduleDao.findById(data.getId());
        s.setScheduleStatus("2");
        s.setScheduleDate(DatetimeUtil.parseDateHourWithException(data.getScheduleDate()));
        s.setScheduleEndDate(DatetimeUtil.parseDateHourWithException(data.getScheduleEndDate()));
        if(null != user && null != user.getStoreName() ) {
            s.setStoreName(user.getStoreName());
            s.setStoreId(user.getStoreId());
        }
        if(null != data.getStaffId()) {
            Staff sta = staffDao.findById(data.getStaffId());
            if(null != sta && null !=sta.getRealName()) {
                s.setStaff(sta.getRealName());
                s.setStaffId(data.getStaffId());
            }
        }
        if(null != data.getCustomerId()) {
            Customer cus = customerDao.findById(data.getCustomerId());
            if(null != cus && null !=cus.getRealName()) {
                s.setCustomer(cus.getRealName());
                s.setCustomerId(data.getCustomerId());
            }
        }
        if(null != data.getRoomId()) {
            RoomManagement oldRoom = roomDao.findById(s.getRoomId());
            oldRoom.setRoomStatus("0");
            roomDao.update(oldRoom);
            RoomManagement r = roomDao.findById(data.getRoomId());
            if(null != r && null !=r.getRoomName()) {
                s.setRoom(r.getRoomName());
                s.setRoomId(data.getRoomId());
            }
            r.setRoomStatus("1");
            roomDao.update(r);
        }
        s.setProjectId(data.getProjectId());
        s.setEnable(true);
        scheduleDao.updateObject(s);

        return 1;
    }

    public List<ScheduleListJson> findScheduleList(String authToken, String scheduleDate,String scheduleStatus,Long id) {
        Staff user = getStaffByAuthToken(authToken);
        //所有的技师
        List<Staff> users = staffDao.findByStores(user.getStoreId(),null);
        List<ScheduleListJson> js = new ArrayList<ScheduleListJson>();
        for(Staff u:users){
            ScheduleListJson j = new ScheduleListJson();
            List<Schedule> staffs = scheduleDao.findList(user.getStoreId(),scheduleDate,scheduleStatus,u.getId());
            List<Map<String, Object>> maps = new ArrayList<>();


            List<SchedulexxJson> json = new ArrayList<SchedulexxJson>();
            if (staffs.size()>0) {
                for(Schedule s:staffs){
                    SchedulexxJson schedulexxJson = new SchedulexxJson(s);
                    List<Map<String, Object>> m = new ArrayList<>();
                    String[] strs = s.getProjectId().split(",");
                    for (String st: strs) {
                        Long projectId = Long.parseLong(st);
                        ProjectManagement pj = projectDao.findById(projectId);
                        Map<String, Object> map = new HashMap<>();
                        map.put("name", pj.getProjectName());
                        map.put("id", pj.getId());
                        m.add(map);
                    }
                    schedulexxJson.setProject(m);
                    json.add(schedulexxJson);
                }
            }
            j.setId(u.getId());
            j.setName(user.getRealName());
            j.setJson(json);
            js.add(j);

        }
        return  js;
    }

    public SchedulexxJson findSchedule(Long id) {
        Schedule schedule = scheduleDao.findById(id);
        SchedulexxJson staffs = new SchedulexxJson(schedule);
        List<Map<String, Object>> maps = new ArrayList<>();
        String[] strs = schedule.getProjectId().split(",");
        for (String st: strs) {
            Long projectId = Long.parseLong(st);
            ProjectManagement pj = projectDao.findById(projectId);
            Map<String, Object> map = new HashMap<>();
            map.put("name", pj.getProjectName());
            map.put("id", pj.getId());
            maps.add(map);
        }
        staffs.setProject(maps);
        return staffs;
    }

    public ServiceOrderListJson toServiceOrder(String authToken, Long id) {
        Schedule s = scheduleDao.findById(id);
        ServiceOrders order = new ServiceOrders();
        Customer cus = customerDao.findById(s.getCustomerId());
//        Staff user = getStaffByAuthToken(authToken);

        order.setStoreId(20L);
//        order.setStoreName(user.getStoreName());
        order.setCustomerId(s.getCustomerId());
        order.setCustomer(s.getCustomer());
        order.setLevel(cus.getLevel());
        order.setPhoneNumber(cus.getPhoneNumber());
        order.setAppoint("1");
        order.setPreSale("1");
//        order.setServiceOrderNumber(serviceOrdersService.getServiceOrderNumber(authToken));
        //预约转服务单默认都为消费
        order.setServiceType("2");
        order.setCreateTime(new Date());
        order.setOperatorId(s.getStaffId());
        order.setOperatorName(s.getStaff());
        order.setServiceRoom(s.getRoom());
        order.setRoomId(s.getRoomId());
        order.setServicStatus("0");
        order.setEnable(true);
        order.setOrderType("2");

        Double total=0.00;
        Double kkou=0.00;
        Double zf=0.00;
        if (s.getProjectId() != null) {
            List<ServiceProject> list = new ArrayList<>();
            String[] strs = s.getProjectId().split(",");
            for (String st: strs) {
                Long projectId = Long.parseLong(st);
                ProjectManagement pj = projectDao.findById(projectId);
                if (pj != null) {
                    ServiceProject temp = new ServiceProject();
                    //    total = total + pj.getBuckleMoney.doubleValue();
                    zf = zf + pj.getBuckleMoney().doubleValue();
                    temp.setMoney(pj.getBuckleMoney());
                    temp.setProjectName(pj.getProjectName());
                    temp.setProjectId(projectId);
                    temp.setOrder(order);
                    list.add(temp);

                } else {
                    ServiceProject temp = new ServiceProject();
                    //    total = total + pj.getCashMoney().doubleValue();
                    zf = zf + pj.getCashMoney().doubleValue();
                    temp.setProjectId(projectId);
                    temp.setMoney(pj.getCashMoney());
                    temp.setProjectName(pj.getProjectName());
                    temp.setOrder(order);
                    list.add(temp);
                }
                order.setProject(list);
            }
        }
        order.setTotalAmount(new BigDecimal(total));
        order.setSavingsAmount(new BigDecimal(kkou));
        order.setCashAmount(new BigDecimal(zf));

        ServiceOrders der = scheduleDao.updateObject(order);
        ServiceOrderListJson json = new ServiceOrderListJson(der);
        return json;
    }
}
