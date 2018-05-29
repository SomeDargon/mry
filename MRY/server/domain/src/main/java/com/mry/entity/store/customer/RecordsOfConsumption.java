package com.mry.entity.store.customer;

import com.mry.entity.common.BaseEntity;
import javax.persistence.*;
import java.util.List;

/**
 * Created by kaik on 2017/10/20.
 * 消费记录
 */
@Entity
@Table(name = RecordsOfConsumption.TABLE_NAME)
public class RecordsOfConsumption extends BaseEntity {

    public static final String TABLE_NAME = "records_of_consumption";

    //客户id
    @Column(name = "customer_id")
    private Long customerId;

    //客户名字
    @Column(name = "customer")
    private String customer;

    //消费金额
    @Column(name = "amount_of_money")
    private String amountOfMoney;

    //消费时间
    @Column(name = "dissipate")
    private String dissipate;

    //消费门店
    @Column(name = "consumer_stores")
    private String consumerStores;

    //消费门店
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "consumption", fetch = FetchType.LAZY)
    private List<ConsumptionProject> project;

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

    public String getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(String amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public String getDissipate() {
        return dissipate;
    }

    public void setDissipate(String dissipate) {
        this.dissipate = dissipate;
    }

    public String getConsumerStores() {
        return consumerStores;
    }

    public void setConsumerStores(String consumerStores) {
        this.consumerStores = consumerStores;
    }
}
