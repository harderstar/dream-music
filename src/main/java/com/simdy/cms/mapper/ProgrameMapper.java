package com.simdy.cms.mapper;

import com.simdy.cms.entity.base.LabelAddEnt;
import com.simdy.cms.entity.base.ProgrameListEnt;
import com.simdy.cms.entity.base.ProgrameTreeEnt;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProgrameMapper {

    @Select("select * from programe  ORDER BY id DESC")
    public List<ProgrameListEnt> queryProgrames();

    @Select("select id,value,is_parent,parent_id from programe " )
    public List<ProgrameTreeEnt> quertTrees();

    @Select("select * from programe where parent_id = #{parentId}  ORDER BY id DESC")
    public List<ProgrameListEnt> queryProgramesByParentId(Integer parentId);


    @Select("select  * from programe where id = #{id}")
    public ProgrameListEnt queryProgrameById(Integer id);

    @Insert("insert into programe (`value`,`model_location`,`order`,`is_show`,`parent_id`,`model`,`count`,`type`,`station_id`) values(#{value},#{modelLocation},#{order},#{isShow},#{parentId},#{model},#{count},#{type},#{stationId})")
    public Integer insertPrograme(ProgrameListEnt programeListEnt);

    @Update("update programe set `value`=#{value},`model_location`=#{modelLocation}, `order` = #{order},`is_show`=#{isShow},`parent_id`=#{parentId},`model`=#{model},count=#{count},`type`=#{type},`station_id`=#{stationId},`is_parent`=#{isParent} where `id`=#{id}")
    public Integer updatePrograme(ProgrameListEnt programeListEnt);

    @Update("update programe set `is_parent` = 1 where `id` = #{id}")
    public Integer updateProgramePid(Integer id);

    @Delete("delete from programe where id=#{id}")
    public Integer deleteProgrameById(Integer id);

}
