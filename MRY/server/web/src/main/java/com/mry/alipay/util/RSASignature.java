package com.mry.alipay.util;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RSASignature {
	private static final Logger logger = LoggerFactory.getLogger(RSASignature.class);
	
	private static final String SIGN_ALGORITHMS = "SHA1WithRSA";
	private static final String DEFAULT_CHARSET = "utf-8";
	private static final String DEFAULT_ALGORITHM = "RSA";

	public static String sign(String content, String privateKey) {
		try {
			byte[] keys = DatatypeConverter.parseBase64Binary(privateKey);
			PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(keys);
			KeyFactory keyf = KeyFactory.getInstance(DEFAULT_ALGORITHM);
			PrivateKey priKey = keyf.generatePrivate(priPKCS8);

			java.security.Signature signature = java.security.Signature.getInstance(SIGN_ALGORITHMS);

			signature.initSign(priKey);
			signature.update(content.getBytes(DEFAULT_CHARSET));

			byte[] signed = signature.sign();

			return DatatypeConverter.printBase64Binary(signed);
		} catch (Exception e) {
			logger.warn(e.getMessage(), e);
		}
		return null;
	}

	public static boolean doCheck(String content, String sign, String publicKey) {
		try {
			KeyFactory keyFactory = KeyFactory.getInstance(DEFAULT_ALGORITHM);
			byte[] encodedKey = DatatypeConverter.parseBase64Binary(publicKey);
			PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));

			java.security.Signature signature = java.security.Signature.getInstance(SIGN_ALGORITHMS);

			signature.initVerify(pubKey);
			signature.update(content.getBytes(DEFAULT_CHARSET));

			return signature.verify(DatatypeConverter.parseBase64Binary(sign));
		} catch (Exception e) {
			logger.warn(e.getMessage(), e);
		}
		return false;
	}
}
