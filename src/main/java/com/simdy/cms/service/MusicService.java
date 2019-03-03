package com.simdy.cms.service;

import com.simdy.cms.entity.base.MusicAddEnt;
import com.simdy.cms.entity.base.MusicListEnt;
import com.simdy.cms.mapper.MusicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {

    @Autowired
    private MusicMapper musicMapper;

    public List<MusicListEnt> queryMusics(Integer currPage,Integer pageSize){
        return musicMapper.queryMusics(currPage,pageSize);
    }

    public MusicAddEnt queryMusicById(Integer id){
        return musicMapper.queryMusicById(id);
    }

    public Boolean updateMusic(MusicAddEnt musicAddEnt){
        if(musicAddEnt.getId() == null){
            if(musicMapper.insertMusic(musicAddEnt) == 1){
                return true;
            }else
                return false;
        }else {
            if(musicMapper.updateMusic(musicAddEnt) == 1)
                return true;
            else
                return false;
        }
    }

    public Boolean deleteMusicById(Integer id){
        if(musicMapper.deleteMusicsBySingerId(id) == 1)
            return true;
        else
            return false;
    }
}
