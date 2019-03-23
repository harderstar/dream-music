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

    @Delete("")
    public Integer deleteCommentById(Integer id);

    @Insert("")
    public Integer insertComment(CommentAddEnt commentAddEnt);

    @Update("")
    public Integer updateComment(CommentAddEnt commentAddEnt);

    @Select("SELECT * from programe where model_location = #{modelLocation}")
    public ProgrameListEnt queryProIdBymodelLocation(String modelLocation);
}
