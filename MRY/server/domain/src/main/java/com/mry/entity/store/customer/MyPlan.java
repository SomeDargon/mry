package com.mry.entity.store.customer;

import com.mry.entity.common.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by kaik on 2017/12/15.
 */
@Entity
@Table(name = MyPlan.TABLE_NAME)
public class MyPlan  extends BaseEntity {

    public static final String TABLE_NAME = "my_plan";


}
