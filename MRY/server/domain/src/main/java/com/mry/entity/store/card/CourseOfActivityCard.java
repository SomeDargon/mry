package com.mry.entity.store.card;

import com.mry.entity.common.BaseEntity;

import javax.persistence.*;

/**
 * Created by kaik on 2018/1/11.
 * 活动卡疗程
 */
@Entity
@Table(name = CourseOfActivityCard.TABLE_NAME)
public class CourseOfActivityCard extends BaseEntity {

    public static final String TABLE_NAME = "course_of_activity_card";


    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "activity_id")
    private ActivityCardManagement activity;

    //疗程
    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "treatment_id")
    private TreatmentCardManagement Treatment;


    public ActivityCardManagement getActivity() {
        return activity;
    }

    public void setActivity(ActivityCardManagement activity) {
        this.activity = activity;
    }

    public TreatmentCardManagement getTreatment() {
        return Treatment;
    }

    public void setTreatment(TreatmentCardManagement treatment) {
        Treatment = treatment;
    }
}
