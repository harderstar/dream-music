package com.simdy.cms.entity.base;

public class ProgrameTreeEnt extends TreeTypeEnt{

    public ProgrameTreeEnt(Integer isParent,Integer id, String value, Integer parentId) {
        setId(id);
        setValue(value);
        setParentId(parentId);
        setIsParent(isParent);
    }

    public ProgrameTreeEnt() {
    }


}
