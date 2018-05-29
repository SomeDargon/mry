package com.mry.json.admin;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by zyh on 2017/4/11.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdminUserJson {
    private String username;
    private String userPassWord;
    private Integer adminType;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPassWord() {
        return userPassWord;
    }

    public void setUserPassWord(String userPassWord) {
        this.userPassWord = userPassWord;
    }

    public Integer getAdminType() {
        return adminType;
    }

    public void setAdminType(Integer adminType) {
        this.adminType = adminType;
    }
}
