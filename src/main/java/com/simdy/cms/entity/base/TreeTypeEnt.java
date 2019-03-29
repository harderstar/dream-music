package com.simdy.cms.entity.base;

import java.io.Serializable;

public class TreeTypeEnt implements Serializable {

    private Integer id;
    private String value;
    private Integer parentId;
    private Integer isParent;

    public TreeTypeEnt() {
    }

    public TreeTypeEnt(Integer id,String value, Integer parentId, Integer isParent) {
        this.value = value;
        this.parentId = parentId;
        this.isParent = isParent;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getIsParent() {
        return isParent;
    }

    public void setIsParent(Integer isParent) {
        this.isParent = isParent;
    }

    @Override
    public String toString() {
        return "TreeTypeEnt{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", parentId=" + parentId +
                ", isParent=" + isParent +
                '}';
    }
}
