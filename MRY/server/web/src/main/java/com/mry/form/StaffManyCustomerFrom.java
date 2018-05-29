package com.mry.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by somedragon on 2018/4/17.
 */
@Data
@ApiModel("指定技师或者店长指定")
public class StaffManyCustomerFrom {

    @ApiModelProperty(value = "指定人的id")
    private Long customerId;

    @ApiModelProperty(value = "门店编号")
    private long storeId;

    @ApiModelProperty(value = "0:用户指定技师 1：店长指定技师")
    private Integer type;

    @ApiModelProperty(value = "被指定人的id")
    private Long staffId;
}
