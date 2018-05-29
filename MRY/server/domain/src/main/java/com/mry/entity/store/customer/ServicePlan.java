package com.mry.entity.store.customer;

import com.mry.entity.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by kaik on 2017/10/19.
 * 服务计划
 */
@Entity
@Table(name = ServicePlan.TABLE_NAME)
public class ServicePlan extends BaseEntity {

    public static final String TABLE_NAME = "service_plan";

    //计划
    @Column(name = "plan_name")
    private String planName;

    //时间
    @Column(name = "plan_time")
    private String planTime;

    //客户id
    @Column(name = "customer_id")
    private Long customerId;

    //客户名字
    @Column(name = "customer")
    private String customer;

    //是否启用
    @Column(name = "is_enable")
    private Boolean isEnable;


}
