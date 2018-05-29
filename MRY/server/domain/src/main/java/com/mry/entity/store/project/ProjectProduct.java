package com.mry.entity.store.project;

import com.mry.entity.common.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by kaik on 2017/12/1.
 */
@Entity
@Table(name = ProjectProduct.TABLE_NAME)
public class ProjectProduct extends BaseEntity {

    public static final String TABLE_NAME = "project_product";

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private ProjectManagement project;



    //产品名字
    @Column(name = "product_name")
    private String productName;

    //产品id
    @Column(name = "product_id")
    private Long productId;

    //金额
    @Column(name = "money")
    private BigDecimal money;

    //编号
    @Column(name = "code")
    private String code;

    //介绍
    @Column(name = "introduce")
    private String introduce;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public ProjectManagement getProject() {
        return project;
    }

    public void setProject(ProjectManagement project) {
        this.project = project;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
