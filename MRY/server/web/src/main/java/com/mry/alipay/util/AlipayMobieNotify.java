package com.mry.alipay.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mry.alipay.config.AlipayConfig;

public class AlipayMobieNotify {
	private static final Logger logger = LoggerFactory.getLogger(AlipayMobieNotify.class);

	
	private static final String HTTPS_VERIFY_URL = "https://mapi.alipay.com/gateway.do?service=notify_verify&";

	public static boolean verify(Map<String, String> params, String publicKey, String partner) {

		String responseTxt = AlipayConfig.TRUE;
		if (params.get("notify_id") != null) {
			String notify_id = params.get("notify_id");
			responseTxt = verifyResponse(notify_id, partner);
		}
		String sign = "";
		if (params.get("sign") != null) {
			sign = params.get("sign");
		}
		boolean isSign = getSignVeryfy(params, sign, publicKey);

		String sWord = "responseTxt=" + responseTxt + "\nisSign=" + isSign + "\nReturn parameters:"
				+ AlipayCore.createLinkString(params);
		logger.info("Verify data: " + sWord);

		return isSign && AlipayConfig.TRUE.equals(responseTxt);
	}

	private static boolean getSignVeryfy(Map<String, String> Params, String sign, String publicKey) {
		Map<String, String> sParaNew = AlipayCore.paraFilter(Params);
		String preSignStr = AlipayCore.createLinkString(sParaNew);

		return RSASignature.doCheck(preSignStr, sign, publicKey);
	}

	private static String verifyResponse(String notify_id, String partner) {
		String veryfy_url = HTTPS_VERIFY_URL + "partner=" + partner + "&notify_id=" + notify_id;

		return checkUrl(veryfy_url);
	}

	private static String checkUrl(String urlvalue) {
		String inputLine = "";

		try {
			URL url = new URL(urlvalue);
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			inputLine = in.readLine().toString();
		} catch (Exception e) {
			e.printStackTrace();
			inputLine = "";
		}

		return inputLine;
	}
	
	public static void main(String[] args){
		String s = "body=User Recharge&buyer_email=735556259@qq.com&buyer_id=2088302420787184&discount=0.00&gmt_create=2016-03-09 14:10:46&gmt_payment=2016-03-09 14:10:47&is_total_fee_adjust=N&notify_id=44d972edb37b1e3448a97e9e95312a8he2&notify_time=2016-03-09 14:34:28&notify_type=trade_status_sync&out_trade_no=18565393310876270_57&payment_type=1&price=10.00&quantity=1&seller_email=liang.guo@uyidoctor.com&seller_id=2088911953652335&sign=DL4fKK/8+vu5BMBgY/4rjlWJWgNZYH1KdHDrA/4e5KDgp4dhxQnO/BLNfSo823ZPLALGvsNdxZvG/lNf9wOeLXZPRPBxsy/RLmV5tYFw4lXtSU7F4BeboENolzy4u8H7wBmVdT5WRG31KWBGZ5N6b0zj8Vc6B/nAonD8h6EQito=&sign_type=RSA&subject=User Recharge&total_fee=10.00&trade_no=2016030921001004180226834402&trade_status=TRADE_SUCCESS&use_coupon=N";
	
		String[] ss = s.split("&");
		Map<String, String> params = new HashMap<String, String>();
		for(String p: ss){
			String[] pp = p.split("=");
			params.put(pp[0], pp[1]);
		}
		
		params.put("sign", "DL4fKK/8+vu5BMBgY/4rjlWJWgNZYH1KdHDrA/4e5KDgp4dhxQnO/BLNfSo823ZPLALGvsNdxZvG/lNf9wOeLXZPRPBxsy/RLmV5tYFw4lXtSU7F4BeboENolzy4u8H7wBmVdT5WRG31KWBGZ5N6b0zj8Vc6B/nAonD8h6EQito=");
		
		String partner = "2088911953652335";
		String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";
		
		boolean b = verify(params, publicKey, partner);
		System.out.println(b);
	}
}
