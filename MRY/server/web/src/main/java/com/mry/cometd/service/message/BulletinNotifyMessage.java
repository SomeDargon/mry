package com.mry.cometd.service.message;

import java.util.HashMap;
import java.util.Map;

public class BulletinNotifyMessage implements NotifyMessage {
	private static final String CHANNEL = "/server/system/bulletin";
	private String message;
	private Long id;

	public BulletinNotifyMessage() {
	}

	public BulletinNotifyMessage(String message, Long id) {
		super();
		this.message = message;
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Map<String, Object> toCometDData() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("message", message);
		return map;
	}

	@Override
	public String getChannel() {
		return CHANNEL;
	}
}
