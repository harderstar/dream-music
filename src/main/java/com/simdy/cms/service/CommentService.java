package com.simdy.cms.service;

import com.github.pagehelper.PageHelper;
import com.simdy.cms.Static.TreeTraverse;
import com.simdy.cms.entity.base.CommentAddEnt;
import com.simdy.cms.entity.base.CommentListEnt;
import com.simdy.cms.entity.base.ProgrameListEnt;
import com.simdy.cms.entity.base.ProgrameTreeEnt;
import com.simdy.cms.mapper.CommentMapper;
import com.simdy.cms.mapper.ProgrameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    ProgrameMapper programeMapper;

    public List<CommentListEnt> getCommentsByProId(Integer proId,Integer curPage,Integer pageSize){
        PageHelper.startPage(curPage,pageSize);
        return commentMapper.queryCommentsByProID(proId);
    }

    public CommentAddEnt getCommentById(Integer id){
        return commentMapper.queryCommentById(id);
    }

    public Boolean updateComment(CommentAddEnt commentAddEnt){
        System.out.println(commentAddEnt);
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
    public Map<String,List<CommentListEnt>> queryCommentsByProModelLocation(String modelLocation){
        ProgrameListEnt programe = commentMapper.queryProIdBymodelLocation(modelLocation);
        List<ProgrameTreeEnt> treeEnts = programeMapper.quertTrees();
        TreeTraverse<ProgrameTreeEnt> ts = new TreeTraverse<>();
        List<Integer> list = ts.queryTreeNode(programe.getId(), treeEnts);

        Map<String,List<CommentListEnt>> map = new HashMap<>();
        for(Integer cid :list){
            List<CommentListEnt> commentListEnts = commentMapper.queryCommentsByProID(cid);
            map.put(programeMapper.queryProgrameById(cid).getValue(),commentListEnts);
        }

        return map;
    }
}
