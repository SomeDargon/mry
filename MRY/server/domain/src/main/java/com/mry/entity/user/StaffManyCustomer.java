package com.mry.entity.user;

import com.mry.entity.common.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by somedragon on 2018/4/17.
 */
@Data
@Entity
@Table(name = StaffManyCustomer.TABLE_NAME)
public class StaffManyCustomer extends BaseEntity {

    public static final String TABLE_NAME = "staff_many_customer";

    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "staff_id")
    private Long staffId;

    /** 0：用户指定店长 1：店长指定技师 */
    @Column(name = "type")
    private Integer type;


}
