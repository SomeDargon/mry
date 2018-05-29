package com.mry.json.store;

import com.mry.entity.user.Schedule;
import com.mry.util.DatetimeUtil;

import java.util.Map;
import java.util.List;
/**
 * Created by kaik on 2017/12/7.
 */
public class SchedulexxJson {
    private Long id;

    //注册店
    private String storeName;

    //注册店Id
    private Long storeId;

    //开始时间
    private String scheduleDate;
    //结束时间
    private String scheduleEndDate;
    //房间号
    private Long roomId;
    private String roomName;

    //客户
    private Long customerId;
    private String customerName;
    //员工
    private Long staffId;
    private String staffName;



    //预约项目
    private List<Map<String, Object>> project;

    private String projectName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public List<Map<String, Object>> getProject() {
        return project;
    }

    public void setProject(List<Map<String, Object>> project) {
        this.project = project;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getScheduleEndDate() {
        return scheduleEndDate;
    }

    public void setScheduleEndDate(String scheduleEndDate) {
        this.scheduleEndDate = scheduleEndDate;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }



    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public SchedulexxJson(Schedule data) {
        this.id = data.getId();
        this.storeName = data.getStoreName();
        this.storeId = data.getStoreId();
        this.scheduleDate = DatetimeUtil.formatDatetime(data.getScheduleDate());
        this.scheduleEndDate = DatetimeUtil.formatDatetime(data.getScheduleEndDate());
        this.roomId = data.getRoomId();
        this.roomName = data.getRoom();
        this.customerId = data.getCustomerId();
        this.customerName = data.getCustomer();
        this.staffId = data.getStaffId();
        this.staffName = data.getStaff();
    }
}
