package com.mry.entity.admin;


import com.mry.entity.common.BaseEntity;

import javax.persistence.*;
import java.util.List;

/**
 * 后台管理账户表
 */
@Entity
@Table(name = "admin_user")
public class AdminUser extends BaseEntity {

	private static final long serialVersionUID = -5387232015662763854L;

	@Column(name = "username", length = 50, unique = true)
	private String username;

	@Column(name = "password", length = 100, nullable = false)
	private String password;

	/**
	 * 用来做伪删除判断（false为已删除）
	 */
	@Column(name = "is_active", nullable = false)
	private boolean isActive;

	//管理员类型 1=系统管理员 2=医学管理员 3=设备管理员 4=市场运营管理员 5=IPC管理员
	@Column(name = "admin_type",nullable = false)
	private Integer adminType;

	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<AdminUserSession> sessions;


	public List<AdminUserSession> getSessions() {
		return sessions;
	}

	public void setSessions(List<AdminUserSession> sessions) {
		this.sessions = sessions;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Integer getAdminType() {
		return adminType;
	}

	public void setAdminType(Integer adminType) {
		this.adminType = adminType;
	}


}
