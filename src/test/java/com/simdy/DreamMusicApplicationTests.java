package com.simdy;

import com.simdy.cms.Static.TreeTraverse;
import com.simdy.cms.entity.base.CommentListEnt;
import com.simdy.cms.entity.base.ProgrameTreeEnt;
import com.simdy.cms.entity.tree.TreeEnt;
import com.simdy.cms.mapper.CommentMapper;
import com.simdy.cms.mapper.ProgrameMapper;
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

    @Test
    public void contextLoads() {
    }

    @Test
    public void conTest(){
        for (CommentListEnt c : commentMapper.queryCommentsByProID(50)) {
            System.out.println(c);
        }

    }


}
