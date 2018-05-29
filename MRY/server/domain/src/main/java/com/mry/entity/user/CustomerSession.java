package com.mry.entity.user;

import com.mry.entity.common.UserSession;

import javax.persistence.*;

/**
 * Created by kaik on 2017/8/21.
 */
@Entity
@Table(name = "customer_session")
public class CustomerSession extends UserSession {

    public static final String TOKEN_SUFFIX = "-c";


    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    /**
     * 是否监护人登录
     */
    @Column(name = "logasguardian", nullable = false)
    private boolean logasguardian;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isLogasguardian() {
        return logasguardian;
    }

    public void setLogasguardian(boolean logasguardian) {
        this.logasguardian = logasguardian;
    }
}
