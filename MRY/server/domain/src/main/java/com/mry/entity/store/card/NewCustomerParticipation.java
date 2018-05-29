package com.mry.entity.store.card;

import com.mry.entity.common.BaseEntity;
import com.mry.entity.store.project.ProjectManagement;

import javax.persistence.*;

/**
 * Created by kaik on 2018/1/30.
 */
@Entity
@Table(name = NewCustomerParticipation.TABLE_NAME)
public class NewCustomerParticipation  extends BaseEntity {

    public static final String TABLE_NAME = "new_customer_participation";


    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "activity_id")
    private ActivityCardManagement activity;

    // 尊享有效期
    @Column(name = "activity_validity")
    private Integer activityValidity;

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

    public Integer getActivityValidity() {
        return activityValidity;
    }

    public void setActivityValidity(Integer activityValidity) {
        this.activityValidity = activityValidity;
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
