package com.simdy.cms.entity.base;

public class ProgrameListEnt {

    private Integer id;
    private String value;
    private String modelLocation;
    private Integer order;
    private Integer isShow;
    private Integer parentId;
    private String model;
    private Integer count;
    private Integer type;
    private Integer stationId;
    private Integer isParent;

    @Override
    public String toString() {
        return "ProgrameListEnt{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", modelLocation='" + modelLocation + '\'' +
                ", order=" + order +
                ", isShow=" + isShow +
                ", parentId=" + parentId +
                ", model='" + model + '\'' +
                ", count=" + count +
                ", type=" + type +
                ", stationId=" + stationId +
                ", isParent=" + isParent +
                '}';
    }

    public Integer getIsParent() {
        return isParent;
    }

    public void setIsParent(Integer isParent) {
        this.isParent = isParent;
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

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
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

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }
}
