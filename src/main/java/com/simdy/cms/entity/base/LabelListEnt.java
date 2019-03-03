package com.simdy.cms.entity.base;

public class LabelListEnt {

    private Integer id;
    private String name;
    private Integer isTip;
    private Integer isCash;
    private Integer sourceTimes;

    public LabelListEnt() {
    }

    public LabelListEnt(Integer id, String name, Integer isTip, Integer isCash, Integer sourceTimes) {
        this.id = id;
        this.name = name;
        this.isTip = isTip;
        this.isCash = isCash;
        this.sourceTimes = sourceTimes;
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

    public Integer getSourceTimes() {
        return sourceTimes;
    }

    public void setSourceTimes(Integer sourceTimes) {
        this.sourceTimes = sourceTimes;
    }
}
