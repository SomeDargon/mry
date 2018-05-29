package com.mry.entity.user;

import com.mry.entity.common.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by kaik on 2017/11/21.
 * 日程预约
 */
@Entity
@Table(name = Schedule.TABLE_NAME)
public class Schedule extends BaseEntity {

    public static final String TABLE_NAME = "schedule";


    //注册店
    @Column(name = "store_Name")
    private String storeName;

    //注册店Id
    @Column(name = "store_id")
    private Long storeId;

    //开始时间
    @Column(name = "schedule_date")
    private Date scheduleDate;
    //结束时间
    @Column(name = "schedule_end_date")
    private Date scheduleEndDate;

    //房间号
    @Column(name = "room")
    private String room;

    //房间号
    @Column(name = "room_id")
    private Long roomId;

    //客户
    @Column(name = "customer_id")
    private Long customerId;

    //客户
    @Column(name = "customer")
    private String customer;

    //员工
    @Column(name = "staff_id")
    private Long staffId;

    //员工
    @Column(name = "staff")
    private String staff;

    //预约项目
    @Column(name = "project_id")
    private String projectId;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    //预约状态(1完成；2：未完成)
    @Column(name = "schedule_status")
    private String scheduleStatus;


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

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public Date getScheduleEndDate() {
        return scheduleEndDate;
    }

    public void setScheduleEndDate(Date scheduleEndDate) {
        this.scheduleEndDate = scheduleEndDate;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }



    public String getScheduleStatus() {
        return scheduleStatus;
    }

    public void setScheduleStatus(String scheduleStatus) {
        this.scheduleStatus = scheduleStatus;
    }
}
