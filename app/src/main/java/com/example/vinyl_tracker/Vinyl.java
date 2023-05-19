package com.example.vinyl_tracker;

public class Vinyl {
    private String name;
    private String artist;

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public String getName() {
        return name;
    }

    Vinyl(String name, String artist){
        this.name = name;
        this.artist = artist;
    }
}
