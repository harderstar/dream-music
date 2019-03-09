package com.simdy.cms.entity.base;

import java.util.Date;

public class UserViewEnt {
    private Integer id;
    private String name;
    private String password;
    private String sex;
    private Date birthdate;
    private String sign;
    private String phoneNum;
    private String wechat;
    private String safeQuestion;
    private String safeAnswer;
    private Integer vip;
    private Date lastLoginTime;

    public UserViewEnt(Integer id, String name, String password, String sex, Date birthdate, String sign, String phoneNum, String wechat, String safeQuestion, String safeAnswer, Integer vip, Date lastLoginTime) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.birthdate = birthdate;
        this.sign = sign;
        this.phoneNum = phoneNum;
        this.wechat = wechat;
        this.safeQuestion = safeQuestion;
        this.safeAnswer = safeAnswer;
        this.vip = vip;
        this.lastLoginTime = lastLoginTime;
    }

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getSafeQuestion() {
        return safeQuestion;
    }

    public void setSafeQuestion(String safeQuestion) {
        this.safeQuestion = safeQuestion;
    }

    public String getSafeAnswer() {
        return safeAnswer;
    }

    public void setSafeAnswer(String safeAnswer) {
        this.safeAnswer = safeAnswer;
    }

    public Integer getVip() {
        return vip;
    }

    public void setVip(Integer vip) {
        this.vip = vip;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getLast_login_time() {
        return lastLoginTime;
    }

    public void setLast_login_time(Date last_login_time) {
        this.lastLoginTime = last_login_time;
    }
}
