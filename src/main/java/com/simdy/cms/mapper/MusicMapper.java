package com.simdy.cms.mapper;


import com.simdy.cms.entity.Music;
import com.simdy.cms.entity.base.LabelListEnt;
import com.simdy.cms.entity.base.MusicAddEnt;
import com.simdy.cms.entity.base.MusicListEnt;
import com.simdy.cms.entity.base.SingerEnt;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface MusicMapper {


    @Select("select * from music  ORDER BY id DESC" )
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(property = "singers", column = "id"
                    , many = @Many(select = "com.simdy.cms.mapper.MusicMapper.querySingerByMusicId"))
    })
    public List<MusicListEnt> queryMusics();

    @Select("SELECT * FROM music WHERE NAME LIKE '%${key}%'  ORDER BY id DESC" )
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(property = "singers", column = "id"
                    , many = @Many(select = "com.simdy.cms.mapper.MusicMapper.querySingerByMusicId"))
    })
    public List<MusicListEnt> queryMusicByKey(@Param("key") String key);


    @Select("select * from music where id = #{id} ")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(property = "singers", column = "id"
                    , many = @Many(select = "com.simdy.cms.mapper.MusicMapper.querySingerByMusicId"))
    })
    public MusicListEnt queryMusicListById(Integer id);

    @Select("select * from music where id = #{id} ")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(property = "singers", column = "id"
                    , many = @Many(select = "com.simdy.cms.mapper.MusicMapper.querySingerByMusicId")),
            @Result(property = "labels", column = "id"
                    , many = @Many(select = "com.simdy.cms.mapper.MusicMapper.queryLabelByMusicId"))

})
    public MusicAddEnt queryMusicAddById(Integer id);



    @Insert("INSERT INTO `dream-music-db`.`music` (   " +
            " `name`,  `audition_url`,  `lyric`,  `photo`,  `popularity`,  `size`,  " +
            "`like`,   `collect`,  `power`,  `composer`,  `download_url`,  " +
            "`dance_template`,`uptime`,  `commit`,  `recommend`,`image`)" +
            "VALUES(#{name},#{auditionUrl},#{lyric},#{photo},#{popularity},#{size},#{like}," +
            " #{collect},0,#{composer},#{downloadUrl},#{danceTemplate},#{image}" +
            "#{uptime},#{commit},#{recommend}) ")
    public Integer insertMusic(MusicAddEnt musicAddEnt);

    @Delete("delete from music where id=#{id}")
    public Integer deleteMusic(Integer id);



    @Update("UPDATE `music` SET `name` = #{name}," +
            " `audition_url` = #{auditionUrl}, `lyric` = #{lyric}, `photo` = #{photo}, " +
            "`popularity` = #{popularity}, `size` = #{size}, `like` = #{like}, " +
            "`collect` = #{collect},  `image` = #{image}," +
            " `composer` = #{composer}," +
            "`download_url` = #{downloadUrl}, `dance_template` = #{danceTemplate}, `uptime` = #{uptime}," +
            " `commit` = #{commit},`recommend` = #{recommend} WHERE `id` = #{id} ;")
    public Integer updateMusic(MusicAddEnt musicAddEnt);


    @Select("select * from singer_and_music ,singer where singer.id = singer_and_music.singer_id and singer_and_music.music_id = #{id}  ORDER BY id DESC")
    public List<SingerEnt> querySingerByMusicId(Integer id);

    @Select("select * from label_and_music ,label where label.id = label_and_music.label_id and label_and_music.music_id = #{id}  ORDER BY id DESC")
    public List<LabelListEnt> queryLabelByMusicId(Integer id);


    @Delete("delete from label_and_music where label_id = #{id}")
    public Integer deleteMusicAndLabelByLabelId(Integer id);

    @Delete("delete from label_and_music where music_id = #{id}")
    public Integer deleteMusicAndLabelByMusicId(Integer id);

    @Delete("delete from singer_and_music where music_id = #{id}")
    public Integer deleteSingerAndMusicByMuiscId(Integer id);

    @Insert("insert into label_and_music values(#{musicId},#{labelId})")
    public Integer insertLabelAndMusic(@Param("musicId") Integer musicId , @Param("labelId") Integer labelId);

    @Delete("delete from label_and_music where music_id = #{musicId}")
    public Integer deleteLabelAndMusic(@Param("musicId") Integer musicId);

    @Insert("insert into singer_and_music values(#{musicId},#{singerId})")
    public Integer insertSingerAndMusic(@Param("musicId") Integer musicId , @Param("singerId") Integer singerId);

    @Delete("delete from singer_and_music where music_id = #{musicId}")
    public Integer deleteSingerAndMusic(@Param("musicId") Integer musicId);

    @Select("select max(id) from music;")
    public Integer getMaxMusicId();


}
