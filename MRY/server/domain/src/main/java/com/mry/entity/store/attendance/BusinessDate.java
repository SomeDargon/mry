package com.mry.entity.store.attendance;

import com.mry.entity.common.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by somedragon on 2018/5/18.
 * 上班时间设置
 */
@Data
@Entity
@Table(name = Attendance.TABLE_NAME)
public class BusinessDate extends BaseEntity{

    public static final String TABLE_NAME = "business_date";

    private Date date;
}
