package com.an.gamers.Model_Classes;

public class Platform {
    private String Name;
    private Integer Image;

    public Platform(String name, Integer image) {
        Name = name;
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getImage() {
        return Image;
    }

    public void setImage(Integer image) {
        Image = image;
    }
}
