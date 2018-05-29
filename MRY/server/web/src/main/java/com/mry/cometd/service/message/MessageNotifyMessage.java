package com.mry.cometd.service.message;

import com.mry.push.service.message.PushType;

import java.util.HashMap;
import java.util.Map;

public class MessageNotifyMessage implements NotifyMessage {

    private PushMessageType messageType;
    private String message;
    private Long id;
    private Long customerId;
    private Long hostId;
    private PushType pushType;

    public MessageNotifyMessage() {
    }

    public MessageNotifyMessage(PushType pushType, Long hostId,
                                PushMessageType messageType, String message, Long id) {
        this.pushType = pushType;
        this.messageType = messageType;
        this.message = message;
        this.id = id;
        this.hostId = hostId;
    }

    @Override
    public Map<String, Object> toCometDData() {
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("type", messageType.getCode());

        if (id != null) {
            map.put("id", id);
        }

        map.put("message", message);

        if (customerId != null) {
            map.put("customerId", customerId);
        }

        return map;
    }

    @Override
    public String getChannel() {
        return pushType == PushType.BULLETIN ? pushType.getChannel() : pushType.getChannel() + hostId;
    }

    public PushMessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(PushMessageType messageType) {
        this.messageType = messageType;
    }

    public Long getHostId() {
        return hostId;
    }

    public void setHostId(Long hostId) {
        this.hostId = hostId;
    }

    public PushType getPushType() {
        return pushType;
    }

    public void setPushType(PushType pushType) {
        this.pushType = pushType;
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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
