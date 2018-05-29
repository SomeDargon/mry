package com.mry.cometd.service.message;

import java.util.Map;

public interface NotifyMessage {

	public Map<String, Object> toCometDData();
	
	public String getChannel();
}
