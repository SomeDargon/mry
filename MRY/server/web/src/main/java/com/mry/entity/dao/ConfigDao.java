package com.mry.entity.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import com.mry.entity.common.PayConfig;
import com.mry.entity.common.SystemConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@SuppressWarnings("unchecked")
@Repository
public class ConfigDao extends AbstractDao<SystemConfig> {

	private static final Logger logger = LoggerFactory.getLogger(ConfigDao.class);

	private static Map<String, String> PAY_CONFIG_CACHE = null;
	private static Map<String, String> SYSTEM_CONFIG_CACHE = null;
	public static String PAY_PARTNER_KEY = "PARTNER_ID";
	public static String PAY_SECURITY_KEY = "SECURITY_KEY";
	public static String PAY_NOTIFY_URL_KEY = "NOTIFY_URL";
	public static String PAY_RETURN_URL_KEY = "RETURN_URL";
	public static String SELLER_EMAIL_KEY = "SELLER_EMAIL";
	public static String PAY_MOBILE_NOTIFY_URL_KEY = "MOBILE_NOTIFY_URL";
	public static String PAY_PRIVATEL_KEY = "PRIVATE_KEY_KEY";
	public static String PAY_PUBLIC_KEY = "PUBLIC_KEY_KEY";
	public static String PAY_TOP_THREE_NOTIFY_URL_KEY="TOP_THREE_NOTIFY_URL";
	public static String PAY_TOP_THREE_RETURN_URL_KEY="TOP_THREE_RETURN_URL";
	public static String PAY_MOBILE_TOP_THREE_NOTIFY_URL_KEY="MOBILE_TOP_THREE_NOTIFY_URL";

	private static Integer AUTHTOKEN_EXPIRED_HOURS;
	public static final String AUTHTOKEN_EXPIRED_HOURS_KEY = "AUTHTOKEN_EXPIRED_HOURS";
	public static final int AUTHTOKEN_EXPIRED_HOURS_DEFAULT = 24 * 30;

	private static Integer ADMIN_AUTHTOKEN_EXPIRED_HOURS;
	public static final String ADMIN_AUTHTOKEN_EXPIRED_HOURS_KEY = "ADMIN_AUTHTOKEN_EXPIRED_HOURS";
	public static final int ADMIN_AUTHTOKEN_EXPIRED_HOURS_DEFAULT = 24 * 2;

	private static Integer CHECK_SAFE_ANSWER_MAX_TIMES;
	public static final int CHECK_SAFE_ANSWER_MAX_TIMES_DEFAULT = 5;
	public static final String CHECK_SAFE_ANSWER_MAX_TIMES_KEY = "CHECK_SAFE_ANSWER_MAX_TIMES";

	private static Integer MEDICAL_ADVICE_CANCLE_HOURS;
	public static final int MEDICAL_ADVICE_CANCLE_HOURS_DEFAULT = 48;
	public static final String MEDICAL_ADVICE_CANCLE_HOURS_KEY = "MEDICAL_ADVICE_CANCLE_HOURS";

	public static final String FIRST_RECHARGE_GIVE_COIN_KEY = "FIRST_RECHARGE_GIVE_COIN";
	public static final String FIRST_RECHARGE_GIVE_FLOWERS_KEY = "FIRST_RECHARGE_GIVE_FLOWERS";

	private static Integer CONSULT_AUTO_COMMENT_HOURS;
	public static final int CONSULT_AUTO_COMMENT_HOURS_DEFAULT = 168;
	public static final String CONSULT_AUTO_COMMENT_HOURS_KEY = "CONSULT_AUTO_COMMENT_HOURS";

	private static Integer SYSTEM_AUTO_COMMENT_CONSULT_STARS;
	public static final int SYSTEM_AUTO_COMMENT_CONSULT_STARS_DEFAULT = 3;
	public static final String SYSTEM_AUTO_COMMENT_CONSULT_STARS_KEY = "SYSTEM_AUTO_COMMENT_CONSULT_STARS";

	private static Integer NEW_MEDICAL_ADVICE_NOTIFY_DOCTOR_HOURS;
	public static final int NEW_MEDICAL_ADVICE_NOTIFY_DOCTOR_HOURS_DEFAULT = 48;
	public static final String NEW_MEDICAL_ADVICE_NOTIFY_DOCTOR_HOURS_KEY = "NEW_MEDICAL_ADVICE_NOTIFY_DOCTOR_HOURS";

