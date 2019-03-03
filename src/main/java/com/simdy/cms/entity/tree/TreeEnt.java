package com.simdy.cms.entity.tree;

import java.util.List;

public class TreeEnt<T> {

    private String value;
    private List<T> children;

    public TreeEnt() {
    }

    public TreeEnt(String value, List<T> children) {
        this.value = value;
        this.children = children;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<T> getChildren() {
        return children;
    }

    public void setChildren(List<T> children) {
        this.children = children;
    }
}
