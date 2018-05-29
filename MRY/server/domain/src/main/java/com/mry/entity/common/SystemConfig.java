package com.mry.entity.common;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "system_config")
public class SystemConfig extends BaseEntity {

	private static final long serialVersionUID = 3137909739438395038L;

	@Column(name = "key_val")
	private String key;

	@Column(name = "value_val")
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
