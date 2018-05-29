package com.mry.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * Created by somedragon on 2018/4/17.
 */
@Data
@ApiModel("員工信息")
public class StaffDTO {
    @ApiParam("编号")
    private Long id;

    @ApiParam("姓名")
    private String realName;

    @ApiParam("性別")
    private String gender;

    @ApiParam("角色")
    private String roleName;

    @ApiParam("角色id")
    private Long roleId;

    @ApiParam("服務名稱")
    private String serviceIntroduction;

}
