package com.simdy.cms.controller;

import com.simdy.cms.Static.ResponseMessage;
import com.simdy.cms.entity.base.CommentListEnt;
import com.simdy.cms.entity.base.UserListEnt;
import com.simdy.cms.entity.base.UserViewEnt;
import com.simdy.cms.mapper.UserMapper;
import com.simdy.cms.service.CommentService;
import com.simdy.cms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    UserService userService;

    @GetMapping("queryContent/{modelLocation}")
    public Map<String,List<CommentListEnt>> getCommentsByModelLocation(@PathVariable("modelLocation") String modelLocation, HttpServletRequest request, HttpServletResponse response){
        ResponseMessage.DEAL_CROSS_DOMAIN(response,request);
        return commentService.queryCommentsByProModelLocation(modelLocation);
    }

    @RequestMapping("login")
    public void userLogin(@RequestParam("username") String username,
                          @RequestParam("password") String password
                            ,HttpServletRequest request,HttpServletResponse response){
        UserListEnt userLogin = userService.userLogin(username, password);
        if(userLogin!= null){
            request.getSession().setAttribute("user",userLogin);
        }

    }
    @PostMapping("register")
    public void userRegister(@RequestParam("userInfo") UserViewEnt user,
                             HttpServletResponse response , HttpServletRequest request){
       if(userService.userRegister(user)){
           response.setStatus(200);
       };
    }

}
