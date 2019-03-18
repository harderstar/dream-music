package com.simdy.cms.controller;

import com.simdy.cms.Static.ResponseMessage;
import com.simdy.cms.entity.Label;
import com.simdy.cms.entity.Music;
import com.simdy.cms.entity.base.*;
import com.simdy.cms.mapper.LabelMapper;
import com.simdy.cms.mapper.SingerMapper;
import com.simdy.cms.service.LabelService;
import com.simdy.cms.service.MusicService;
import com.simdy.cms.service.SingerService;
import com.sun.org.apache.bcel.internal.generic.LMUL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("manager")
public class MusicController {

    @Autowired
    private MusicService musicService;

    @Autowired
    private SingerService singerService;

    @Autowired
    private LabelService labelService;

    @GetMapping("labels/{currePage}")
    public List<LabelListEnt>  queryLabels(@PathVariable("currePage") Integer currenPage){
        return labelService.queryLabels(currenPage,10);
    }

    @GetMapping("label/{id}")
    public LabelAddEnt queryLabel(@PathVariable("id") Integer id){
        if(id == 0)
            return null;
        else
            return labelService.queryLabelById(id);
    }

    @PostMapping("label/update")
    public String updateLabel(@RequestParam("labelAddEnt")LabelAddEnt labelAddEnt){
        if(labelService.updatLabel(labelAddEnt))
            return ResponseMessage.SUCCESS_MESSAGE;
        return ResponseMessage.ERROR_MESSAGE;
    }

    @PostMapping("label/delete/{id}")
    public String deleteLabel(@PathVariable("id") Integer id){
        if(labelService.deleteLabelById(id))
            return ResponseMessage.SUCCESS_MESSAGE;
        else
            return ResponseMessage.ERROR_MESSAGE;
    }

    @GetMapping("singer/get/{id}")
    public SingerEnt querySinger(@PathVariable("id") Integer id){
        if(id == 0)
            return null;
        else{
            return singerService.querySingerById(id);
        }

    }

    @GetMapping("singers/{currenPage}")
    public List<SingerEnt> querySingers(@PathVariable("currenPage") Integer currenPage){
        return singerService.querySingers(currenPage,10);
    }

    @PostMapping("singer/update")
    public String updateSingers(@RequestParam("singerEnt") SingerEnt singerEnt){
        if(singerService.updateSinger(singerEnt))
            return ResponseMessage.SUCCESS_MESSAGE;
        return ResponseMessage.ERROR_MESSAGE;
    }

    @PostMapping("singer/delete/{id}")
    public String deleteSinger(@PathVariable("id") Integer id){
        if(singerService.deleteSingerById(id))
            return ResponseMessage.SUCCESS_MESSAGE;
        else
            return ResponseMessage.ERROR_MESSAGE;
    }

    @GetMapping("musics")
    public List<MusicListEnt> queryMusics(@PathParam("currePage") Integer currenPage
            ,@PathParam("pageSize") Integer pageSize){
        List<MusicListEnt> listEnts = musicService.queryMusics(currenPage, pageSize);
        System.out.println(listEnts);
        return listEnts;
    }

    @GetMapping("music/get/{id}")
    public MusicAddEnt getMusic(@PathVariable("id") Integer id){
        if(id == 0)
            return null;
        else {
            return musicService.queryMusicById(id);
        }
    }

    @PostMapping("music/update")
    public String updateMusic(@RequestParam("musicAddEnt") MusicAddEnt musicAddEnt){
        if(musicService.updateMusic(musicAddEnt))
            return ResponseMessage.SUCCESS_MESSAGE;
        return ResponseMessage.ERROR_MESSAGE;
    }

    @PostMapping("music/delete/{id}")
    public String deleteMusic(@PathVariable("id") Integer id){
        if(musicService.deleteMusicById(id))
            return ResponseMessage.SUCCESS_MESSAGE;
        else
            return ResponseMessage.ERROR_MESSAGE;
    }

}