	private static String JPUSH_APP_KEY;
	public static final String JPUSH_APP_KEY_KEY = "JPUSH_APP_KEY";

	private static String JPUSH_MASTER_SECRET;
	public static final String JPUSH_MASTER_SECRET_KEY = "JPUSH_MASTER_SECRET";
	
	//weixin gongzonghao payment config
	private static final String WEIXIN_APP_ID = "WEIXIN_APP_ID";
	private static final String WEIXIN_MCH_ID = "WEIXIN_MCH_ID";
	private static final String WEIXIN_SECRET_KEY = "WEIXIN_SECRET_KEY";
	private static final String WEIXIN_UNIFIED_ORDER_NOTIFY = "WEIXIN_UNIFIED_ORDER_NOTIFY";
	private static final String WEIXIN_APP_SECRET = "WEIXIN_APP_SECRET";

	private void initPayConfig() {
		PAY_CONFIG_CACHE = new HashMap<String, String>();
		List<PayConfig> list = getAllPayConfigs();
		list.forEach(p -> PAY_CONFIG_CACHE.put(p.getKey(), p.getValue()));
	}

	private List<PayConfig> getAllPayConfigs() {
		String queryString = "SELECT p FROM PayConfig p";
		Query query = getEntityManager().createQuery(queryString);
		return query.getResultList();
	}

	private String getPayParam(String key) {
		if (PAY_CONFIG_CACHE == null) {
			initPayConfig();
		}
		return PAY_CONFIG_CACHE.get(key);
	}

	public String getPayMobileNotifyUrl() {
		return getPayParam(PAY_MOBILE_NOTIFY_URL_KEY);
	}

	public String getPayPrivateKey() {
		return getPayParam(PAY_PRIVATEL_KEY);
	}

	public String getPayPublicKey() {
		return getPayParam(PAY_PUBLIC_KEY);
	}

	public String getPayPartner() {
		return getPayParam(PAY_PARTNER_KEY);
	}

	public String getPaySecurityKey() {
		return getPayParam(PAY_SECURITY_KEY);
	}

	public String getPayNotifyUrl() {
		return getPayParam(PAY_NOTIFY_URL_KEY);
	}

	public String getPayTopThreeNotifyUrl(){return getPayParam(PAY_TOP_THREE_NOTIFY_URL_KEY);}

	public String getPayTopThreeReturnUrl() {return getPayParam(PAY_TOP_THREE_RETURN_URL_KEY);}

	public String getPayMobileTopThreeNotifyUrl(){return getPayParam(PAY_MOBILE_TOP_THREE_NOTIFY_URL_KEY);}

	public String getPayReturnUrl() {
		return getPayParam(PAY_RETURN_URL_KEY);
	}

	public String getSellerEmail() {
		return getPayParam(SELLER_EMAIL_KEY);
	}

	public String getWeiXinAppID()
	{
		return getPayParam(WEIXIN_APP_ID);
	}

	public String getWeiMchID()
	{
		return getPayParam(WEIXIN_MCH_ID);
	}

	public String getWeiXinSecretKey()
	{
		return getPayParam(WEIXIN_SECRET_KEY);
	}

	public String getWeiXinUnifiedOrderNotifyURL()
	{
		return getPayParam(WEIXIN_UNIFIED_ORDER_NOTIFY);
	}

	public String getWeiXinAppSecret()
	{
		return getPayParam(WEIXIN_APP_SECRET);
	}
	private void initSystemConfig() {
		SYSTEM_CONFIG_CACHE = new HashMap<String, String>();
		List<SystemConfig> list = getAllSystemConfigs();
		list.forEach(p -> SYSTEM_CONFIG_CACHE.put(p.getKey(), p.getValue()));
	}

	public List<SystemConfig> getAllSystemConfigs() {
		String queryString = "SELECT p FROM SystemConfig p";
		Query query = getEntityManager().createQuery(queryString);
		return query.getResultList();
	}

	public SystemConfig getSystemConfigByKey(String key) {
		String queryString = "SELECT p FROM SystemConfig p WHERE p.key=:key";
		Query query = getEntityManager().createQuery(queryString);
		query.setParameter("key", key);
		List<SystemConfig> configs = query.getResultList();
		if (configs.size() == 0) {
			logger.info("################# Cannot get System configuration for key: " + key);
		}
		return configs.size() == 0 ? null : configs.get(1);
	}

	public String getSystemConfig(String key) {
		if (SYSTEM_CONFIG_CACHE == null) {
			initSystemConfig();
		}
		return SYSTEM_CONFIG_CACHE.get(key);
	}

