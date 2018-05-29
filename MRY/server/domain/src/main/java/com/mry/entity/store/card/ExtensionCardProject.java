package com.mry.entity.store.card;

import com.mry.entity.common.BaseEntity;
import com.mry.entity.store.project.ProjectManagement;

import javax.persistence.*;

/**
 * Created by kaik on 2018/1/3.
 * 拓客卡项目
 */
@Entity
@Table(name = ExtensionCardProject.TABLE_NAME)
public class ExtensionCardProject extends BaseEntity {

    public static final String TABLE_NAME = "extension_card_project";



    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "card_id")
    private ExtensionCardManagement card;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "treatment_id")
    private TreatmentCardManagement treatment;

    // 拓客卡有效期
    @Column(name = "extension_validity")
    private Integer extensionValidity;

    // 次数
    @Column(name = "extension_number")
    private Integer extensionNumber ;

    //项目
    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private ProjectManagement project;

    public ExtensionCardManagement getCard() {
        return card;
    }

    public void setCard(ExtensionCardManagement card) {
        this.card = card;
    }

    public Integer getExtensionValidity() {
        return extensionValidity;
    }

    public void setExtensionValidity(Integer extensionValidity) {
        this.extensionValidity = extensionValidity;
    }

    public Integer getExtensionNumber() {
        return extensionNumber;
    }

    public void setExtensionNumber(Integer extensionNumber) {
        this.extensionNumber = extensionNumber;
    }

    public ProjectManagement getProject() {
        return project;
    }

    public void setProject(ProjectManagement project) {
        this.project = project;
    }

    public TreatmentCardManagement getTreatment() {
        return treatment;
    }

    public void setTreatment(TreatmentCardManagement treatment) {
        this.treatment = treatment;
    }
}
