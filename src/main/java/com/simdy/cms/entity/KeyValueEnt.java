package com.simdy.cms.entity;

public class KeyValueEnt {

    private Integer entId;
    private String entValue;

    public KeyValueEnt() {
    }

    public KeyValueEnt(Integer entId, String entValue) {
        this.entId = entId;
        this.entValue = entValue;
    }

    public Integer getEntId() {
        return entId;
    }

    public void setEntId(Integer entId) {
        this.entId = entId;
    }

    public String getEntValue() {
        return entValue;
    }

    public void setEntValue(String entValue) {
        this.entValue = entValue;
    }

    @Override
    public String toString() {
        return "KeyValueEnt{" +
                "entId=" + entId +
                ", entValue='" + entValue + '\'' +
                '}';
    }
}
