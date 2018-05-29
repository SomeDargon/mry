package com.mry.entity.store.inventory;

import com.mry.entity.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by kaik on 2017/10/23.
 * 仓库管理
 */
@Entity
@Table(name = Warehousing.TABLE_NAME)
public class Warehousing extends BaseEntity {

    public static final String TABLE_NAME = "warehousing";

    //注册店
    @Column(name = "store_Name")
    private String storeName;

    //注册店Id
    @Column(name = "store_id")
    private Long storeId;

    //商品名字
    @Column(name = "name")
    private String name;

    //商品编码
    @Column(name = "code")
    private String code;

    //商品品牌
    @Column(name = "brand")
    private String brand;

    //入库时间
    @Column(name = "storage")
    private Date storage;

    //过期时间
    @Column(name = "expiration")
    private Date expiration;

    //数量
    @Column(name = "quantity")
    private String quantity;

    //实际数量
    @Column(name = "actual_quantity")
    private Integer actualQuantity;

    //入库类型
    @Column(name = "storage_type")
    private String  storageType;

    //状态
    @Column(name = "status")
    private String  status;

    //来源
    @Column(name = "source")
    private String  source;

    //采购价格
    @Column(name = "purchase_price")
    private String  purchasePrice;

    //零售价格
    @Column(name = "retail_price")
    private String  retailPrice	;

    //送货人id
    @Column(name = "delivery_id")
    private Long deliveryId;

    //送货人名字
    @Column(name = "delivery_man")
    private String deliveryMan;

    //送货人id
    @Column(name = "warehouse_id")
    private Long warehouseId;

    //送货人名字
    @Column(name = "warehouse_man")
    private String warehouseMan;

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

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public Date getStorage() {
        return storage;
    }

    public void setStorage(Date storage) {
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

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }
}
