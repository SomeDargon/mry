package com.mry.entity.user.data;

import com.mry.entity.user.Customer;
import com.mry.entity.user.CustomerSession;
import com.mry.entity.common.UserSession;
import com.mry.entity.user.Staff;
import com.mry.entity.user.StaffSession;

public enum UserType {
CUSTOMER(CustomerSession.class, Customer.class,"-c"),STAFF(StaffSession.class,Staff.class,"-s");

	private Class<? extends UserSession> sessionClass;
	private Class<?> accountClass;
	private String suffix;

	private UserType(Class<? extends UserSession> sessionClass,
			Class<?> accountClass, String suffix) {
		this.sessionClass = sessionClass;
		this.accountClass = accountClass;
		this.suffix = suffix;

	}

	public Class<? extends UserSession> getSessionClass() {
		return sessionClass;
	}

	public String getSuffix() {
		return suffix;
	}

	public Class<?> getAccountClass() {
		return accountClass;
	}
}
