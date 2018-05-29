package com.mry.push.service.message;

import com.mry.cometd.service.message.PushMessageType;

public class PushMessage {
	private PushType pushType;
	private Long hostId;
	private String alert;
	private PushMessageType type;
	private Long entityId;
	private Long customerId;
	private String content;

	public String getAlert() {
		return alert;
	}

	public void setAlert(String alert) {
		this.alert = alert;
	}

	public PushMessageType getType() {
		return type;
	}

	public void setType(PushMessageType type) {
		this.type = type;
	}

	public Long getEntityId() {
		return entityId;
	}

	public void setEntityId(Long id) {
		this.entityId = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public PushType getPushType() {
		return pushType;
	}

	public void setPushType(PushType pushType) {
		this.pushType = pushType;
	}

	public Long getHostId() {
		return hostId;
	}

	public void setHostId(Long hostId) {
		this.hostId = hostId;
	}

	public String getTag() {
		if (PushType.BULLETIN.equals(pushType)) {
			return pushType.getTag();
		} else {
			return pushType.getTag() + hostId;
		}
	}
}
