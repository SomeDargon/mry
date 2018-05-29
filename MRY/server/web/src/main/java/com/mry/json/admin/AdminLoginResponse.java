package com.mry.json.admin;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class AdminLoginResponse {
	private String authToken;
	private String username;
	private Integer adminType;

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAdminType() {
		return adminType;
	}

	public void setAdminType(Integer adminType) {
		this.adminType = adminType;
	}
}
