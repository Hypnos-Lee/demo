package com.example.demo.dao;

import com.example.demo.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteDao extends JpaRepository<Favorite,Integer> {
    void deleteByUserIdAndSongId(int userId,int songId);
    Favorite findByUserIdAndSongId(int userId,int songId);
}
