package com.mry.entity.store.attendance;

import com.mry.entity.common.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by somedragon on 2018/4/26.
 * 罚金
 */
@Data
@Entity
@Table(name = Fine.TABLE_NAME)
public class Fine extends BaseEntity{

    public static final String TABLE_NAME = "fine";

    /** 创建时间 */
    @JoinColumn(name = "create_date")
    private Date createDate;

    /** 门店编号 */
    @JoinColumn(name = "r_id")
    private Long rId;

    /** 罚金 */
    @JoinColumn(name = "fine")
    private Double fine;

    /** 原因 */
    @JoinColumn(name = "reason")
    private String reason;

    /** 用户编号 */
    @JoinColumn(name = "user_id")
    private Long userId;

    /** 操作人编号 */
    @JoinColumn(name = "edit_user_id")
    private Long editUserId;

}
