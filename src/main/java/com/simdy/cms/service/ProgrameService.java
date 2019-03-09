package com.simdy.cms.service;

import com.simdy.cms.Static.TreeTraverse;
import com.simdy.cms.entity.base.ProgrameListEnt;
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

    public List<TreeEnt<ProgrameTreeEnt>> getProgrameTree(){
        List<ProgrameTreeEnt> programes = programeMapper.quertTrees();

        TreeTraverse<ProgrameTreeEnt> treeEntTreeTraverse = new TreeTraverse<>();

        List<TreeEnt<ProgrameTreeEnt>> list = treeEntTreeTraverse.getTreeEnts(programes);

        return list;
    }

    public List<ProgrameListEnt> getProgramesByPaId(Integer parentId){
        return programeMapper.queryProgramesByParentId(parentId);
    }

    public ProgrameListEnt getProgrameById(Integer id){
        return programeMapper.queryProgrameById(id);
    }

    public Boolean updatePro(ProgrameListEnt programeListEnt){
        if(programeListEnt.getId() == null){
            Integer integer = programeMapper.insertPrograme(programeListEnt);
            programeMapper.updateProgramePid(programeListEnt.getParentId());
            System.out.println(integer);
            return true;
        }else {
            programeMapper.updatePrograme(programeListEnt);

            return true;
        }

    }

}
