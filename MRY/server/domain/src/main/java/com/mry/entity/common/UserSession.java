package com.mry.entity.common;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public class UserSession extends BaseEntity {

	private static final long serialVersionUID = 2670298499138209690L;

	@Column(name = "auth_token", length = 50)
	private String authToken;

	@Column(name = "start_time", nullable = false)
	private Date startTime;

	/**
	 * 此次登录是否过期
	 */
	@Column(name = "is_expired", nullable = false)
	private boolean isExpired;

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public boolean isExpired() {
		return isExpired;
	}

	public void setExpired(boolean isExpired) {
		this.isExpired = isExpired;
	}
	
}
