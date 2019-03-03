package com.simdy.cms.entity.base;

public class ProgrameListEnt {

    private String id;
    private String name;
    private String modelLocation;
    private Integer order;
    private Integer isShow;
    private String parentId;
    private String model;
    private Integer count;
    private Integer type;
    private String station;

    public ProgrameListEnt() {
    }


    public ProgrameListEnt(String station,String id, String name, String modelLocation, Integer order, Integer isShow, String parentId, String model, Integer count, Integer type) {
        this.id = id;
        this.name = name;
        this.modelLocation = modelLocation;
        this.order = order;
        this.isShow = isShow;
        this.parentId = parentId;
        this.model = model;
        this.count = count;
        this.type = type;
        this.station = station;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModelLocation() {
        return modelLocation;
    }

    public void setModelLocation(String modelLocation) {
        this.modelLocation = modelLocation;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }


    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
