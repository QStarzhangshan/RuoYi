package com.ruoyi.project.elevator.member.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

public class Member extends BaseEntity {

    private long user_id;
    private long dept_id;
    private String user_name;
    private String email;
    private String phonenumber;

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getDept_id() {
        return dept_id;
    }

    public void setDept_id(long dept_id) {
        this.dept_id = dept_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public String toString() {
        return "Member{" +
                "user_id=" + user_id +
                ", dept_id=" + dept_id +
                ", user_name='" + user_name + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                '}';
    }
}
