package com.mry.json;

import lombok.Data;

/**
 * Created by kaik on 2017/7/19.
 */
@Data
public class StatusJson {

    private Integer status;
    private String  message;

    public StatusJson() {
    }

    public StatusJson(Integer status, String message) {

        this.status = status;
        this.message = message;
    }
}
