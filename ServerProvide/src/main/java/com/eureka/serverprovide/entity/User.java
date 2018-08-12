package com.eureka.serverprovide.entity;

public class User {

    private String UserId;

    private String UserName;

    private String UserSex;

    private String UserAdd;

    private String UserPwd;

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getUserSex() {
        return UserSex;
    }

    public void setUserSex(String UserSex) {
        this.UserSex = UserSex;
    }

    public String getUserAdd() {
        return UserAdd;
    }

    public void setUserAdd(String UserAdd) {
        this.UserAdd = UserAdd;
    }

    public String getUserPwd() {
        return UserPwd;
    }

    public void setUserPwd(String UserPwd) {
        this.UserPwd = UserPwd;
    }
}
