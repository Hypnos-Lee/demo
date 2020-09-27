package com.example.demo.dao;

import com.example.demo.entity.SongEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongDao extends JpaRepository<SongEntity,Integer> {
    List<SongEntity> findAll();
    List<SongEntity> findAllBySongNameOrSinger(String songName,String singer);
    List<SongEntity> findAllBySongName(String songName);
    List<SongEntity> findAllBySinger(String singer);
}
