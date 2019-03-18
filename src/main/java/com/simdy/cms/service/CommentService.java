package com.simdy.cms.service;

import com.github.pagehelper.PageHelper;
import com.simdy.cms.entity.base.CommentAddEnt;
import com.simdy.cms.entity.base.CommentListEnt;
import com.simdy.cms.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentMapper commentMapper;

    public List<CommentListEnt> getCommentsByProId(Integer proId,Integer curPage,Integer pageSize){
        PageHelper.startPage(curPage,pageSize);
        return commentMapper.queryCommentsByProID(proId);
    }

    public CommentAddEnt getCommentById(Integer id){
        return commentMapper.queryCommentById(id);
    }

    public Boolean updateComment(CommentAddEnt commentAddEnt){
        if(commentAddEnt.getId() == null){
            Integer comment = commentMapper.insertComment(commentAddEnt);
            if(comment == 1)
                return true;
            else
                return false;
        }else{
            Integer comment = commentMapper.updateComment(commentAddEnt);
            if(comment == 1)
                return true;
            else
                return true;
        }
    }

    public Boolean deleteConmentById(Integer id){
        if(commentMapper.deleteCommentById(id) == 0)
            return false;
        else
            return true;
    }

}
