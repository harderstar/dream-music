package com.simdy.cms.mapper;


import com.simdy.cms.entity.base.LabelListEnt;
import com.simdy.cms.entity.base.MusicAddEnt;
import com.simdy.cms.entity.base.MusicListEnt;
import com.simdy.cms.entity.base.SingerEnt;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface MusicMapper {


    @Select("select * from music")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(property = "singers", column = "id"
                    , many = @Many(select = "com.simdy.cms.mapper.MusicMapper.querySingerByMusicId"))
    })
    public List<MusicListEnt> queryMusics();


    @Select("select * from music where id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(property = "singers", column = "id"
                    , many = @Many(select = "com.simdy.cms.mapper.MusicMapper.querySingerByMusicId"))
    })
    public MusicListEnt queryMusicListById(Integer id);

    @Select("select * from music where id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(property = "singers", column = "id"
                    , many = @Many(select = "com.simdy.cms.mapper.MusicMapper.querySingerByMusicId")),
            @Result(property = "labels", column = "id"
                    , many = @Many(select = "com.simdy.cms.mapper.MusicMapper.queryLabelByMusicId"))

})
    public MusicAddEnt queryMusicAddById(Integer id);

    @Select("select * from music where id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(property = "singers", column = "id"
                    , many = @Many(select = "com.simdy.cms.mapper.MusicMapper.querySingerByMusicId"))
    })    public MusicAddEnt queryMusicById(Integer id);

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


    @Select("select * from singer_and_music ,singer where singer.id = singer_and_music.singer_id and singer_and_music.music_id = #{id}")
    public List<SingerEnt> querySingerByMusicId(Integer id);

    @Select("select * from label_and_music ,label where label.id = label_and_music.label_id and label_and_music.music_id = #{id}")
    public List<LabelListEnt> queryLabelByMusicId(Integer id);

    @Select("")
    public List<MusicListEnt> queryMusicsBySingerId(Integer id);

    @Delete("delete from label_and_music where label_id = #{id}")
    public Integer deleteMusicAndLabelByLabelId(Integer id);

    @Delete("delete from label_and_music where music_id = #{id}")
    public Integer deleteMusicAndLabelByMusicId(Integer id);

    @Delete("delete from singer_and_music where music_id = #{id}")
    public Integer deleteSingerAndMusicByMuiscId(Integer id);




}
