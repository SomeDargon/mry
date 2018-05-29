package com.mry.push.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mry.push.service.message.PushMessage;
import com.mry.push.service.message.PushType;
import com.mry.util.properties.ConfigPropertiesUtil;

import cn.jpush.api.JPushClient;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

public class JPushService {
	private static final Logger logger = LoggerFactory.getLogger(JPushService.class);

	private static final int TIME_TO_LIVE = ConfigPropertiesUtil.getInt("jpush.time.to.live", 300);

	private JPushClient customerClient;
	private JPushClient doctorClient;
	static JPushService service = new JPushService();

	private static ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

	private JPushService() {
		init();
	}

	private void init() {
		String appKey = ConfigPropertiesUtil.getString("CUSTOMER_JPUSH_APP_KEY");
		String masterSecret = ConfigPropertiesUtil.getString("CUSTOMER_JPUSH_MASTER_SECRET");
		logger.info("Init CustomerMembersEnjoy JPush Service with appKey: " + appKey + ", masterSecret: " + masterSecret);

		customerClient = new JPushClient(masterSecret, appKey);

		appKey = ConfigPropertiesUtil.getString("DOCTOR_JPUSH_APP_KEY");
		masterSecret = ConfigPropertiesUtil.getString("DOCTOR_CUSTOMER_JPUSH_MASTER_SECRET");
		logger.info("Init Doctor JPush Service with appKey: " + appKey + ", masterSecret: " + masterSecret);

		doctorClient = new JPushClient(masterSecret, appKey);
	}

	public static JPushService getInstance() {
		return service;
	}

	public void send(PushType pushType, final PushPayload payload) {
		try {
			logger.info("Send " + pushType.name() + " Push Message: " + payload.toString());
			if (PushType.BULLETIN.equals(pushType)) {
				customerClient.sendPush(payload);
				doctorClient.sendPush(payload);
			} else if (PushType.CUSTOMER.equals(pushType)) {
				customerClient.sendPush(payload);
			} else if (PushType.DOCTOR.equals(pushType)) {
				doctorClient.sendPush(payload);
			}
		} catch (Exception e) {
			logger.error("#### JPUSH SEND MESSAGE ERROR: " + e.getMessage());
		}
	}

	public void sendMessage(PushMessage msg) {
		Runnable runnable = new Runnable() {
			public void run() {

				cn.jpush.api.push.model.notification.AndroidNotification.Builder android = AndroidNotification
						.newBuilder().setAlert(msg.getAlert())//
						.addExtra("type", msg.getType().getCode());
				cn.jpush.api.push.model.notification.IosNotification.Builder ios = IosNotification.newBuilder()//
						.setAlert(msg.getAlert())//
						.addExtra("type", msg.getType().getCode());
				if (msg.getEntityId() != null) {
					android.addExtra("id", msg.getEntityId());
					ios.addExtra("id", msg.getEntityId());
				}
				if (msg.getCustomerId() != null) {
					android.addExtra("customerId", msg.getCustomerId());
					ios.addExtra("customerId", msg.getCustomerId());
				}
				if (msg.getContent() != null) {
					android.addExtra("content", msg.getContent());
					ios.addExtra("content", msg.getContent());
				}

				PushPayload payload = generateBuilder()
						.setAudience(Audience.newBuilder().addAudienceTarget(AudienceTarget.tag(msg.getTag())).build())
						.setNotification(Notification.newBuilder().addPlatformNotification(android.build())
								.addPlatformNotification(ios.build()).build())//
						.build();

				send(msg.getPushType(), payload);
			}
		};
		pool.execute(runnable);
	}

	private PushPayload.Builder generateBuilder() {
		return PushPayload.newBuilder().setPlatform(Platform.all())
				.setOptions(Options.newBuilder()//
						.setTimeToLive(TIME_TO_LIVE)//
						// dev env
						.setApnsProduction(false)//
						//.setApnsProduction(true)//
						.build()//
						);
	}
}
