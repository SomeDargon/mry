package com.mry.json.store;

/**
 * Created by kaik on 2017/10/27.
 */
public class QuitJson {

    private Long id;

    //离职原因
    private String reason;

    //离职时间
    private String quitTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getQuitTime() {
        return quitTime;
    }

    public void setQuitTime(String quitTime) {
        this.quitTime = quitTime;
    }
}
