package com.example.student.musicapp;

/**
 * Created by student on 2016-11-11.
 */

public class Music {
    private String title;
    private String artist;
    //private int filename;raw 안에 있을때
    private String filename;


    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getFilename() {
        return filename;
    }
}
