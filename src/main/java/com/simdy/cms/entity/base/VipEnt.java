package com.simdy.cms.entity.base;

import java.io.Serializable;

public class VipEnt implements Serializable {

    private Integer id;
    private String name;
    private Integer isBase;
    private Integer downloadSize;
    private Integer fee;
    private Integer isComtent;

    public VipEnt() {
    }

    @Override
    public String toString() {
        return "VipEnt{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isBase=" + isBase +
                ", downloadSize=" + downloadSize +
                ", fee=" + fee +
                ", isComtent=" + isComtent +
                '}';
    }

    public VipEnt(Integer id, String name, Integer isBase, Integer downloadSize, Integer fee, Integer isComtent) {
        this.id = id;
        this.name = name;
        this.isBase = isBase;
        this.downloadSize = downloadSize;
        this.fee = fee;
        this.isComtent = isComtent;
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

    public Integer getIsBase() {
        return isBase;
    }

    public void setIsBase(Integer isBase) {
        this.isBase = isBase;
    }

    public Integer getDownloadSize() {
        return downloadSize;
    }

    public void setDownloadSize(Integer downloadSize) {
        this.downloadSize = downloadSize;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    public Integer getIsComtent() {
        return isComtent;
    }

    public void setIsComtent(Integer isComtent) {
        this.isComtent = isComtent;
    }
}
