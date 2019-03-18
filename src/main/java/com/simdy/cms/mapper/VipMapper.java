package com.simdy.cms.mapper;

import com.simdy.cms.entity.KeyValueEnt;
import com.simdy.cms.entity.base.VipEnt;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface VipMapper {

    @Select("select * from vip")
    public List<VipEnt> queryVips();

    @Select("select * from vip where id = #{id}")
    public VipEnt queryVipById(Integer id);

    @Select("select id as entId,name as entValue from vip where id = #{vip}")
    public KeyValueEnt queryVipKVById(Integer vip);

    @Update("update vip set name =#{name},is_base=#{isBase},download_size=#{downloadSize},fee=#{fee},is_comtent=#{isComtent} where id = #{id}")
    public Integer updateVip(VipEnt vipEnt);

    @Insert("insert into vip (`id`,`name`,`is_base`,`download_size`,`fee`,`is_comtent`) " +
            "values(#{id},#{name},#{isBase},#{downloadSize},#{fee},#{isComtent})")
    public Integer insertVip(VipEnt vipEnt);


    @Select("select id as entId,name as entValue from vip")
    public KeyValueEnt selectKV();

}
