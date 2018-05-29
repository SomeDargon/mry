package com.mry.entity.user;

import com.mry.entity.common.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by somedragon on 2018/5/18.
 * 请假单
 */
@Entity
@Table(name = LeaveApplication.TABLE_NAME)
@Data
public class LeaveApplication extends BaseEntity {

    public static final String TABLE_NAME = "leave_application";

    @JoinColumn(name = "start_date")
    private Date startDate;

    @JoinColumn(name = "end_date")
    private Date endDate;

    private Integer num;

    @JoinColumn(name = "staff_id")
    private Long staffId;

    private Integer type;

    @JoinColumn(name = "store_id")
    private Long storeId;
}
