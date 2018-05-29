package com.mry.json.system;

/**
 * Created by kaik on 2017/12/28.
 */
public class EntryListJson {


    private Long id;

    //条目名称
    private String entryName;

    //条目说明
    private String entryExplain;

    //注册店
    private String storeName;

    //注册店Id
    private Long storeId;

    public String getEntryName() {
        return entryName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public EntryListJson(Long id, String entryName, String entryExplain, String storeName, Long storeId) {
        this.id = id;
        this.entryName = entryName;
        this.entryExplain = entryExplain;
        this.storeName = storeName;
        this.storeId = storeId;
    }
}
