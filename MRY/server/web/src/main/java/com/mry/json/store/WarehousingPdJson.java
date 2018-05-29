package com.mry.json.store;

import com.mry.entity.store.inventory.Warehousing;

/**
 * Created by kaik on 2017/11/24.
 */
public class WarehousingPdJson {


    //注册店Id
    private Long storeId;

    //商品名字
    private String name;

    //实际数量
    private Long actualQuantity;

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

    public Long getActualQuantity() {
        return actualQuantity;
    }

    public void setActualQuantity(Long actualQuantity) {
        this.actualQuantity = actualQuantity;
    }

//    public WarehousingPdJson(Warehousing data) {
//        this.storeId = data.getStoreId();
//        this.name = data.getName();
//        this.actualQuantity = data.getActualQuantity();
//    }

    public WarehousingPdJson(Long storeId, String name, Long actualQuantity) {
        this.storeId = storeId;
        this.name = name;
        this.actualQuantity = actualQuantity;
    }
}
