package com.example.demo.sevice;

import com.example.demo.dao.FavoriteDao;
import com.example.demo.entity.Favorite;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class FavoriteService {
    @Resource
    FavoriteDao favoriteDao;

    public String changeFavorite(int userId,int songId){
        String status;
        if(favoriteDao.findByUserIdAndSongId(userId,songId) == null){
            addFavorite(userId,songId);
            status = "add";
        }
        else{
            deletFavorite(userId,songId);
            status = "delete";
        }
        return status;
    }

    public void addFavorite(int userId,int songId){
        Favorite favorite = new Favorite(userId,songId);
        favoriteDao.save(favorite);
    }

    public void deletFavorite(int userId,int songId){
        favoriteDao.deleteByUserIdAndSongId(userId,songId);
    }

}
