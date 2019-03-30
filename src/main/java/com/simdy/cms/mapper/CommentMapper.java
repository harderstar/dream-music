package com.simdy.cms.mapper;


import com.simdy.cms.entity.base.CommentAddEnt;
import com.simdy.cms.entity.base.CommentListEnt;
import com.simdy.cms.entity.base.ProgrameListEnt;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CommentMapper {

    @Results({
            @Result(property = "programe",column = "programeId"
            ,one = @One(select = "com.simdy.cms.mapper.ProgrameMapper.queryProgrameById"))
        }
    )
    @Select("SELECT * FROM comment where programeId = #{proId}")
    public List<CommentListEnt> queryCommentsByProID(Integer proId);

    @Select("select * from comment where id = #{id}")
    public CommentAddEnt queryCommentById(Integer id);

    @Delete("delete from comment where id = #{id}")
    public Integer deleteCommentById(Integer id);

    @Insert("INSERT INTO `comment` (`programeId`," +
            "`title`,`external_link`,`digest`,`issuer`,`uptime`,`stick_level`,`type`,`comment_image`,`subtitle`," +
            " `detail`, `title_color`, `click_num`,  `commit`) " +
            "VALUES(#{programeId},#{title},#{externalLink},#{digest}," +
            "#{issuer},#{uptime},#{stickLevel},#{type},#{commentImage}," +
            "#{subtitle},#{detail},#{titleColor},#{clickNum},#{commit})")
    public Integer insertComment(CommentAddEnt commentAddEnt);

    @Update("UPDATE  `dream-music-db`.`comment` SET " +
            "`programeId` = #{programeId}, `title` = #{title}, " +
            "`external_link` = #{externalLink}, `digest` = #{digest}, " +
            "`issuer` = #{issuer}, `uptime` = #{uptime},`stick_level` = #{stickLevel},`type` = #{type}, " +
            "`comment_image` = #{commentImage},`subtitle` = #{subtitle}," +
            "`detail` = #{detail},`title_color` = #{titleColor}," +
            "`click_num` = #{clickNum},`commit` = #{commit} WHERE `id` = #{id} ;")
    public Integer updateComment(CommentAddEnt commentAddEnt);

    @Select("SELECT * from programe where model_location = #{modelLocation}")
    public ProgrameListEnt queryProIdBymodelLocation(String modelLocation);
}
