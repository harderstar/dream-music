package com.simdy.cms.service;

import com.github.pagehelper.PageHelper;
import com.simdy.cms.entity.base.MusicAddEnt;
import com.simdy.cms.entity.base.MusicListEnt;
import com.simdy.cms.mapper.MusicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MusicService {

    @Autowired
    private MusicMapper musicMapper;

    public List<MusicListEnt> queryMusics(Integer currPage,Integer pageSize){
        PageHelper.startPage(currPage,pageSize);
        return musicMapper.queryMusics();
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
//        if(musicMapper.deleteMusicAndLabelByMusicId(id) == 1){
//            System.out.println("------------------------");
//            if(musicMapper.deleteMusicAndLabelByMusicId(id) == 1){
//                System.out.println("------------------------");
//                if(musicMapper.deleteMusic(id) == 1){
//                    System.out.println("------------------------");
//                    return true;
//                }else return false;
//            }else return false;
//        }else return false;
        if(musicMapper.deleteMusic(id) == 1){
                   System.out.println("------------------------");
                    return true;
        }else return false;

    }
}
