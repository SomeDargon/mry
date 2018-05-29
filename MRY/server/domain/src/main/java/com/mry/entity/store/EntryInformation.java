package com.mry.entity.store;

import com.mry.entity.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by kaik on 2017/12/28.
 * 条目信息
 */
@Entity
@Table(name = EntryInformation.TABLE_NAME)
public class EntryInformation extends BaseEntity {

    public static final String TABLE_NAME = "entry_information";

    //注册店
    @Column(name = "store_Name")
    private String storeName;

    //注册店Id
    @Column(name = "store_id")
    private Long storeId;

    //条目名称
    @Column(name = "entry_name")
    private String entryName;

    //条目说明
    @Column(name = "entry_explain")
    private String entryExplain;

    //是否启用
    @Column(name = "is_enable")
    private Boolean isEnable;


    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getEntryName() {
        return entryName;
    }

    public void setEntryName(String entryName) {
        this.entryName = entryName;
    }

    public String getEntryExplain() {
        return entryExplain;
    }

    public void setEntryExplain(String entryExplain) {
        this.entryExplain = entryExplain;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }
}
