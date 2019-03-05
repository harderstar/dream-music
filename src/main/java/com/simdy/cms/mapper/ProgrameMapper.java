package com.simdy.cms.mapper;

import com.simdy.cms.entity.base.LabelAddEnt;
import com.simdy.cms.entity.base.ProgrameListEnt;
import com.simdy.cms.entity.base.ProgrameTreeEnt;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProgrameMapper {

    @Select("select * from programe limit #{currPage},#{pageSize}")
    public List<ProgrameListEnt> queryProgrames(Integer currPage, Integer pageSize);

    @Select("select * from programe")
    public List<ProgrameTreeEnt> quertTrees();

    @Select("select programe.id as id,programe.name as name,model_location as modelLocation,order,is_show as isShow,parent_id as parentId,model,count,type,station.name from programe join station on station_id=station.id")
    public ProgrameListEnt queryProgrameById();

    @Insert("insert into programe (name,model_location,order,is_show,parent_id,model,count,type,station_id) value")
    public Integer insertPrograme(ProgrameListEnt programeListEnt);

    @Update("update programe set  where id=#{id}")
    public Integer updatePrograme(ProgrameListEnt programeListEnt);

    @Delete("delete from programe where id=#{id}")
    public Integer deleteProgrameById(Integer id);

}
