package com.simdy.cms.mapper;

import com.simdy.cms.entity.base.UserListEnt;
import com.simdy.cms.entity.base.UserViewEnt;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Results({
        @Result(property = "vip" ,column = "vip",javaType = com.simdy.cms.entity.KeyValueEnt.class
                ,one = @One(select = "com.simdy.cms.mapper.VipMapper.queryVipKVById"))
    })
    @Select("SELECT *  FROM USER")
    public List<UserListEnt> queryUsers();

    @Select("select id,name,password,sex,birthdate,sign,phonenumber as phoneNum,wechat,safe_question as safeQuestion,safe_answer as safeAnswer,power,last_login_time as lastLoginTime from user where id =#{id}")
    public UserViewEnt queryUserById(Integer id);

    @Insert("insert into user (name,password,sex,birthdate,sign,phonenumber,wechat,safe_question,safe_answer) value(#{name},#{password},#{sex},#{birthdate},#{sign},#{phoneNum},#{wechat},#{safeQuestion},#{safeAnswer})")
    public Integer insertUser(UserViewEnt userViewEnt);

    @Update("update user set name=#{name},password=#{password},sex=#{sex},birthdate=#{birthdate},sign=#{sign},phonenumber=#{phoneNum},wechat=#{wechat},safe_question=#{safeQuestion},safe_answer=#{safeAnswer} where id =#{id}")
    public Integer updateUser(UserViewEnt userViewEnt);


}
