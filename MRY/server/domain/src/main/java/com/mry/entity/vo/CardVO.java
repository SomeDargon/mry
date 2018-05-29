package com.mry.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by somedragon on 2018/4/11.
 */
@ApiModel("用户添加卡的Form框")
@Data
public class CardVO {


    @ApiModelProperty(value = "卡标号")
    private Long cardId;

    @ApiModelProperty(value = "用户编号")
    private Long userId;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = " 1:会员卡 2:拓客卡 3:疗程卡 4:组合疗程卡0:产品卡")
    private Integer type;

    @ApiModelProperty(value = "备注")
    private String bz;

    @ApiModelProperty(value = "卡名")
    private String cardName;



}
