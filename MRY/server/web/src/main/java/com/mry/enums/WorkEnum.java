package com.mry.enums;

import lombok.Getter;

/**
 * Created by somedragon on 2018/4/26.
 */
@Getter
public enum  WorkEnum  implements CodeEnum{

    FALSE_BU(0, "未补卡"),
    TRUE_BU(1, "补卡"),
            ;

    private Integer code;

    private String message;


    WorkEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}