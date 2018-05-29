package com.mry.entity.store.inventory;

import com.mry.entity.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by kaik on 2017/10/23.
 * 出库记录
 */
@Entity
@Table(name = WarehousingOut.TABLE_NAME)
public class WarehousingOut extends BaseEntity {

    public static final String TABLE_NAME = "warehousing_out";

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

    //出库时间
    @Column(name = "storage")
    private Date storage;



    //数量
    @Column(name = "quantity")
    private String quantity;

    //出库类型
    @Column(name = "storage_type")
    private String  storageType;

    //状态(小库：0：未使用；1：正在使用中；2：耗尽)
    @Column(name = "status")
    private String  status;

    //零售价格
    @Column(name = "retail_price")
    private String  retailPrice	;

    //送货人id
    @Column(name = "delivery_id")
    private Long deliveryId;

    //送货人名字
    @Column(name = "delivery_man")
    private String deliveryMan;

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


    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }
}
