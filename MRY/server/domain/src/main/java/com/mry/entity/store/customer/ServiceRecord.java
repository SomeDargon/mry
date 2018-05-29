package com.mry.entity.store.customer;

import com.mry.entity.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by kaik on 2017/10/20.
 * 服务记录
 */
@Entity
@Table(name = ServiceRecord.TABLE_NAME)
public class ServiceRecord extends BaseEntity {

    public static final String TABLE_NAME = "service_record";


    //服务
    @Column(name = "service_name")
    private String serviceName;

    //时间
    @Column(name = "service_time")
    private String aerviceTime;

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
