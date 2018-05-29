package com.mry.json.store;

import com.mry.entity.store.inventory.Warehousing;
import com.mry.util.DatetimeUtil;

/**
 * Created by kaik on 2017/11/24.
 */
public class WarehousingListJson {
    private Long id;
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

    //入库时间
    private String storage;

    //过期时间
    private String expiration;

    //数量
    private String quantity;
    //实际数量
    private Integer actualQuantity;

    //入库类型
    private String  storageType;

    //状态
    private String  status;

    //来源
    private String  source;

    //采购价格
    private String  purchasePrice;

    //零售价格
    private String  retailPrice	;

    //送货人id
    private Long deliveryId;

    //送货人名字
    private String deliveryMan;

    //送货人id
    private Long warehouseId;

    //送货人名字
    private String warehouseMan;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(String purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(String retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getDeliveryMan() {
        return deliveryMan;
    }

    public void setDeliveryMan(String deliveryMan) {
        this.deliveryMan = deliveryMan;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseMan() {
        return warehouseMan;
    }

    public void setWarehouseMan(String warehouseMan) {
        this.warehouseMan = warehouseMan;
    }

    public Integer getActualQuantity() {
        return actualQuantity;
    }

    public void setActualQuantity(Integer actualQuantity) {
        this.actualQuantity = actualQuantity;
    }

    public WarehousingListJson(Warehousing data) {
        this.id = data.getId();
        this.storeName = data.getStoreName();
        this.storeId = data.getStoreId();
        this.name = data.getName();
        this.code = data.getCode();
        this.brand = data.getBrand();
        this.storage = DatetimeUtil.formatDate(data.getStorage());
        this.expiration = data.getBrand();
        this.quantity = data.getQuantity();
        this.storageType = data.getStorageType();
        this.status = data.getStatus();
        this.source = data.getSource();
        this.purchasePrice = data.getPurchasePrice();
        this.retailPrice = data.getRetailPrice();
        this.deliveryId = data.getDeliveryId();
        this.deliveryMan = data.getDeliveryMan();
        this.warehouseId = data.getWarehouseId();
        this.warehouseMan = data.getWarehouseMan();
        this.actualQuantity = data.getActualQuantity();
    }
}
