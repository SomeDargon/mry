package com.mry.entity.admin;


import com.mry.entity.common.UserSession;

import javax.persistence.*;

/**
 * 用来作判断是否已登录
 */
@Entity
@Table(name = "admin_user_session")
public class AdminUserSession extends UserSession {

	private static final long serialVersionUID = 9187317293716378257L;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "admin_user_id")
	private AdminUser admin;

	public AdminUser getAdmin() {
		return admin;
	}

	public void setAdmin(AdminUser admin) {
		this.admin = admin;
	}

}
