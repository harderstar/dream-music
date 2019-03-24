package com.simdy.cms.entity.base;

public class LabelListEnt {

    private Integer id;
    private String name;
    private Integer isTip;
    private Integer isCash;
    private Integer searchTimes;

    public LabelListEnt() {
    }

    public LabelListEnt(Integer id, String name, Integer isTip, Integer isCash, Integer searchTimes) {
        this.id = id;
        this.name = name;
        this.isTip = isTip;
        this.isCash = isCash;
        this.searchTimes = searchTimes;
    }

    @Override
    public String toString() {
        return "LabelListEnt{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isTip=" + isTip +
                ", isCash=" + isCash +
                ", sourceTimes=" + searchTimes +
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

    public Integer getSearchTimes() {
        return searchTimes;
    }

    public void setSearchTimes(Integer searchTimes) {
        this.searchTimes = searchTimes;
    }
}
