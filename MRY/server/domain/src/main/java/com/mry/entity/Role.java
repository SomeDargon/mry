package com.mry.entity;

import com.mry.entity.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by kaik on 2017/10/18.
 * 角色（职位）
 */
@Entity
@Table(name = Role.TABLE_NAME)
public class Role extends BaseEntity {

    public static final String TABLE_NAME = "role";

//
//    //注册店
//    @Column(name = "store_Name")
//    private String storeName;
//
//    //注册店Id
//    @Column(name = "store_id")
//    private Long storeId;

    //名称
    @Column(name = "role_name")
    private String roleName;

    //排序
    @Column(name = "sort")
    private String sort;

    //是否启用
    @Column(name = "is_enable")
    private Boolean isEnable;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }
}
