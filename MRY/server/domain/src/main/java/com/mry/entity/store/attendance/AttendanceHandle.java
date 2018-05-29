package com.mry.entity.store.attendance;

import com.mry.entity.common.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by somedragon on 2018/4/26.
 * 申请表
 */
@Data
@Entity
@Table(name = AttendanceHandle.TABLE_NAME)
public class AttendanceHandle extends BaseEntity {

    public static final String TABLE_NAME = "attendance_handle";

    /** 标记 0事假 1病假 2出差 3调休 4离职 5罚金*/
    @JoinColumn(name = "type")
    private Integer type;

    /** 开始时间 */
    @JoinColumn(name = "start_date")
    private Date startDate;

    /** 结束时间 */
    @JoinColumn(name = "end_date")
    private Date endDate;

    /** 门店编号 */
    @JoinColumn(name = "r_id")
    private Long rId;

    /** 创建时间 */
    @JoinColumn(name = "create_date")
    private Date createDate;
}
