package com.mry.cometd.service.message;

public enum PushMessageType {
    SYSTEM_BULLETIN(0),
    MESSAGE(1),
    BULLETIN(2),
    CONSULT(3),
    SCHEDULE(4);

    private Integer code;

    private PushMessageType(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

}
