package com.simdy.cms.entity.base;

import java.util.Date;

public class UserListEnt {
    private Integer id;
    private Integer power;
    private Date last_login_time;

    public UserListEnt(Integer id, Integer power, Date last_login_time) {
        this.id = id;
        this.power = power;
        this.last_login_time = last_login_time;
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
