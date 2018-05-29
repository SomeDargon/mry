package com.mry.entity.user;

import com.mry.entity.common.UserSession;

import javax.persistence.*;

/**
 * Created by kaik on 2017/10/18.
 */
@Entity
@Table(name = "staff_session")
public class StaffSession extends UserSession {

    public static final String TOKEN_SUFFIX = "-s";


    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "staff_id")
    private Staff staff;

    /**
     * 是否监护人登录
     */
    @Column(name = "logasguardian", nullable = false)
    private boolean logasguardian;

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public boolean isLogasguardian() {
        return logasguardian;
    }

    public void setLogasguardian(boolean logasguardian) {
        this.logasguardian = logasguardian;
    }
}
