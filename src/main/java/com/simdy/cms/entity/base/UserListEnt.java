package com.simdy.cms.entity.base;

import java.util.Date;

public class UserListEnt {
    private Integer id;
    private String name;
    private Integer power;
    private Date last_login_time;
    private String phonenumber;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public UserListEnt(String name,String phonenumber,Integer id, Integer power, Date last_login_time) {
        this.id = id;
        this.power = power;
        this.last_login_time = last_login_time;
        this.phonenumber = phonenumber;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Date getLast_login_time() {
        return last_login_time;
    }

    public void setLast_login_time(Date last_login_time) {
        this.last_login_time = last_login_time;
    }
}
