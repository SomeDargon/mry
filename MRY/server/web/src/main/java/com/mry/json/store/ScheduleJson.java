package com.mry.json.store;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mry.entity.StoreManagement;
import com.mry.entity.user.Schedule;
import com.mry.util.DatetimeUtil;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ScheduleJson {

	private Long id;

	//注册店
	private String storeName;

	//注册店Id
	private Long storeId;

	//开始时间
	private String scheduleDate;
	//结束时间
	private String scheduleEndDate;
	//房间号
	private Long roomId;
	private String roomName;

	//客户
	private Long customerId;
	private String customerName;
	//员工
	private Long staffId;
	private String staffName;
	//预约项目
	private String projectId;

	public ScheduleJson() {
	}

	public ScheduleJson(Schedule data) {
		this.id = data.getId();
		this.storeName = data.getStoreName();
		this.storeId = data.getStoreId();
		this.scheduleDate = DatetimeUtil.formatDate(data.getScheduleDate());
		this.scheduleEndDate = DatetimeUtil.formatDate(data.getScheduleEndDate());
		this.roomId = data.getRoomId();
		this.roomName = data.getRoom();
		this.customerId = data.getCustomerId();
		this.customerName = data.getCustomer();
		this.staffId = data.getStaffId();
		this.staffName = data.getStaff();
//		this.projectId = data.getProjectId();
	}
}
