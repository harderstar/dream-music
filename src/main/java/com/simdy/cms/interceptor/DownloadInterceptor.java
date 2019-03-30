package com.simdy.cms.interceptor;

import com.simdy.cms.entity.base.UserListEnt;
import com.simdy.cms.mapper.UserMapper;
import com.simdy.cms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        UserListEnt user = (UserListEnt)request.getSession().getAttribute("user");
        System.out.println(user);
        if(user == null){
            //未登陆，返回登陆页面
            response.setStatus(400);
            return false;
        }else if(user.getDownloadSize()<=0){
            //已登陆，放行请求
            response.setStatus(400);
            return false;
        }else {

            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
