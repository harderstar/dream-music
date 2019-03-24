package com.simdy.cms.service;

import com.simdy.cms.entity.base.ManagerEnt;
import com.simdy.cms.mapper.ManageMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName CmsUserDetailService
 * @Description TODO
 * @Author simdy
 * @Date 2019/3/19 14:35
 * @Version 1.0
 **/
@Transactional
@Service
public class CmsUserDetailService  {

//    @Autowired
//    ManageMapper manageMapper;
//
//    private Logger logger = LoggerFactory.getLogger(getClass());
//
//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        logger.info("登录用户名"+username);
//        ManagerEnt managerEnt  = manageMapper.quaryManagerByUsername(username);
//        if(managerEnt == null){
//            throw new UsernameNotFoundException("用户名不存在");
//        }
//        return managerEnt;
//    }
}
