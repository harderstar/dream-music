package com.simdy.cms.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.pagehelper.PageInfo;
import com.simdy.cms.Static.ResponseMessage;
import com.simdy.cms.entity.Result;
import com.simdy.cms.entity.base.UserListEnt;
import com.simdy.cms.entity.base.UserViewEnt;
import com.simdy.cms.entity.base.VipEnt;
import com.simdy.cms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

@RestController()
@CrossOrigin
@RequestMapping("manager")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 获取会员组列表
     * @param request
     * @param response
     * @return
     */
    @GetMapping("getVips")
    public List<VipEnt> getVips(@RequestParam("curPage")Integer curPage, @RequestParam("pageSize")Integer pageSize,HttpServletRequest request, HttpServletResponse response){
        ResponseMessage.DEAL_CROSS_DOMAIN(response,request);

        return userService.getVips(curPage,pageSize);
    }

    /**
     * 获得会员组信息
     * @param id
     * @param request
     * @param response
     * @return
     */
    @GetMapping("getVip/{id}")
    public VipEnt getVip(@PathVariable("id") Integer id,HttpServletRequest request, HttpServletResponse response){
        ResponseMessage.DEAL_CROSS_DOMAIN(response,request);

        return userService.getVipById(id);
    }

    /**
     * 添加或修改会员组
     * @param vipEnt
     * @param request
     * @param response
     * @return
     */
    @PostMapping("updateVip")
    public String updateVip(@RequestBody VipEnt vipEnt, HttpServletRequest request, HttpServletResponse response){
        System.out.println(vipEnt);
        if(userService.updateVip(vipEnt))
             return ResponseMessage.SUCCESS_MESSAGE;
         return ResponseMessage.ERROR_MESSAGE;
    }

    /**
     * 获取用户列表
     * @param page
     * @param request
     * @param response
     * @return
     */
    @GetMapping("getUsers")
    @JsonView(UserViewEnt.UserSimpleView.class)
    public List<UserViewEnt> getUsers(@RequestParam("curPage")Integer page,@RequestParam("pageSize") Integer pageSize, HttpServletRequest request, HttpServletResponse response){
        ResponseMessage.DEAL_CROSS_DOMAIN(response,request);
        List<UserViewEnt> users = userService.getUsers(page, pageSize);
        return users;

    }

}
