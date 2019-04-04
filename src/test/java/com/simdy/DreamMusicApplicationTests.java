package com.simdy;

import com.simdy.cms.Static.TreeTraverse;
import com.simdy.cms.entity.base.CommentListEnt;
import com.simdy.cms.entity.base.MusicListEnt;
import com.simdy.cms.entity.base.ProgrameTreeEnt;
import com.simdy.cms.entity.base.UserViewEnt;
import com.simdy.cms.entity.tree.TreeEnt;
import com.simdy.cms.mapper.*;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DreamMusicApplicationTests {

    @Autowired
    ProgrameMapper programeMapper;

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    VipMapper vipMapper;

    @Autowired
    MusicMapper musicMapper;

    @Autowired
    UserMapper userMapper;


    @Test
    public void contextLoads() {
        for (MusicListEnt a : musicMapper.queryMusicByKey("a")) {
            System.out.println(a);
        }
        ;
    }

    @Test
    public void conTest(){
        for (CommentListEnt c : commentMapper.queryCommentsByProID(50)) {
            System.out.println(c);
        }

    }

    @Test
    public void Test1(){
        List<ProgrameTreeEnt> treeEnts = programeMapper.quertTrees();
        TreeTraverse<ProgrameTreeEnt> ts = new TreeTraverse<>();
        System.out.println(ts.queryTreeNode(11,treeEnts));;

    }

    @Test
    public void Test4(){
        System.out.println(vipMapper.queryVipKVById(1));
    }

    @Test
    public void Test5(){
        System.out.println(musicMapper.queryMusicAddById(1));
    }

    @Test
    public void Test6(){
        List<UserViewEnt> ents = userMapper.queryUsers();
        for (UserViewEnt ent:ents) {
            System.out.println(ReflectionToStringBuilder.toString(ent,ToStringStyle.MULTI_LINE_STYLE));
        }
    }

    @Test
    public void Test7(){
        System.out.println(commentMapper.queryCommentsByProID(50));;
    }

}
