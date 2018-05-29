package com.mry.entity.store.card;

import com.mry.entity.common.BaseEntity;
import com.mry.entity.store.project.ProjectManagement;

import javax.persistence.*;

/**
 * Created by kaik on 2018/1/3.
 * 会员尊享
 */
@Entity
@Table(name = MembersEnjoy.TABLE_NAME)
public class MembersEnjoy extends BaseEntity {

    public static final String TABLE_NAME = "members_enjoy";

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "card_id")
    private MembershipCardManagement card;

    // 尊享有效期
    @Column(name = "enjoy_validity")
    private String enjoyValidity;

    // 尊享次数
    @Column(name = "enjoy_number")
    private Integer enjoyNumber ;

    //尊享项目
    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private ProjectManagement project;

    // 时效类型
    @Column(name = "aging_type")
    private String agingType;

    public MembershipCardManagement getCard() {
        return card;
    }

    public void setCard(MembershipCardManagement card) {
        this.card = card;
    }

    public String getEnjoyValidity() {
        return enjoyValidity;
    }

    public void setEnjoyValidity(String enjoyValidity) {
        this.enjoyValidity = enjoyValidity;
    }

    public Integer getEnjoyNumber() {
        return enjoyNumber;
    }

    public void setEnjoyNumber(Integer enjoyNumber) {
        this.enjoyNumber = enjoyNumber;
    }

    public ProjectManagement getProject() {
        return project;
    }

    public void setProject(ProjectManagement project) {
        this.project = project;
    }

    public String getAgingType() {
        return agingType;
    }

    public void setAgingType(String agingType) {
        this.agingType = agingType;
    }
}
