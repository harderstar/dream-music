package com.simdy.cms.controller;

import com.simdy.cms.entity.Music;
import com.simdy.cms.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MusicController {

    @Autowired
    private MusicService musicService;

    @GetMapping("music/{id}")
    public Music findMusicById(@PathVariable("id") Integer id){
        Music music = musicService.findMusicById(id);
        System.out.println(music);
        return music;
    }

}
