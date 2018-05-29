package com.mry.json.store;

import com.mry.entity.store.RoomManagement;

/**
 * Created by kaik on 2017/12/7.
 */
public class RoomListJson {
    private Long id;
    //房间名称
    private String roomName;

    //房间号
    private String roomNumber;

    //房间状态
    private String roomStatus;

    //注册店
    private String storeName;

    //注册店Id
    private Long storeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public RoomListJson(RoomManagement data) {
        this.id = data.getId();
        this.roomName = data.getRoomName();
        this.roomNumber = data.getRoomNumber();
        this.roomStatus = data.getRoomStatus();
        this.storeName = data.getStoreName();
        this.storeId = data.getStoreId();
    }
}
