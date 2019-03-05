package com.simdy.cms.controller;

import com.simdy.cms.Static.TreeTraverse;
import com.simdy.cms.entity.base.ProgrameTreeEnt;
import com.simdy.cms.entity.tree.TreeEnt;
import com.simdy.cms.mapper.ProgrameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    ProgrameMapper programeMapper;

    @GetMapping("getTree")
    public TreeEnt<ProgrameTreeEnt> getTree(){
        List<ProgrameTreeEnt> programes = programeMapper.quertTrees();

        TreeTraverse<ProgrameTreeEnt> treeEntTreeTraverse = new TreeTraverse<>();

        TreeEnt<ProgrameTreeEnt> treeEnts = treeEntTreeTraverse.getTreeEnts(programes);

        return treeEnts;
    }

}
