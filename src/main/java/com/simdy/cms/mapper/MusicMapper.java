package com.simdy.cms.mapper;

import com.simdy.cms.entity.Music;
import com.simdy.cms.entity.base.MusicAddEnt;
import com.simdy.cms.entity.base.MusicListEnt;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface MusicMapper {

//    @Select("select * from music where id = #{id}")
//    public Music findMusicById(Integer id);
    @Select("select * from music limit #{currPage} , #{pageSize}")
    public List<MusicListEnt> queryMusics(Integer currPage,Integer pageSize);

    @Select("select music.id as id,music.name as name,singer.name as singer,album.name as album,audition_url as auditionUrl,lyric,photo as image,popularity,size,like,download_num as download,dance_template as danceTemplate,uptime,commit,recommend from music join singer on singer_id=singer.id join album on album_id=album.id where music.id = #{id}")
    public MusicAddEnt queryMusicById(Integer id);

//    @Insert("insert into music (name,) value(#{name},)")
    public Integer insertMusic(MusicAddEnt musicAddEnt);

    @Delete("delete from music where id=#{id}")
    public Integer deleteMusic(Integer id);

//    @Delete("delete from music where id=(select music.=labelId)")
    public Integer deleteMusicsByLabelId(Integer labelId);

    @Delete("delete from music where singer_id=#{singerId}")
    public Integer deleteMusicsBySingerId(Integer singerId);

//    @Update("update music set where music.id=#{id}")
    public Integer updateMusic(MusicAddEnt musicAddEnt);

    @Select("select music.id as id,music.name as name,singer.name as singer,album.name as album,audition_url as auditionUrl,lyric,photo as image,popularity,size,like,download_num as download,dance_template as danceTemplate,uptime,commit,recommend from music join singer on singer_id=singer.id join album on album_id=album.id where singer_id = #{singerId}")
    public List<MusicListEnt> queryMusicBySingerId(Integer singerId);
}
