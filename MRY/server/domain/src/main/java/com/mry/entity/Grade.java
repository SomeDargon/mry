package com.mry.entity;

import com.mry.entity.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by kaik on 2017/10/27.
 * 技术等级
 */
@Entity
@Table(name = Grade.TABLE_NAME)
public class Grade extends BaseEntity {

    public static final String TABLE_NAME = "grade";

    //等级职称
    @Column(name = "grade_name")
    private String gradeName;

    //排序
    @Column(name = "grade_order")
    private String gradeOrder;

    //对应的职位
    @Column(name = "role_name")
    private String roleName;

    //对应的职位
    @Column(name = "role_id")
    private Long roleId;

    //是否启用
    @Column(name = "is_enable")
    private Boolean isEnable;

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getGradeOrder() {
        return gradeOrder;
    }

    public void setGradeOrder(String gradeOrder) {
        this.gradeOrder = gradeOrder;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }
}
