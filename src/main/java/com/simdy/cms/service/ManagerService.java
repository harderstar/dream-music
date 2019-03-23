package com.simdy.cms.service;

import com.simdy.cms.entity.base.ManagerEnt;
import com.simdy.cms.mapper.ManageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {

    @Autowired
    ManageMapper manageMapper;

    public ManagerEnt managerLogin(ManagerEnt managerEnt){
        ManagerEnt ent = manageMapper.quaryManagerByUsername(managerEnt.getUsername());
        if(ent!=null){
            ent.setPassword(null);
        }
        return ent;
    }
}
