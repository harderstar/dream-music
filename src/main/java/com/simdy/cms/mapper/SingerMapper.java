package com.simdy.cms.mapper;

import com.simdy.cms.entity.base.SingerEnt;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SingerMapper {

    @Select("select id,name,sex,birthdate as birthday,introduction,hot_level as hotLevel from singer  ORDER BY id DESC")
    public List<SingerEnt> querySingers();

    @Select("select id,name,sex,birthdate as birthday,introduction,hot_level as hotLevel from singer where id = #{id}")
    public SingerEnt querySingerById(Integer id);

    @Select("select id,name,sex,birthdate as birthday,introduction,hot_level as hotLevel from singer where name = #{name}  ORDER BY id DESC")
    public List<SingerEnt> querySingerByName(String name);

    @Insert("insert into singer (name,sex,birthdate,introduction,hot_level) value(#{name},#{sex},#{birthday},#{introduction},#{hotLevel})")
    public Integer insertSinger(SingerEnt singerEnt);

    @Update("update singer set name=#{name},sex=#{sex},birthdate=#{birthday},introduction=#{introduction},hot_level=#{hotLevel} where id =#{id}")
    public Integer updateSinger(SingerEnt singerEnt);

    @Delete("delete from singer where id=#{id}")
    public Integer deleteSingerById(Integer id);

}
