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
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("manager")
@CrossOrigin
public class MusicController {

    @Autowired
    private MusicService musicService;

    @Autowired
    private SingerService singerService;

    @Autowired
    private LabelService labelService;

    @GetMapping("getLabels")
        public List<LabelListEnt>  queryLabels(@RequestParam("currePage") Integer currenPage,@RequestParam("pageSize") Integer pageSize ){
        return labelService.queryLabels(currenPage,pageSize);
    }

    @GetMapping("getLabel/{id}")
    public LabelAddEnt queryLabel(@PathVariable("id") Integer id){
        if(id == 0)
            return null;
        else
            return labelService.queryLabelById(id);
    }

    @PostMapping("updateLabel")
    public String updateLabel(@RequestBody LabelAddEnt labelAddEnt, HttpServletResponse response, HttpServletRequest request){
        ResponseMessage.DEAL_CROSS_DOMAIN(response,request);
        if(labelService.updatLabel(labelAddEnt))
            return ResponseMessage.SUCCESS_MESSAGE;
        return ResponseMessage.ERROR_MESSAGE;
    }

    @DeleteMapping("deleteLabel/{id}")
    public String deleteLabel(@PathVariable("id") Integer id,HttpServletResponse response,HttpServletRequest request){
        ResponseMessage.DEAL_CROSS_DOMAIN(response,request);
        if(labelService.deleteLabelById(id))
            return ResponseMessage.SUCCESS_MESSAGE;
        else
            return ResponseMessage.ERROR_MESSAGE;
    }

    @GetMapping("getSinger/{id}")
    public SingerEnt querySinger(@PathVariable("id") Integer id){
        if(id == 0)
            return null;
        else{
            return singerService.querySingerById(id);
        }

    }

    @GetMapping("getSingers")
    public List<SingerEnt> querySingers(@RequestParam("currenPage") Integer currenPage,@RequestParam("pageSize") Integer pageSize){
        return singerService.querySingers(currenPage,pageSize);
    }

    @PostMapping("updateSinger")
    public String updateSingers(@RequestBody SingerEnt singerEnt){
        if(singerService.updateSinger(singerEnt))
            return ResponseMessage.SUCCESS_MESSAGE;
        return ResponseMessage.ERROR_MESSAGE;
    }

    @DeleteMapping("deleteSinger/{id}")
    public String deleteSinger(@PathVariable("id") Integer id){
        if(singerService.deleteSingerById(id))
            return ResponseMessage.SUCCESS_MESSAGE;
        else
            return ResponseMessage.ERROR_MESSAGE;
    }

    @GetMapping("musics")
    public List<MusicListEnt> queryMusics(@RequestParam("currePage") Integer currenPage,@RequestParam("pageSize") Integer pageSize){

        List<MusicListEnt> listEnts = musicService.queryMusics(currenPage, pageSize);
        return listEnts;
    }

    @GetMapping("music/{id}")
    public MusicAddEnt getMusic(@PathVariable("id") Integer id){
        if(id == 0)
            return null;
        else {
            return musicService.queryMusicById(id);
        }
    }

    @PostMapping("updateMusic")
    public String updateMusic(@RequestBody MusicAddEnt musicAddEnt){
        System.out.println(musicAddEnt);
        if(musicService.updateMusic(musicAddEnt))
            return ResponseMessage.SUCCESS_MESSAGE;
        return ResponseMessage.ERROR_MESSAGE;
    }

    @DeleteMapping("deleteMusic/{id}")
    public String deleteMusic(@PathVariable("id") Integer id,HttpServletRequest request,HttpServletResponse response){
        ResponseMessage.DEAL_CROSS_DOMAIN(response,request);
        if(musicService.deleteMusicById(id))
            return ResponseMessage.SUCCESS_MESSAGE;
        else
            return ResponseMessage.ERROR_MESSAGE;
    }
    @GetMapping("queryMusicsByKey/{key}")
    public List<MusicListEnt> queryMusicsByKey(@PathVariable("key") String key){
        return musicService.queryMusicByKey(key);
    }
}
