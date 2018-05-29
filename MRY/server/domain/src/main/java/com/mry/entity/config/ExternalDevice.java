package com.mry.entity.config;


import com.mry.entity.common.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * 外接设备
 *
 * @author vito
 * @version 1.0
 * 创建时间 2016/4/11 10:25
 */
@Entity
@Table(name = ExternalDevice.TABLE_NAME)
public class ExternalDevice extends BaseEntity {
    private static final long serialVersionUID = 3339750217624464276L;

    public static final String TABLE_NAME = "external_device";

    /**
     * 设备编码
     */
    @Column(name = "machine_id", length = 25)
    private String machineId;

    /**
     * 设备网卡MAC
     */
    @Column(name = "mac_addr", length = 25)
    private String macAddr;

    /**
     * 设备接入时间
     */
    @Column(name = "involve_date", nullable = false)
    private Date involveDate;

    /**
     * 设备表述（用来区分是哪个厂家的设备）
     */
    @Column(length = 25, nullable = false)
    private String description;

    /**
     * 设备绑定医生
     */
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "doctor_id")
//    private Doctor doctor;

    /**
     * 是否删除(false为已经删除)
     */
    @Column(name = "is_active")
    private Boolean isActive;

    public String getMachineId() {
        return machineId;
    }

    public void setMachineId(String machineId) {
        this.machineId = machineId;
    }

    public String getMacAddr() {
        return macAddr;
    }

    public void setMacAddr(String macAddr) {
        this.macAddr = macAddr;
    }

    public Date getInvolveDate() {
        return involveDate;
    }

    public void setInvolveDate(Date involveDate) {
        this.involveDate = involveDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

//    public Doctor getDoctor() {
//        return doctor;
//    }
//
//    public void setDoctor(Doctor doctor) {
//        this.doctor = doctor;
//    }
}
