package com.mry.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

@JsonInclude(Include.NON_NULL)
public class CityJson {
	private Long id;
	private String name;
	private Long provinceId;

	public CityJson() {
	}

	public CityJson(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public CityJson(Long id, String name, Long provinceId) {
		this.id = id;
		this.name = name;
		this.provinceId = provinceId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
