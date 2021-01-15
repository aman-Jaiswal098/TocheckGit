package com.example.musicplayer.model;

public class salwarsuitsmodel {

    Integer img;
    String SongName;

    public salwarsuitsmodel(Integer img, String songName) {
        this.img = img;
        SongName = songName;
    }

    public Integer getImg() {
        return img;
    }

    public void setImg(Integer img) {
        this.img = img;
    }

    public String getSongName() {
        return SongName;
    }

    public void setSongName(String songName) {
        SongName = songName;
    }
}
