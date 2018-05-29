package com.mry.json.store;

/**
 * Created by kaik on 2017/10/27.
 */
public class RoleJson {
    private Long id;

//	//注册店
//	private String storeName;
//
//	//注册店Id
//	private Long storeId;

    //名称
    private String roleName;

    //排序
    private String sort;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public RoleJson(Long id, String roleName, String sort) {
        this.id = id;
        this.roleName = roleName;
        this.sort = sort;
    }
}
