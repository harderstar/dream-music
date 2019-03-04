package com.simdy.cms.mapper;

import com.simdy.cms.entity.base.LabelAddEnt;
import com.simdy.cms.entity.base.ProgrameListEnt;
import com.simdy.cms.entity.base.ProgrameTreeEnt;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ProgrameMapper {

    @Select("")
    public List<ProgrameTreeEnt> queryProgrames();

    @Select("")
    public List<ProgrameListEnt> queryLabelByParentId(Integer parentId);

    @Insert("")
    public Integer insertPrograme(ProgrameListEnt programeListEnt);

    @Update("")
    public Integer updatePrograme(ProgrameListEnt programeListEnt);

    @Delete("")
    public Integer deleteProgrameById(Integer id);

}
