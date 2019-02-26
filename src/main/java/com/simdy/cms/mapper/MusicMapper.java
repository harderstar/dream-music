package com.simdy.cms.mapper;

import com.simdy.cms.entity.Music;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MusicMapper {

    @Select("select * from music where id = #{id}")
    public Music findMusicById(Integer id);

}
