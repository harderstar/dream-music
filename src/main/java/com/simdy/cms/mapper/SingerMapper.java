package com.simdy.cms.mapper;

import com.simdy.cms.entity.base.SingerEnt;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SingerMapper {

    @Select("select * from singer ")
    public List<SingerEnt> querySingers(Integer currPage,Integer pageSize);

    @Select("select * from singer where id = #{id}")
    public SingerEnt querySingerById(Integer id);

    @Select("")
    public List<SingerEnt> querySingerByName(String name);

    @Insert("")
    public Integer insertSinger(SingerEnt singerEnt);

    @Update("")
    public Integer updateSinger(SingerEnt singerEnt);

    @Delete("")
    public Integer deleteSingerById(Integer id);

}
