package com.mry.json.store;

import com.mry.entity.store.card.Bill;
import com.mry.json.store.serviceOrder.ServiceCardProjectJson;
import com.mry.json.store.serviceOrder.ServiceOrderListJson;
import com.mry.json.store.serviceOrder.ServiceProductListJson;
import com.mry.json.store.serviceOrder.ServiceProjectListJson;
import com.mry.util.DatetimeUtil;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by kaik on 2017/12/8.
 */
public class BillJson {

    private Long id;

    //注册店
    private String storeName;

    //注册店Id
    private Long storeId;


    //客户id
    private Long customerId;

    //客户名字
    private String customer;

    //服务单id
    private Long serviceId;

    //服务单号
    private String serviceOrderNumber;

    //账单类别(0:充值；1：退款：2：消费；3：提现)
    private String billType;

   //支付方式（0：现金；1：储蓄卡；2：银联卡；3：支付宝；4：微信）
    private String paymentMethod;

    //支付金额
    private BigDecimal zfmoney;
    //总金额
    private BigDecimal money;
    //卡扣金额
    private BigDecimal kkmoney;

    //时间
    private String billTime;

    //创建时间
    private String createTime;

    //技师姓名
    private String operatorName;

    //指定/非指定
    private String appoint;

    //服务房间
    private String serviceRoom;

    private String preSale;


    //项目
    private List<ServiceProjectListJson> project;

    //项目
    private List<ServiceCardProjectJson> cardProject;

    // 产品
    private List<ServiceProductListJson>  product;

   // private ServiceOrderListJson serviceOrderListJson;



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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceOrderNumber() {
        return serviceOrderNumber;
    }

    public void setServiceOrderNumber(String serviceOrderNumber) {
        this.serviceOrderNumber = serviceOrderNumber;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public BigDecimal getZfmoney() {
        return zfmoney;
    }

    public void setZfmoney(BigDecimal zfmoney) {
        this.zfmoney = zfmoney;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getKkmoney() {
        return kkmoney;
    }

    public void setKkmoney(BigDecimal kkmoney) {
        this.kkmoney = kkmoney;
    }

    public String getBillTime() {
        return billTime;
    }

    public void setBillTime(String billTime) {
        this.billTime = billTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getAppoint() {
        return appoint;
    }

    public void setAppoint(String appoint) {
        this.appoint = appoint;
    }

    public String getServiceRoom() {
        return serviceRoom;
    }

    public void setServiceRoom(String serviceRoom) {
        this.serviceRoom = serviceRoom;
    }

    public String getPreSale() {
        return preSale;
    }

    public void setPreSale(String preSale) {
        this.preSale = preSale;
    }

    public List<ServiceProjectListJson> getProject() {
        return project;
    }

    public void setProject(List<ServiceProjectListJson> project) {
        this.project = project;
    }

    public List<ServiceCardProjectJson> getCardProject() {
        return cardProject;
    }

    public void setCardProject(List<ServiceCardProjectJson> cardProject) {
        this.cardProject = cardProject;
    }

    public List<ServiceProductListJson> getProduct() {
        return product;
    }

    public void setProduct(List<ServiceProductListJson> product) {
        this.product = product;
    }

    public BillJson(Bill data) {
        this.id = data.getId();
        this.storeName = data.getStoreName();
        this.storeId = data.getStoreId();
        this.customerId = data.getCustomerId();
        this.customer = data.getCustomer();
        this.serviceId = data.getServiceId();
        this.serviceOrderNumber = data.getServiceOrderNumber();
        this.billType = data.getBillType();
        this.zfmoney = data.getZfmoney();
        this.money = data.getMoney();
        this.kkmoney = data.getKkmoney();
        this.billTime = DatetimeUtil.formatDate(data.getBillTime());
        this.paymentMethod = data.getPaymentMethod();
    }
}
