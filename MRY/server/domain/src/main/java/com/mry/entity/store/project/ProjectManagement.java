package com.mry.entity.store.project;

import com.mry.entity.common.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by kaik on 2017/10/23.
 * 项目管理
 */
@Entity
@Table(name = ProjectManagement.TABLE_NAME)
@Data
public class ProjectManagement extends BaseEntity {

    public static final String TABLE_NAME = "project_management";

    //注册店
    @Column(name = "store_Name")
    private String storeName;

    //注册店Id
    @Column(name = "store_id")
    private Long storeId;

    //名字
    @Column(name = "project_name")
    private String projectName;

    //现金金额  现金疗程价
    @Column(name = "cash_money")
    private BigDecimal cashMoney;
    //疗程金额  单价
    @Column(name = "course_money")
    private BigDecimal courseMoney;
    //卡扣金额  卡扣疗程价
    @Column(name = "buckle_money")
    private BigDecimal buckleMoney;
    //体验金额 体验价
    @Column(name = "experience_money")
    private BigDecimal experienceMoney;

    //是否收填(0是；1不是)
    @Column(name = "is_calculate")
    private String isCalculate;


    //编号
    @Column(name = "code")
    private String code;

    //效果  解决症状问题（和顾客症状关联）
    @Column(name = "effect")
    private String effect;

    //项目专业说明（项目原理、专业）
    @Column(name = "project_description")
    private String projectDescription;

    //项目操作技术要点（和员工管理技术管理关联）
    @Column(name = "technicalPoints")
    private String technicalPoints;

    //可搭配项目和搭配后解决问题（和疗程组合设计关联）
    @Column(name = "collocation_items")
    private String collocationItems;

    //类型 项目类别（身体类、面护类）
    @Column(name = "type")
    private String type;

    //项目属性（到店率、功效类、保养类）
    @Column(name = "project_attributes")
    private String projectAttributes;

    //次数
    @Column(name = "frequency")
    private String frequency;

    //间隔
    @Column(name = "interval_time")
    private String intervalTime;

    //操作人
    @Column(name = "operator")
    private String operator;

    // 操作人Id
    @Column(name = "operator_id")
    private Long operatorId;

    //  操作时间
    @Column(name = "operator_time")
    private String operatorTime;

    //  修改人
    @Column(name = "update_people")
    private String updatePeople;

    //  修改人Id
    @Column(name = "update_people_id")
    private Long updatePeopleId;

    //  操作时间
    @Column(name = "modifier_time")
    private String modifierTime;

    //项目
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project", fetch = FetchType.LAZY)
    private List<ProjectProduct> product;

    //是否启用
    @Column(name = "is_enable")
    private Boolean isEnable;

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }
}
