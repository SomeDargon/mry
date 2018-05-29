package com.mry.enums;

import lombok.Getter;

/**
 * Created by somedragon on 2018/4/11.
 */
@Getter
public enum  ProductEnum implements CodeEnum{

    MEMBERSHIPCARDMANAGEMENT(1, "会员卡", "MembershipCardManagement"),
    EXTENSIONCARDMANAGEMENT(2, "拓客卡", "ExtensionCardManagement"),
    COURSEOFACTIVITYCARD(3, "活动卡", "CourseOfActivityCard"),
    PRODUCTCARDMANAGEMENT(4, "组合疗程卡", "ProductCardManagement"),
    PRODUCT(5, "产品卡", "ProductCardManagement");


    private Integer code;

    private String message;

    private String table;

    ProductEnum(Integer code, String message, String table) {
        this.code = code;
        this.message = message;
        this.table = table;
    }

}
