package com.ieoli.entity;

public class UserEntity {
    private Integer userid;

    private String username;

    private String userpassword;

    private Integer usertype;

    private Integer rightanswer;

    private Integer wronganswer;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword == null ? null : userpassword.trim();
    }

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    public Integer getRightanswer() {
        return rightanswer;
    }

    public void setRightanswer(Integer rightanswer) {
        this.rightanswer = rightanswer;
    }

    public Integer getWronganswer() {
        return wronganswer;
    }

    public void setWronganswer(Integer wronganswer) {
        this.wronganswer = wronganswer;
    }
}