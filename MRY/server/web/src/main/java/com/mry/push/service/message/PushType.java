package com.mry.push.service.message;

public enum PushType {
    BULLETIN("bulletin", "/server/system/bulletin"),//
    DOCTOR("message_doctor_", "/doctor/server/message/"),//
    CUSTOMER("message_customer_", "/customer/server/message/");

    private String tag;
    private String channel;

    private PushType(String tag, String channel) {
        this.tag = tag;
        this.channel = channel;
    }

    public String getTag() {
        return tag;
    }

    public String getChannel() {
        return channel;
    }

}
