package com.simdy.cms.mapper;


import com.simdy.cms.entity.base.ManagerEnt;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ManageMapper {

    @Select("select * from manager where username = #{username} and password = #{password}")
    public ManagerEnt quaryManagerByUsername(ManagerEnt managerEnt);



}
