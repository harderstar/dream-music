package com.simdy.cms.service;

import com.github.pagehelper.PageHelper;
import com.simdy.cms.entity.base.LabelAddEnt;
import com.simdy.cms.entity.base.LabelListEnt;
import com.simdy.cms.mapper.LabelMapper;
import com.simdy.cms.mapper.MusicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LabelService {

    @Autowired
    private LabelMapper labelMapper;

    @Autowired
    private MusicMapper musicMapper;


    public List<LabelListEnt> queryLabels(Integer currPage,Integer pageSize){

        PageHelper.startPage(currPage,pageSize);
        return labelMapper.queryLabels();

    }

    public LabelAddEnt queryLabelById(Integer id){
        return labelMapper.queryLabelById(id);
    }

    public Boolean updatLabel(LabelAddEnt labelAddEnt){
        System.out.println(labelAddEnt);
        if(labelAddEnt.getId() == null){
            if(labelMapper.insertLabel(labelAddEnt) == 1)
                return true;
            else
                return false;
        }else {
            if(labelMapper.updateLabel(labelAddEnt) == 1)
                return true;
            else
                return false;
        }
    }

    public Boolean deleteLabelById(Integer id){
        if(musicMapper.deleteMusicAndLabelByLabelId(id) == 1){
            if(labelMapper.deleteLabelById(id) == 1)
                return true;
            else
                return false;
        }else {
            return false;
        }
    }
}
