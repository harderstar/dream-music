package com.simdy.cms.entity.base;

import java.util.Date;

/**
 * @ClassName RegisterEnt
 * @Description TODO
 * @Author simdy
 * @Date 2019/3/24 14:09
 * @Version 1.0
 **/
public class RegisterEnt {

    private Integer id;
    private String name;
    private String password;
    private Integer sex;
    private Date birthday;
    private String phonenumber;
    private Integer downloadSiez;
    private Date lastLoginTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Integer getDownloadSiez() {
        return downloadSiez;
    }

    public void setDownloadSiez(Integer downloadSiez) {
        this.downloadSiez = downloadSiez;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
