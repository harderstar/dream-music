package com.simdy.cms.mapper;

import com.simdy.cms.entity.base.LabelListEnt;
import com.simdy.cms.entity.base.UserListEnt;
import com.simdy.cms.entity.base.UserViewEnt;
import com.simdy.cms.entity.base.VipEnt;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(property = "vip" ,column = "id"
                    ,many = @Many(select = "com.simdy.cms.mapper.UserMapper.queryVipsByUserId"))
    })
    @Select("SELECT *  FROM USER  ORDER BY id DESC")
    public List<UserViewEnt> queryUsers();

    @Select("select id,name,password,sex,birthdate,sign,phonenumber as phoneNum,wechat,safe_question as safeQuestion,safe_answer as safeAnswer,power,last_login_time as lastLoginTime from user where id =#{id}")
    public UserViewEnt queryUserById(Integer id);

    @Select("select id,name,download_size from user where name=#{name} and password = #{password}")
    public UserListEnt checkUser(UserListEnt userListEnt);

    @Insert("insert into user (name,password,sex,birthdate,sign,phonenumber,wechat,safe_question,safe_answer) value(#{name},#{password},#{sex},#{birthdate},#{sign},#{phoneNum},#{wechat},#{safeQuestion},#{safeAnswer})")
    public Integer insertUser(UserViewEnt userViewEnt);

    @Update("update user set name=#{name},password=#{password},sex=#{sex},birthdate=#{birthdate},sign=#{sign},phonenumber=#{phoneNum},wechat=#{wechat},safe_question=#{safeQuestion},safe_answer=#{safeAnswer} where id =#{id}")
    public Integer updateUser(UserViewEnt userViewEnt);

    @Select("select * from user_vip,vip where user_vip.uid=#{id} and user_vip.vid = vip.id  ")
    public List<VipEnt> queryVipsByUserId(Integer id);

    @Update("update user set download_size = download_size-1 WHERE `id` = #{id}")
    public Integer subDownLoadSize(Integer id);



}
