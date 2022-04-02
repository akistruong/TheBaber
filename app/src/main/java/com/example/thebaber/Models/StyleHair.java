package com.example.thebaber.Models;

public class StyleHair {
    int url;
    String title;

    public StyleHair(int url, String title) {
        this.url = url;
        this.title = title;
    }

    public int getUrl() {
        return url;
    }

    public void setUrl(int url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
