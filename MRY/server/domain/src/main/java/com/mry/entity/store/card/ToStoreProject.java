package com.mry.entity.store.card;

import com.mry.entity.common.BaseEntity;
import com.mry.entity.store.project.ProjectManagement;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by kaik on 2018/1/11.
 */
@Entity
@Table(name = ToStoreProject.TABLE_NAME)
public class ToStoreProject extends BaseEntity {

    public static final String TABLE_NAME = "to_store_project";


    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "activity_id")
    private ActivityCardManagement activity;
//
//    // 尊享有效期
//    @Column(name = "activity_validity")
//    private Integer activityValidity;

    // 次数
    @Column(name = "activity_number")
    private Integer activityNumber ;

    //项目
    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private ProjectManagement project;

    public ActivityCardManagement getActivity() {
        return activity;
    }

    public void setActivity(ActivityCardManagement activity) {
        this.activity = activity;
    }

    public Integer getActivityNumber() {
        return activityNumber;
    }

    public void setActivityNumber(Integer activityNumber) {
        this.activityNumber = activityNumber;
    }

    public ProjectManagement getProject() {
        return project;
    }

    public void setProject(ProjectManagement project) {
        this.project = project;
    }
}
