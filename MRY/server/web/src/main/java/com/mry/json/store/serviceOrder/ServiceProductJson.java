package com.mry.json.store.serviceOrder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mry.entity.StoreManagement;
import com.mry.entity.store.serviceOrders.ServiceProduct;
import com.mry.entity.store.serviceOrders.ServiceProject;

import java.math.BigDecimal;

@JsonInclude(Include.NON_NULL)
public class ServiceProductJson {

	private Long id;

	//产品名字
	private String productName;

	//产品Id
	private Long productId;

	//金额
	private String money;

	//数量
	private Integer number;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public ServiceProduct convert() {
		ServiceProduct s = new ServiceProduct();
		s.setProductId(this.productId);
		s.setProductName(this.productName);
		s.setMoney(new BigDecimal(this.money));
		s.setNumber(this.number);
		return s;

	}

	public ServiceProductJson(ServiceProduct data) {
		this.id = data.getId();
		this.productName = data.getProductName();
		this.productId = data.getProductId();
		this.money = data.getMoney().toString();
		this.number = data.getNumber();
	}
	public ServiceProductJson(){}
}
