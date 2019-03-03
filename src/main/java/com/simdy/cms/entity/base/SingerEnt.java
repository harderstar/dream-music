package com.simdy.cms.entity.base;

import java.util.Date;

public class SingerEnt {

    private Integer id;
    private String name;
    private Date birthday;
    private String introduction;
    private Integer hotLevel;

    public SingerEnt(Integer id, String name, Date birthday, String introduction, Integer hotLevel) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.introduction = introduction;
        this.hotLevel = hotLevel;

    }

    public SingerEnt() {
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
