package com.example.demo.controller;

import com.example.demo.entity.SongEntity;
import com.example.demo.sevice.SongService;
import com.example.demo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class SongController {
    @Autowired
    SongService songService;

    @PostMapping("/savesong")
    public Result<String> saveSong(@PathParam("songName")String songName,@PathParam("singer")String singer,@PathParam("description")String description,@PathParam("songUrl")String songUrl){
        Result<String> result = new Result<>(200,"保存成功");
        SongEntity songEntity = new SongEntity(songName,singer,description,songUrl);
        songService.saveSong(songEntity);
        return result;
    }

    @PostMapping("/allsong")
    public Result<List<SongEntity>> getAllSong(){
        Result<List<SongEntity>> result = new Result<>(200,"查询成功");
        result.setData(songService.findAll());
        return result;
    }

    @PostMapping("/namesearch")
    public Result<List<SongEntity>> nameSearch(@PathParam("keyWord")String keyWord){
        Result<List<SongEntity>> result = new Result<>(200,"搜索完成");
//        result.setData(songService.findAllBySongNameOrSinger(keyWord,keyWord));
        result.setData(songService.findAllBySongName(keyWord));
        return result;
    }
    @PostMapping("/singersearch")
    public Result<List<SongEntity>> singerSearch(@PathParam("keyWord")String keyWord){
        Result<List<SongEntity>> result = new Result<>(200,"搜索完成");
//        result.setData(songService.findAllBySongNameOrSinger(keyWord,keyWord));
        result.setData(songService.findAllBySinger(keyWord));
        return result;
    }
}
