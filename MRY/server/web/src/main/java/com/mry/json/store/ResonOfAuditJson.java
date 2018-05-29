package com.mry.json.store;

/**
 * Created by admin on 2018/2/14.
 */
public class ResonOfAuditJson {

    private Long id;

    //审核状态(1：审核中；2：审核通过;3：注册失败)
    private String auditStatus;

    //失败原因
    private String causeOfFailure;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getCauseOfFailure() {
        return causeOfFailure;
    }

    public void setCauseOfFailure(String causeOfFailure) {
        this.causeOfFailure = causeOfFailure;
    }
}
