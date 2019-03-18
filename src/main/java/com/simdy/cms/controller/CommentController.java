package com.simdy.cms.controller;

import com.simdy.cms.Static.ResponseMessage;
import com.simdy.cms.Static.TreeTraverse;
import com.simdy.cms.entity.base.CommentAddEnt;
import com.simdy.cms.entity.base.CommentListEnt;
import com.simdy.cms.entity.base.ProgrameListEnt;
import com.simdy.cms.entity.base.ProgrameTreeEnt;
import com.simdy.cms.entity.tree.TreeEnt;
import com.simdy.cms.mapper.ProgrameMapper;
import com.simdy.cms.service.CommentService;
import com.simdy.cms.service.ProgrameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController()
@CrossOrigin
@RequestMapping("manager")
public class CommentController {

    @Autowired
    ProgrameService programeService;

    @Autowired
    CommentService commentService;

    @GetMapping("getTree")
    public List<TreeEnt<ProgrameTreeEnt>> getTree(HttpServletRequest request, HttpServletResponse response){


        List<TreeEnt<ProgrameTreeEnt>> list = programeService.getProgrameTree();
        return list;
    }

    @GetMapping("getPros")
    public List<ProgrameListEnt> getProgrameList(Integer id,HttpServletRequest request, HttpServletResponse response){
        ResponseMessage.DEAL_CROSS_DOMAIN(response,request);
        return programeService.getProgramesByPaId(id);
    }

    @GetMapping("getPro")
    public ProgrameListEnt getPrograme(Integer id,HttpServletRequest request, HttpServletResponse response){
       ResponseMessage.DEAL_CROSS_DOMAIN(response,request);
       return programeService.getProgrameById(id);
    }

    @PostMapping("updatePro")
    public String updatePro(@RequestBody ProgrameListEnt programeListEnt,HttpServletRequest request, HttpServletResponse response){

        System.out.println(programeListEnt);
        if(programeService.updatePro(programeListEnt)){
            return ResponseMessage.SUCCESS_MESSAGE;
        }else
            return ResponseMessage.ERROR_MESSAGE;
    }

    @GetMapping("deletePro/{id}")
    public String deletePro(@PathVariable("id")Integer id,HttpServletRequest request, HttpServletResponse response){

        ResponseMessage.DEAL_CROSS_DOMAIN(response,request);
        if(programeService.deletePro(id))
            return ResponseMessage.SUCCESS_MESSAGE;
        else
            return ResponseMessage.ERROR_MESSAGE;

    }

    @GetMapping("getcomments")
    public List<CommentListEnt> getcommentsByProId(@PathParam("id") Integer id,
                                                   @PathParam("pageSize") Integer pageSize,
                                                   @PathParam("curPage") Integer curPage,
                                                   HttpServletRequest request,
                                                   HttpServletResponse response){
        ResponseMessage.DEAL_CROSS_DOMAIN(response,request);
        return commentService.getCommentsByProId(id,curPage,pageSize);
    }

    /**
     *
     * @param id
     * @param request
     * @param response
     * @return
     */
    @GetMapping("getcomment/{id}")
    public CommentAddEnt getComment(@PathVariable("id")Integer id,HttpServletRequest request,HttpServletResponse response){
        ResponseMessage.DEAL_CROSS_DOMAIN(response,request);
        return commentService.getCommentById(id);
    }



    /**
     * 更新内容
     * @param commentAddEnt
     * @param response
     * @param request
     * @return
     */
    @PostMapping("updateCom")
    public String updateComment(CommentAddEnt commentAddEnt,HttpServletResponse response,HttpServletRequest request){
        ResponseMessage.DEAL_CROSS_DOMAIN(response,request);
        if( commentService.updateComment(commentAddEnt)){
            return ResponseMessage.SUCCESS_MESSAGE;
        }
        return ResponseMessage.ERROR_MESSAGE;
    }

    @PostMapping("delete/{id}")
    public String deleteComment(@PathVariable("id") Integer id,HttpServletRequest request,HttpServletResponse response){
        ResponseMessage.DEAL_CROSS_DOMAIN(response,request);
        if(commentService.deleteConmentById(id))
            return ResponseMessage.SUCCESS_MESSAGE;
        return ResponseMessage.ERROR_MESSAGE;
    }
}
