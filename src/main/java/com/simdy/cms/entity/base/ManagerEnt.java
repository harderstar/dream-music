package com.simdy.cms.entity.base;

import java.util.Date;

public class ManagerEnt {

    private Integer id;
    private String username;
    private String password;
    private Date lastLogin;

    public ManagerEnt() {
    }

    public ManagerEnt(Integer id, String username, String password, Date lastLogin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.lastLogin = lastLogin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
}