package com.simdy.cms.entity.base;

import java.io.Serializable;

public class ProgrameTreeEnt extends TreeTypeEnt implements Serializable {

    public ProgrameTreeEnt(Integer isParent,Integer id, String value, Integer parentId) {
        setId(id);
        setValue(value);
        setParentId(parentId);
        setIsParent(isParent);
    }

    public ProgrameTreeEnt() {
    }


}
