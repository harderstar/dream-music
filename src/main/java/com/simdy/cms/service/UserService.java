package com.simdy.cms.service;

import com.github.pagehelper.PageHelper;
import com.simdy.cms.entity.base.UserListEnt;
import com.simdy.cms.entity.base.UserViewEnt;
import com.simdy.cms.entity.base.VipEnt;
import com.simdy.cms.mapper.UserMapper;
import com.simdy.cms.mapper.VipMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    VipMapper vipMapper;

    @Autowired
    UserMapper userMapper;

    /**
     * 用户注册
     * @param userViewEnt
     * @return
     */
    public Boolean userRegister(UserViewEnt userViewEnt){
        return false;
    }

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    public UserListEnt userLogin(String username,String password){
        return userMapper.checkUser(new UserListEnt(username,password));
    }

    /**
     * 获取vip列表
     * @return
     */
    public List<VipEnt> getVips(Integer curPage,Integer pageSize){
        PageHelper.startPage(curPage,pageSize);
        return vipMapper.queryVips();
    };

    /**
     * 返回vip参数
     * @param id
     * @return
     */
    public VipEnt getVipById(Integer id){
        return vipMapper.queryVipById(id);
    }

    /**
     * 更新vip
     * @param vipEnt
     * @return
     */
    public Boolean updateVip(VipEnt vipEnt){

        if(vipEnt.getId() == null){
            if (vipMapper.insertVip(vipEnt) == 1)
                return true;
            return false;
        }else {
            if(vipMapper.updateVip(vipEnt) == 1)
                return true;
            return false;
        }
    }

    /**
     * 获取用户列表
     * @param page
     * @param pagesize
     * @return
     */
     public List<UserViewEnt> getUsers(Integer page, Integer pagesize){
         System.out.println(page+" "+pagesize);
         PageHelper.startPage(page,pagesize);   //第一个参数是从第几个数据开始，第二个是每页显示几条数据
         List<UserViewEnt>  findListMenus = userMapper.queryUsers();
          for(int i=0;i<findListMenus.size();i++){
              System.out.println(findListMenus.get(i));
          }
        return findListMenus;
    }

    /**
     * 下载歌曲下载数减一
     * @param id
     * @return
     */
    public boolean subDownLoadSize(Integer id){
        userMapper.subDownLoadSize(id);
        return true;
    };

}
