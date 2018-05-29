package com.mry.json.system;

import com.mry.entity.store.card.ProductCardManagement;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by kaik on 2018/1/10.
 */
@Api(description="产品卡管理", value = "产品卡管理")
public class ProductCardListJson {


    //Id
    private Long id;


    //注册店
    @ApiModelProperty(value="注册店",name="storeName")
    private String storeName;

    //注册店Id
    @ApiModelProperty(value="注册店Id",name="storeId")
    private Long storeId;

    //产品卡名称
    @ApiModelProperty(value="产品卡名称",name="productCardName")
    private String productCardName;

    //产品卡金额
    @ApiModelProperty(value="产品卡金额",name="productCardMoney")
    private String productCardMoney;

//    //购买金额
//    @ApiModelProperty(value="购买金额",name="money")
//    private String money;

    //现金金额
    @ApiModelProperty(value="现金金额",name="cashPrice")
    private String cashPrice;

    //卡扣金额
    @ApiModelProperty(value="卡扣金额",name="bucklePrice")
    private String bucklePrice;

    //产品卡有效期(月)
    @ApiModelProperty(value="产品卡有效期(月)",name="productCardValidity")
    private Integer productCardValidity;

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

    public String getProductCardName() {
        return productCardName;
    }

    public void setProductCardName(String productCardName) {
        this.productCardName = productCardName;
    }

    public String getProductCardMoney() {
        return productCardMoney;
    }

    public void setProductCardMoney(String productCardMoney) {
        this.productCardMoney = productCardMoney;
    }

    public String getCashPrice() {
        return cashPrice;
    }

    public void setCashPrice(String cashPrice) {
        this.cashPrice = cashPrice;
    }

    public String getBucklePrice() {
        return bucklePrice;
    }

    public void setBucklePrice(String bucklePrice) {
        this.bucklePrice = bucklePrice;
    }

    public Integer getProductCardValidity() {
        return productCardValidity;
    }

    public void setProductCardValidity(Integer productCardValidity) {
        this.productCardValidity = productCardValidity;
    }

    public ProductCardListJson(ProductCardManagement data) {
        this.id = data.getId();
        this.storeName = data.getStoreName();
        this.storeId = data.getStoreId();
        this.productCardName = data.getProductCardName();
        if(data.getProductCardMoney() != null) {
            this.productCardMoney = data.getProductCardMoney().toString();
        }
        if(data.getCashPrice() != null) {
            this.cashPrice = data.getCashPrice().toString();
        }

        if(data.getBucklePrice() != null) {
            this.bucklePrice = data.getBucklePrice().toString();
        }
        this.productCardValidity = data.getProductCardValidity();
    }
}
