package com.example.musicplayer.model;

public class sareesmodel {

    String image;
    String songName;
    String productPrice;



    public sareesmodel(String image, String songName, String productPrice) {
        this.image = image;
        this.songName = songName;
        this.productPrice = productPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
}
