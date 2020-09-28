package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Favorite {
    @Id
    @GeneratedValue
    private int id;
    private int userId;
    private int songId;

    public Favorite(){

    }
    public Favorite(int userId,int songId){
        this.userId = userId;
        this.songId = songId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getSongId() {
        return songId;
    }
}
