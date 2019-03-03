package com.simdy.cms.mapper;

import com.simdy.cms.entity.Music;
import com.simdy.cms.entity.base.MusicAddEnt;
import com.simdy.cms.entity.base.MusicListEnt;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface MusicMapper {

//    @Select("select * from music where id = #{id}")
//    public Music findMusicById(Integer id);
    @Select("")
    public List<MusicListEnt> queryMusics(Integer currPage,Integer pageSize);

    @Select("")
    public MusicAddEnt queryMusicById(Integer id);

    @Insert("")
    public Integer insertMusic(MusicAddEnt musicAddEnt);

    @Delete("")
    public Integer deleteMusic(Integer id);

    @Delete("")
    public Integer deleteMusicsByLabelId(Integer labelId);

    @Delete("")
    public Integer deleteMusicsBySingerId(Integer singerId);

    @Update("")
    public Integer updateMusic(MusicAddEnt musicAddEnt);

    @Select("")
    public List<MusicListEnt> queryMusicBySingerId(Integer singerId);
}
