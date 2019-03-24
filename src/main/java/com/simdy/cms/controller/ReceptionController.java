package com.simdy.cms.controller;

import com.simdy.cms.Static.ResponseMessage;
import com.simdy.cms.entity.base.CommentListEnt;
import com.simdy.cms.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ReceptionController
 * @Description TODO
 * @Author simdy
 * @Date 2019/3/23 15:49
 * @Version 1.0
 **/

@RestController()
@CrossOrigin
public class ReceptionController {

    @Autowired
    CommentService commentService;

    @GetMapping("queryContent/{modelLocation}")
    public Map<String,List<CommentListEnt>> getCommentsByModelLocation(@PathVariable("modelLocation") String modelLocation, HttpServletRequest request, HttpServletResponse response){
        ResponseMessage.DEAL_CROSS_DOMAIN(response,request);
        return commentService.queryCommentsByProModelLocation(modelLocation);
    }

}
