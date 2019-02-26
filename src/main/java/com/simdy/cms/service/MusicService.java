package com.simdy.cms.service;

import com.simdy.cms.entity.Music;
import com.simdy.cms.mapper.MusicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicService {

    @Autowired
    private MusicMapper musicMapper;

    public Music findMusicById(Integer id){

        return musicMapper.findMusicById(id);
    }
}
