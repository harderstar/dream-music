package com.simdy.cms.entity.base;


import com.fasterxml.jackson.annotation.JsonView;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class UserViewEnt implements Serializable {
    @JsonView(UserSimpleView.class)
    private Integer id;
    @JsonView(UserSimpleView.class)
    private String name;
    @JsonView(UserDetailView.class)
    private String password;
    @JsonView(UserDetailView.class)
    private String sex;
    @JsonView(UserDetailView.class)
    private Date birthdate;
    @JsonView(UserDetailView.class)
    private String sign;
    @JsonView(UserSimpleView.class)
    private String phonenumber;
    @JsonView(UserDetailView.class)
    private String wechat;
    @JsonView(UserDetailView.class)
    private String safeQuestion;
    @JsonView(UserDetailView.class)
    private String safeAnswer;
    @JsonView(UserSimpleView.class)
    private List<VipEnt> vip;
    @JsonView(UserDetailView.class)
    private Date last_login_time;
    @JsonView(UserSimpleView.class)
    private String VAPTCHA;

    public String getVAPTCHA() {
        return VAPTCHA;
    }

    public void setVAPTCHA(String VAPTCHA) {
        this.VAPTCHA = VAPTCHA;
    }

    public interface UserSimpleView {};

    public interface UserDetailView extends  UserSimpleView {};

    public UserViewEnt() {
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


    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
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


    public List<VipEnt> getVip() {
        return vip;
    }

    public void setVip(List<VipEnt> vip) {
        this.vip = vip;
    }


    public Date getLast_login_time() {
        return last_login_time;
    }

    public void setLast_login_time(Date last_login_time) {
        this.last_login_time = last_login_time;
    }
}
