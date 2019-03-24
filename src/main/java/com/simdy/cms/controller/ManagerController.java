package com.simdy.cms.controller;

import com.simdy.cms.Static.ResponseMessage;
import com.simdy.cms.entity.base.ManagerEnt;
import com.simdy.cms.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("manager")
public class ManagerController {

    @Autowired
    ManagerService managerService;

    @PostMapping("login")
    public String login(ManagerEnt managerEnt){
        ManagerEnt ent = managerService.managerLogin(managerEnt);
        if (ent != null){
            return ResponseMessage.SUCCESS_MESSAGE;
        }else
            return ResponseMessage.ERROR_MESSAGE;
    }

}
