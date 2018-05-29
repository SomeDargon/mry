package com.mry.entity.store.salary;

import com.mry.entity.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by kaik on 2018/1/15.
 * 员工级别底薪
 */
@ApiModel(value="员工级别底薪",description="员工级别底薪")
@Entity
@Table(name = StaffLevelBaseSalary.TABLE_NAME)
public class StaffLevelBaseSalary extends BaseEntity {

    public static final String TABLE_NAME = "staff_level_base_salary";

//    @ManyToOne(fetch= FetchType.LAZY)
//    @JoinColumn(name = "salarySystem_id")
//    private SalarySystem salarySystem;

    //注册店
    @ApiModelProperty(value="注册店",name="storeName")
    @Column(name = "store_Name")
    private String storeName;

    //注册店Id
    @ApiModelProperty(value="注册店Id",name="storeId")
    @Column(name = "store_id")
    private Long storeId;

    //员工类型
    @ApiModelProperty(value="员工类型",name="typeOfEmployee")
    @Column(name = "type_of_employee")
    private String typeOfEmployee;

    //员工级别
    @ApiModelProperty(value="员工级别",name="employeeLevel")
    @Column(name = "employee_level")
    private String employeeLevel;

    //奖励金额
    @ApiModelProperty(value="奖励金额",name="amountOfReward")
    @Column(name = "amount_of_reward")
    private BigDecimal amountOfReward;

    //是否启用
    @ApiModelProperty(value="是否启用",name="disable")
    @Column(name = "disable")
    private Boolean disable;

    //是否注销
    @ApiModelProperty(value="是否注销",name="isEnable")
    @Column(name = "is_enable")
    private Boolean isEnable;

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

    public String getTypeOfEmployee() {
        return typeOfEmployee;
    }

    public void setTypeOfEmployee(String typeOfEmployee) {
        this.typeOfEmployee = typeOfEmployee;
    }

    public String getEmployeeLevel() {
        return employeeLevel;
    }

    public void setEmployeeLevel(String employeeLevel) {
        this.employeeLevel = employeeLevel;
    }

    public BigDecimal getAmountOfReward() {
        return amountOfReward;
    }

    public void setAmountOfReward(BigDecimal amountOfReward) {
        this.amountOfReward = amountOfReward;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }

    public Boolean getDisable() {
        return disable;
    }

    public void setDisable(Boolean disable) {
        this.disable = disable;
    }
}
