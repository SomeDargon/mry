package com.mry.json.store;

import com.mry.entity.store.inventory.WarehousingOut;
import com.mry.util.DatetimeUtil;

/**
 * Created by kaik on 2017/11/24.
 */
public class WarehousingOutJson {

    //注册店
    private String storeName;

    //注册店Id
    private Long storeId;

    //商品名字
    private String name;

    //商品编码
    private String code;

    //商品品牌
    private String brand;

    //出库时间
    private String storage;

    //数量
    private String quantity;

    //出库类型（0"销售；2转小库）
    private String  storageType;

    //状态(小库：0：未使用；1：正在使用中；2：耗尽)
    private String  status;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public WarehousingOutJson(WarehousingOut data) {
        this.storeName = data.getStoreName();
        this.storeId = data.getStoreId();
        this.name = data.getName();
        this.code = data.getCode();
        this.brand = data.getBrand();
        this.storage = DatetimeUtil.formatDate(data.getStorage());
        this.quantity = data.getQuantity();
        this.storageType = data.getStorageType();
        this.status = data.getStatus();
    }
}
