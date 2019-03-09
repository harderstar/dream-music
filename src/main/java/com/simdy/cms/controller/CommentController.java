package com.simdy.cms.controller;

import com.simdy.cms.Static.ResponseMessage;
import com.simdy.cms.Static.TreeTraverse;
import com.simdy.cms.entity.base.ProgrameListEnt;
import com.simdy.cms.entity.base.ProgrameTreeEnt;
import com.simdy.cms.entity.tree.TreeEnt;
import com.simdy.cms.mapper.ProgrameMapper;
import com.simdy.cms.service.ProgrameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class CommentController {

    @Autowired
    ProgrameService programeService;

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




}
