package com.simdy.cms.entity.base;

import java.io.Serializable;
import java.util.Date;

public class SingerEnt implements Serializable {

    private Integer id;
    private String name;
    private Date birthday;
    private String sex;
    private String introduction;
    private Integer hotLevel;

    public SingerEnt(Integer id, String name, Date birthday, String sex, String introduction, Integer hotLevel) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.introduction = introduction;
        this.hotLevel = hotLevel;
    }

    public SingerEnt() {
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "SingerEnt{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", introduction='" + introduction + '\'' +
                ", hotLevel=" + hotLevel +
                '}';
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Integer getHotLevel() {
        return hotLevel;
    }

    public void setHotLevel(Integer hotLevel) {
        this.hotLevel = hotLevel;
    }
}
