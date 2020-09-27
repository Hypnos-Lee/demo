package com.example.demo.sevice;

import com.example.demo.dao.SongDao;
import com.example.demo.entity.SongEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SongService {
    @Resource
    SongDao songDao;
    
    public SongEntity saveSong(SongEntity songEntity){
        return songDao.save(songEntity);
    }

    public List<SongEntity> findAll(){
        return songDao.findAll();
    }

    public List<SongEntity> findAllBySongNameOrSinger(String songName,String singer){
        return songDao.findAllBySongNameOrSinger(songName,singer);
    }
    public List<SongEntity> findAllBySongName(String songName){
        return songDao.findAllBySongName(songName);
    }
    public List<SongEntity> findAllBySinger(String singer){
        return songDao.findAllBySinger(singer);
    }
}
