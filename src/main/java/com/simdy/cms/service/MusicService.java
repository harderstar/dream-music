package com.simdy.cms.service;

import com.github.pagehelper.PageHelper;
import com.simdy.cms.entity.base.*;
import com.simdy.cms.mapper.MusicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
        return musicMapper.queryMusicAddById(id);
    }

    public Boolean updateMusic(MusicAddEnt musicAddEnt){

        if(musicAddEnt.getId() == null){
            musicAddEnt.setUptime(new Date());
            if(musicMapper.insertMusic(musicAddEnt) == 1){

                Integer id = musicMapper.getMaxMusicId();
                if(musicAddEnt.getSingers()!=null)
                    for (SingerEnt singer : musicAddEnt.getSingers()) {
                        musicMapper.insertLabelAndMusic(id,singer.getId());
                    }
               if(musicAddEnt.getLabels()!=null)
                   for(LabelListEnt label : musicAddEnt.getLabels()){
                       musicMapper.insertSingerAndMusic(id,label.getId());
                    }
                return true;
            }else
                return false;
        }else {
            if(musicMapper.updateMusic(musicAddEnt) == 1){
                musicMapper.deleteSingerAndMusic(musicAddEnt.getId());
                musicMapper.deleteLabelAndMusic(musicAddEnt.getId());
                System.out.println("musicID:"+musicAddEnt.getId());
                System.out.println("singer:"+ musicAddEnt.getSingers());
                if(musicAddEnt.getSingers()!=null)
                    for (SingerEnt singer : musicAddEnt.getSingers()) {
                        musicMapper.insertSingerAndMusic(musicAddEnt.getId(),singer.getId());
                    }
                if(musicAddEnt.getLabels()!=null)
                    for(LabelListEnt label : musicAddEnt.getLabels()){
                    musicMapper.insertLabelAndMusic(musicAddEnt.getId(),label.getId());
                    }
                return true;
            }
            else
                return false;
        }
    }


    public Boolean deleteMusicById(Integer id){
        musicMapper.deleteLabelAndMusic(id);
        musicMapper.deleteSingerAndMusic(id);
        if(musicMapper.deleteMusic(id) == 1){
                   System.out.println("------------------------");
                    return true;
        }else return false;

    }

    public List<MusicListEnt> queryMusicByKey(String key){
        return  musicMapper.queryMusicByKey(key);
    }
}
