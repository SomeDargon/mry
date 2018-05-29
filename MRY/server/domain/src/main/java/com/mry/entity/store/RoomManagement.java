package com.mry.entity.store;

import com.mry.entity.common.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by kaik on 2017/10/20.
 * 房间管理
 */
@Entity
@Table(name = RoomManagement.TABLE_NAME)
public class RoomManagement  extends BaseEntity {

    public static final String TABLE_NAME = "room_management";

    //房间名称
    @Column(name = "room_name")
    private String roomName;

    //房间号
    @Column(name = "room_number")
    private String roomNumber;

    //房间状态(0:空闲；1服务中；2：维修)
    @Column(name = "room_status")
    private String roomStatus;

    //注册店
    @Column(name = "store_Name")
    private String storeName;

    //注册店Id
    @Column(name = "store_id")
    private Long storeId;

    //是否启用
    @Column(name = "is_enable")
    private Boolean isEnable;

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

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }
}
