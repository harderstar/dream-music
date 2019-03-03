package com.simdy.cms.mapper;

import com.simdy.cms.entity.base.LabelAddEnt;
import com.simdy.cms.entity.base.LabelListEnt;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface LabelMapper {

    @Select("")
    public List<LabelListEnt> queryLabels(Integer currPage,Integer pageSize);

    @Select("")
    public LabelAddEnt queryLabelById(Integer id);

    @Insert("")
    public Integer insertLabel(LabelAddEnt labelAddEnt);

    @Update("")
    public Integer updateLabel(LabelAddEnt labelAddEnt);

    @Delete("")
    public Integer deleteLabelById(Integer id);
}
