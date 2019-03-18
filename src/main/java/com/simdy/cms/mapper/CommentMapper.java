package com.simdy.cms.mapper;


import com.simdy.cms.entity.base.CommentAddEnt;
import com.simdy.cms.entity.base.CommentListEnt;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CommentMapper {

    @Select("SELECT comment.id,comment.`type`,`stick_level`,`issuer`,`title`,`click_num`,`commit`,`uptime`,`value` FROM `comment`,`programe` WHERE comment.programeId=programe.id AND programeId = #{proId}")
    public List<CommentListEnt> queryCommentsByProID(Integer proId);

    @Select("select * from comment where id = #{id}")
    public CommentAddEnt queryCommentById(Integer id);

    @Delete("")
    public Integer deleteCommentById(Integer id);

    @Insert("")
    public Integer insertComment(CommentAddEnt commentAddEnt);

    @Update("")
    public Integer updateComment(CommentAddEnt commentAddEnt);
}
