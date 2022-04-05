package com.example.thebaber.Models;

public class PostVideo {
    String title;
    String uri;
    String imgUrl;

    public PostVideo(String title, String uri, String imgUrl) {
        this.title = title;
        this.uri = uri;
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
