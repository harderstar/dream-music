package com.simdy.cms.entity.tree;

import java.util.List;

public class TreeEnt<T> {

    private String value;
    private List<TreeEnt<T>> children;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TreeEnt() {
    }

    public TreeEnt(String value, List<TreeEnt<T>> children,Integer id) {
        this.value = value;
        this.children = children;
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<TreeEnt<T>> getChildren() {
        return children;
    }

    public void setChildren(List<TreeEnt<T>> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "TreeEnt{" +
                "value='" + value + '\'' +
                ", children=" + children +
                ", id=" + id +
                '}';
    }
}
