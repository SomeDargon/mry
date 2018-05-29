package com.mry.entity.store.card;

import com.mry.entity.common.BaseEntity;
import com.mry.entity.store.project.ProjectManagement;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by kaik on 2018/1/11.
 * 特价秒杀
 */
@Entity
@Table(name = SpecialSecondKill.TABLE_NAME)
public class SpecialSecondKill extends BaseEntity {

    public static final String TABLE_NAME = "special_second_kill";


    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "card_id")
    private ActivityCardManagement activity;

    //特价金额
    @Column(name = "special_money")
    private BigDecimal specialMoney;


    // 套数次数
    @Column(name = "special_number")
    private Integer specialNumber ;

    //特价项目
    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private ProjectManagement project;

    public ActivityCardManagement getActivity() {
        return activity;
    }

    public void setActivity(ActivityCardManagement activity) {
        this.activity = activity;
    }

    public BigDecimal getSpecialMoney() {
        return specialMoney;
    }

    public void setSpecialMoney(BigDecimal specialMoney) {
        this.specialMoney = specialMoney;
    }

    public Integer getSpecialNumber() {
        return specialNumber;
    }

    public void setSpecialNumber(Integer specialNumber) {
        this.specialNumber = specialNumber;
    }

    public ProjectManagement getProject() {
        return project;
    }

    public void setProject(ProjectManagement project) {
        this.project = project;
    }
}