	public String getSystemConfig(String key, String defaultValue) {
		String value = getSystemConfig(key);
		if (value == null) {
			value = defaultValue;
		}
		return value;
	}

	public Integer getIntSystemConfig(String key, Integer defaultValue) {
		String value = getSystemConfig(key);
		try {
			return Integer.valueOf(value);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	public Double getDoubleSystemConfig(String key, Double defaultValue) {
		String value = getSystemConfig(key);
		try {
			return Double.valueOf(value);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	public int getConfigAuthTokenExpireHours() {
		if (AUTHTOKEN_EXPIRED_HOURS == null) {
			AUTHTOKEN_EXPIRED_HOURS = getIntSystemConfig(AUTHTOKEN_EXPIRED_HOURS_KEY, AUTHTOKEN_EXPIRED_HOURS_DEFAULT);
		}
		return AUTHTOKEN_EXPIRED_HOURS;
	}

	public int getConfigAdminAuthTokenExpireHours() {
		if (ADMIN_AUTHTOKEN_EXPIRED_HOURS == null) {
			ADMIN_AUTHTOKEN_EXPIRED_HOURS = getIntSystemConfig(ADMIN_AUTHTOKEN_EXPIRED_HOURS_KEY,
					ADMIN_AUTHTOKEN_EXPIRED_HOURS_DEFAULT);
		}
		return ADMIN_AUTHTOKEN_EXPIRED_HOURS;
	}

	public int getConfigCheckSafeAnserMaxTimes() {
		if (CHECK_SAFE_ANSWER_MAX_TIMES == null) {
			CHECK_SAFE_ANSWER_MAX_TIMES = getIntSystemConfig(CHECK_SAFE_ANSWER_MAX_TIMES_KEY,
					CHECK_SAFE_ANSWER_MAX_TIMES_DEFAULT);
		}
		return AUTHTOKEN_EXPIRED_HOURS;
	}

	public int getConfigMedicalAdviceCancelHours() {
		if (MEDICAL_ADVICE_CANCLE_HOURS == null) {
			MEDICAL_ADVICE_CANCLE_HOURS = getIntSystemConfig(MEDICAL_ADVICE_CANCLE_HOURS_KEY,
					MEDICAL_ADVICE_CANCLE_HOURS_DEFAULT);
		}
		return MEDICAL_ADVICE_CANCLE_HOURS;
	}

	public int getConfigConsultAutoCommentHours() {
		if (CONSULT_AUTO_COMMENT_HOURS == null) {
			CONSULT_AUTO_COMMENT_HOURS = getIntSystemConfig(CONSULT_AUTO_COMMENT_HOURS_KEY,
					CONSULT_AUTO_COMMENT_HOURS_DEFAULT);
		}
		return CONSULT_AUTO_COMMENT_HOURS;
	}

	public int getConfigAutoCommentConsultStars() {
		if (SYSTEM_AUTO_COMMENT_CONSULT_STARS == null) {
			SYSTEM_AUTO_COMMENT_CONSULT_STARS = getIntSystemConfig(SYSTEM_AUTO_COMMENT_CONSULT_STARS_KEY,
					SYSTEM_AUTO_COMMENT_CONSULT_STARS_DEFAULT);
		}
		return SYSTEM_AUTO_COMMENT_CONSULT_STARS;
	}

	public int getConfigNewConsultNotifyDoctorHours() {
		if (NEW_MEDICAL_ADVICE_NOTIFY_DOCTOR_HOURS == null) {
			NEW_MEDICAL_ADVICE_NOTIFY_DOCTOR_HOURS = getIntSystemConfig(NEW_MEDICAL_ADVICE_NOTIFY_DOCTOR_HOURS_KEY,
					NEW_MEDICAL_ADVICE_NOTIFY_DOCTOR_HOURS_DEFAULT);
		}
		return NEW_MEDICAL_ADVICE_NOTIFY_DOCTOR_HOURS;
	}

	public String getConfigJpushAppKey() {
		if (JPUSH_APP_KEY == null) {
			JPUSH_APP_KEY = getSystemConfig(JPUSH_APP_KEY_KEY);
		}
		return JPUSH_APP_KEY;
	}

	public String getConfigJpushMasterSecret() {
		if (JPUSH_MASTER_SECRET == null) {
			JPUSH_MASTER_SECRET = getSystemConfig(JPUSH_MASTER_SECRET_KEY);
		}
		return JPUSH_MASTER_SECRET;
	}


}
