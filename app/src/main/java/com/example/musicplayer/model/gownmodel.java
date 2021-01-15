package com.example.musicplayer.model;

public class gownmodel  {
    int tonySongImg;
    String tonySongName;

    public gownmodel(int tonySongImg, String tonySongName) {
        this.tonySongImg = tonySongImg;
        this.tonySongName = tonySongName;
    }

    public int getTonySongImg() {
        return tonySongImg;
    }

    public void setTonySongImg(int tonySongImg) {
        this.tonySongImg = tonySongImg;
    }

    public String getTonySongName() {
        return tonySongName;
    }

    public void setTonySongName(String tonySongName) {
        this.tonySongName = tonySongName;
    }
}
