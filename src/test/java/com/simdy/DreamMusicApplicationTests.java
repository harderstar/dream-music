package com.simdy;

import com.simdy.cms.Static.TreeTraverse;
import com.simdy.cms.entity.base.CommentListEnt;
import com.simdy.cms.entity.base.ProgrameTreeEnt;
import com.simdy.cms.entity.tree.TreeEnt;
import com.simdy.cms.mapper.CommentMapper;
import com.simdy.cms.mapper.MusicMapper;
import com.simdy.cms.mapper.ProgrameMapper;
import com.simdy.cms.mapper.VipMapper;
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

    @Test
    public void contextLoads() {
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

    }

    @Test
    public void Test4(){
        System.out.println(vipMapper.queryVipKVById(1));
    }

    @Test
    public void Test5(){
        System.out.println(musicMapper.queryMusicAddById(1));
    }

}
