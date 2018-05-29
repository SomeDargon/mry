package com.mry.security;

import java.nio.ByteBuffer;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;

import com.mry.entity.user.data.UserType;

public class SecureTokenhelper {
	private SecureTokenhelper() {
	}

	public static String createToken(UserType type) {
		String token = UUID.randomUUID().toString();
		if (type == null) {
			return token;
		}
		return token + type.getSuffix();
	}

	public static String createBase64Token() {
		UUID uuid = UUID.randomUUID();
		ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
		bb.putLong(uuid.getMostSignificantBits());
		bb.putLong(uuid.getLeastSignificantBits());
		return Base64.encodeBase64URLSafeString(bb.array());
	}

}
