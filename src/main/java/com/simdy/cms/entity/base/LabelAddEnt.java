package com.simdy.cms.entity.base;

import java.io.Serializable;

public class LabelAddEnt implements Serializable {

    private Integer id;
    private String name;
    private Integer isTip;
    private Integer isCash;
    private Integer cashNum;

    public LabelAddEnt() {
    }

    public LabelAddEnt(Integer id, String name, Integer isTip, Integer isCash, Integer cashNum) {
        this.id = id;
        this.name = name;
        this.isTip = isTip;
        this.isCash = isCash;
        this.cashNum = cashNum;
    }

    @Override
    public String toString() {
        return "LabelAddEnt{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isTip=" + isTip +
                ", isCash=" + isCash +
                ", cashNum=" + cashNum +
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

    public Integer getIsTip() {
        return isTip;
    }

    public void setIsTip(Integer isTip) {
        this.isTip = isTip;
    }

    public Integer getIsCash() {
        return isCash;
    }

    public void setIsCash(Integer isCash) {
        this.isCash = isCash;
    }

    public Integer getCashNum() {
        return cashNum;
    }

    public void setCashNum(Integer cashNum) {
        this.cashNum = cashNum;
    }
}
