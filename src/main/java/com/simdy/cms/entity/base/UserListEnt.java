package com.simdy.cms.entity.base;

import com.simdy.cms.entity.KeyValueEnt;

import java.io.Serializable;
import java.util.Date;

public class UserListEnt implements Serializable {
    private Integer id;
    private String name;
    private String password;
    private KeyValueEnt vip;
    private Date last_login_time;
    private String phonenumber;
    private Integer downloadSize;

    public UserListEnt() {
    }

    public UserListEnt(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getDownloadSize() {
        return downloadSize;
    }

    public void setDownloadSize(Integer downloadSize) {
        this.downloadSize = downloadSize;
    }

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



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public KeyValueEnt getVip() {
        return vip;
    }

    public void setVip(KeyValueEnt vip) {
        this.vip = vip;
    }

    public Date getLast_login_time() {
        return last_login_time;
    }

    public void setLast_login_time(Date last_login_time) {
        this.last_login_time = last_login_time;
    }

    @Override
    public String toString() {
        return "UserListEnt{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vip=" + vip +
                ", last_login_time=" + last_login_time +
                ", phonenumber='" + phonenumber + '\'' +
                ", downloadSize='" + downloadSize + '\'' +
                '}';
    }
}
