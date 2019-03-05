package com.simdy.cms.service;

import com.simdy.cms.entity.base.ProgrameTreeEnt;
import com.simdy.cms.entity.tree.TreeEnt;
import com.simdy.cms.mapper.ProgrameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProgrameService {

    @Autowired
    private  ProgrameMapper programeMapper;

    public TreeEnt<ProgrameTreeEnt> getProgremeTree(){
        List<ProgrameTreeEnt> treeEnts = programeMapper.queryProgrames();
        return null;

    }
}
