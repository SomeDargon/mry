package com.mry.entity.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pay_config")
public class PayConfig extends BaseEntity {
	private static final long serialVersionUID = -4537241801644791670L;

	@Column(name = "key_val")
	private String key;

	@Column(name = "value_val", length = 1024)
	private String value;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
