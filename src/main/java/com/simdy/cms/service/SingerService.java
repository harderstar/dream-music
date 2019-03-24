package com.simdy.cms.service;

import com.github.pagehelper.PageHelper;
import com.simdy.cms.entity.Music;
import com.simdy.cms.entity.base.MusicAddEnt;
import com.simdy.cms.entity.base.MusicListEnt;
import com.simdy.cms.entity.base.SingerEnt;
import com.simdy.cms.mapper.LabelMapper;
import com.simdy.cms.mapper.MusicMapper;
import com.simdy.cms.mapper.SingerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SingerService {


    @Autowired
    private SingerMapper singerMapper;

    @Autowired
    private MusicMapper musicMapper;


    public List<SingerEnt> querySingers(Integer currPage,Integer pagesize){
        PageHelper.startPage(currPage,pagesize);
        return singerMapper.querySingers();

    }

    public Boolean updateSinger(SingerEnt singer){
        if (singer.getId() == null){
            if(singerMapper.insertSinger(singer) == 1)
                return true;
            else
                return false;
        }else {
            if(singerMapper.updateSinger(singer) == 1)
                return true;
            else
                return false;
        }
    }

    public SingerEnt querySingerById(Integer id){
        return singerMapper.querySingerById(id);
    }

    public Boolean deleteSingerById(Integer id){

        if(musicMapper.deleteMusicsBySingerId(id) == 1){
            if(singerMapper.deleteSingerById(id) == 1)
                return true;
            else
                return false;
        }else {
            return false;
        }
    }

    public List<MusicListEnt> queryMusicsBySinger(SingerEnt singer){
        return musicMapper.queryMusicsBySingerId(singer.getId());
    }

}

