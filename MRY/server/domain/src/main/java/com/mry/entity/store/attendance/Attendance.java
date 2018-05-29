package com.mry.entity.store.attendance;

import com.mry.entity.common.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by somedragon on 2018/4/26.
 * 签到表
 */
@Data
@Entity
@Table(name = Attendance.TABLE_NAME)
public class Attendance extends BaseEntity{

    public static final String TABLE_NAME = "attendance";

    @JoinColumn(name = "user_id")
    private Long userId;

    /** 上班时间 */
    @JoinColumn(name = "start_work")
    private Date startWork;

    /** 下班时间 */
    @JoinColumn(name = "end_work")
    private Date endWork;

    /** 标记 0事假 1病假 2出差 3调休 4离职: */
    @JoinColumn(name = "sign")
    private Integer sign;

    /** 门店号 : */
    @JoinColumn(name = "r_id")
    private Long rId;

    /** 创建时间 */
    @JoinColumn(name = "create_date")
    private Date createDate;

    /** 上班补卡标记 0未补卡 1补卡 */
    @JoinColumn(name = "start_status")
    private Integer startStatus;

    /** 下班补卡标记 0未补卡 1补卡*/
    @JoinColumn(name = "end_status")
    private Integer endStatus;

    /** 当天的日期日期 */
    @JoinColumn(name = "current_date")
    private Date currentDate;
}
