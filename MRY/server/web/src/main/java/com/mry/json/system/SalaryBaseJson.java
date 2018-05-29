package com.mry.json.system;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by kaik on 2018/1/19.
 */
@ApiModel(value="底薪查询",description="底薪查询")
public class SalaryBaseJson<T> {


    //
    private Long id;

    private String storeName;

    //注册店Id
    private Long storeId;

    @ApiModelProperty(value="底薪",name="baseSalary")
    private BigDecimal baseSalary;

    //底薪类型(1按月现金总量;2按月客流总量;3按月实操总量;4按月项目总数;5按固定底薪;6按员工级别底薪)
      @ApiModelProperty(value="底薪类型(1按月现金总量;2按月客流总量;3按月实操总量;4按月项目总数;5按固定底薪;6按员工级别底薪)",name="typeOfBaseSalary")
    private String typeOfBaseSalary;

    //    //类型
    @ApiModelProperty(value="类型",name="monthlyCashType")
    private String monthlyCashType;

    private List<T> data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getMonthlyCashType() {
        return monthlyCashType;
    }

    public void setMonthlyCashType(String monthlyCashType) {
        this.monthlyCashType = monthlyCashType;
    }

    public BigDecimal getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(BigDecimal baseSalary) {
        this.baseSalary = baseSalary;
    }

    public String getTypeOfBaseSalary() {
        return typeOfBaseSalary;
    }

    public void setTypeOfBaseSalary(String typeOfBaseSalary) {
        this.typeOfBaseSalary = typeOfBaseSalary;
    }
}
