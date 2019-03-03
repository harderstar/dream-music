package com.simdy.cms.mapper;

import com.simdy.cms.entity.base.LabelAddEnt;
import com.simdy.cms.entity.base.ProgrameListEnt;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ProgrameMapper {

    @Select("")
    public List<ProgrameListEnt> queryLabels(Integer currPage, Integer pageSize);

    @Select("")
    public ProgrameListEnt queryLabelById();

    @Insert("")
    public Integer insertLabel(LabelAddEnt labelAddEnt);

    @Update("")
    public Integer updateLabel(LabelAddEnt labelAddEnt);

    @Delete("")
    public Integer deleteLabelById(Integer id);

}
