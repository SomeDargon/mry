package com.mry.service.helper;

import org.apache.commons.lang.StringUtils;

import com.mry.entity.user.data.UserType;

public final class AuthTokenHelper {
	/**
	 * 
	 * @param authToken
	 * @return
	 */
	public static UserType resolveAuthToken(String authToken) {
		if (StringUtils.isBlank(authToken)) {
			return null;
		}
		if (authToken.endsWith(UserType.CUSTOMER.getSuffix())) {
			return UserType.CUSTOMER;
		} else if (authToken.endsWith(UserType.STAFF.getSuffix())) {
			return UserType.STAFF;
		}

		return null;
	}

}
