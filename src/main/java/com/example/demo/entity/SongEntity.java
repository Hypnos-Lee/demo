package com.example.demo.entity;

import jdk.nashorn.internal.objects.annotations.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "song_info")
public class SongEntity {
    @Id
    @GeneratedValue
    private int songId;
    private String songName;
    private String singer;
    private String description;
    private String songUrl;

    public SongEntity() { }

    public SongEntity(String songName,String singer,String description,String url){
        this.songName = songName;
        this.singer = singer;
        this.description = description;
        this.songUrl = url;
    }



    public void setSongName(String songName) {
        this.songName = songName;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSongUrl(String url) {
        this.songUrl = url;
    }

    public int getSongId() {
        return songId;
    }

    public String getSongName() {
        return songName;
    }

    public String getSinger() {
        return singer;
    }

    public String getDescription() {
        return description;
    }

    public String getSongUrl() {
        return songUrl;
    }
}
