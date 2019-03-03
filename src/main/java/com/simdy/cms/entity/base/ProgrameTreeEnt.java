package com.simdy.cms.entity.base;

public class ProgrameTreeEnt {

    private String id;
    private String value;
    private String parentId;

    public ProgrameTreeEnt(String id, String value, String parentId) {
        this.id = id;
        this.value = value;
        this.parentId = parentId;
    }

    public ProgrameTreeEnt() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
