package com.simdy.cms.entity;

import java.io.Serializable;

public class KeyValueEnt implements Serializable {

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
