package com.mry.alipay.util;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.mry.exception.BusinessException;
import com.mry.exception.ErrorCode;
import com.mry.util.MyUtil;
import com.mry.util.properties.CommonPropertiesUtil;
import com.mry.alipay.config.AlipayConfig;
import com.mry.util.Constants;

public class AlipayApi {

	private static final String TITLE = CommonPropertiesUtil.getString("pay.coin.title");
	private static final String SUBMIT = CommonPropertiesUtil.getString("alipay.submit.btn");

	private static final String SIGN_PARAM_NAME = "sign";
	private static final String PAY_REQUEST_METHOD = "get";
	private static final String SIGN_TYPE = "sign_type=\"RSA\"";

	public static String buildPayRequestResult(BigDecimal fee, String partner, String securityKey, String sellerEmail,
			String out_trade_no, String notify_url, String return_url, String authToken) {
		String payment_type = "1";
		String subject = TITLE;
		String total_fee = MyUtil.moneyScale(fee).toString();
		String body = "";
		String show_url = "";
		String anti_phishing_key = "";
		String exter_invoke_ip = "";

		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("service", "create_direct_pay_by_user");
		sParaTemp.put("partner", partner);
		sParaTemp.put("seller_email", sellerEmail);
		sParaTemp.put("_input_charset", AlipayConfig.input_charset);
		sParaTemp.put("payment_type", payment_type);
		sParaTemp.put("notify_url", notify_url);
		sParaTemp.put("return_url", return_url);
		sParaTemp.put("out_trade_no", out_trade_no);
		sParaTemp.put("subject", subject);
		sParaTemp.put("total_fee", total_fee);
		sParaTemp.put("body", body);
		sParaTemp.put("show_url", show_url);
		sParaTemp.put("anti_phishing_key", anti_phishing_key);
		sParaTemp.put("exter_invoke_ip", exter_invoke_ip);
		sParaTemp.put("sub_order_no", authToken);

		return AlipaySubmit.buildRequest(sParaTemp, PAY_REQUEST_METHOD, SUBMIT, securityKey);
	}

	/**
	 *三甲随访服务包所用支付
	 * @param fee
	 * @param partner
	 * @param securityKey
	 * @param sellerEmail
	 * @param out_trade_no
	 * @param notify_url
	 * @param return_url
     * @param authToken
     * @return
     */
	public static String buildPayTopThreeRequestResult(BigDecimal fee,Long planId,int been, String partner, String securityKey, String sellerEmail,
											   String out_trade_no, String notify_url, String return_url, String authToken) {
		String payment_type = "1";
		String subject = TITLE;
		String total_fee = MyUtil.moneyScale(fee).toString();
		String extra_common_param=been+","+planId+","+fee+","+authToken;
		String body = "";
		String show_url = "";
		String anti_phishing_key = "";
		String exter_invoke_ip = "";

		Map<String, String> sParaTemp = new HashMap<String, String>();
		sParaTemp.put("service", "create_direct_pay_by_user");
		sParaTemp.put("partner", partner);
		sParaTemp.put("seller_email", sellerEmail);
		sParaTemp.put("_input_charset", AlipayConfig.input_charset);
		sParaTemp.put("payment_type", payment_type);
		sParaTemp.put("notify_url", notify_url);
		sParaTemp.put("return_url", return_url);
		sParaTemp.put("out_trade_no", out_trade_no);
		sParaTemp.put("subject", "三甲随访项目");
		sParaTemp.put("total_fee", total_fee);
		sParaTemp.put("body", body);
		sParaTemp.put("extra_common_param", extra_common_param);
		sParaTemp.put("show_url", show_url);
		sParaTemp.put("anti_phishing_key", anti_phishing_key);
		sParaTemp.put("exter_invoke_ip", exter_invoke_ip);
		sParaTemp.put("sub_order_no", authToken);

		return AlipaySubmit.buildRequest(sParaTemp, PAY_REQUEST_METHOD, SUBMIT, securityKey);
	}

	public static String buildMobileRequestParams(String partner, String orderNo, String subject, String body,
			Integer fee, String notifyUrl, String privateKey) {
		try {
			StringBuilder builder = new StringBuilder();
			String param = buildMobileParams(partner, orderNo, subject, body, fee, notifyUrl);
			String sign = RSASignature.sign(param, privateKey);
			sign = URLEncoder.encode(sign, Constants.DEFAULT_ENCODE);
			builder.append(param);
			builder.append("&");
			builder.append(SIGN_PARAM_NAME);
			builder.append("=\"");
			builder.append(sign);
			builder.append("\"&");
			builder.append(SIGN_TYPE);
			return builder.toString();
		} catch (Exception e) {
			throw new BusinessException(ErrorCode.INTERNAL_ERROR);
		}
	}

	private static String buildMobileParams(String partner, String orderNo, String subject, String body, Integer fee,
			String notifyUrl) {
		StringBuilder builder = new StringBuilder();
		builder.append("partner=\"").append(partner).append("\"");
		builder.append("&seller_id=\"").append(partner).append("\"");
		builder.append("&out_trade_no=\"").append(orderNo).append("\"");
		builder.append("&subject=\"").append(subject).append("\"");
		builder.append("&body=\"").append(body).append("\"");
		builder.append("&total_fee=\"").append(fee).append("\"");
		builder.append("&notify_url=\"").append(notifyUrl).append("\"");
		builder.append("&service=\"mobile.securitypay.pay\"");
		builder.append("&payment_type=\"1\"");
		builder.append("&_input_charset=\"utf-8\"");
		builder.append("&it_b_pay=\"30m\"");
		builder.append("&return_url=\"m.alipay.com\"");
		return builder.toString();
	}
}
