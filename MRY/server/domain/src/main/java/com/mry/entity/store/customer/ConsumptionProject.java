package com.mry.entity.store.customer;

import com.mry.entity.common.BaseEntity;

import javax.persistence.*;

/**
 * Created by kaik on 2017/10/20.
 * 消费项目
 */
@Entity
@Table(name = ConsumptionProject.TABLE_NAME)
public class ConsumptionProject extends BaseEntity {

    public static final String TABLE_NAME = "consumption_project";


    //项目id
    @Column(name = "project_id")
    private Long projectId;

    //项目名字
    @Column(name = "project")
    private String project;

    //消费记录
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "consumption_id")
    private RecordsOfConsumption consumption;



}
