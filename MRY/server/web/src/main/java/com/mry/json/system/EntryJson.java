package com.mry.json.system;

/**
 * Created by kaik on 2017/12/28.
 */
public class EntryJson {


    private Long id;

    //注册店
    private String storeName;

    //注册店Id
    private Long storeId;

    //条目名称
    private String entryName;

    //条目说明
    private String entryExplain;


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


}
