package com.mry.enums;

import lombok.Getter;

/**
 * Created by somedragon on 2018/4/26.
 */
@Getter
public enum  AttendanceEnum  implements CodeEnum{

    ON_WORK(1, "上班"),
    DOWN_WORK(2, "下班"),
    BU_START(3, "上班补卡"),
    BU_END(4, "下班补卡")
    ;

    private Integer code;

    private String message;


    AttendanceEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
