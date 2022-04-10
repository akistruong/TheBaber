package com.example.thebaber.Models;

import androidx.annotation.Nullable;

public class StyleHair {
    String url;
    String title;
    String dsc;
    String UriPost;
    Float price;


    public StyleHair(String url, String title, String dsc,String uriPost,Float price) {
        this.url = url;
        this.title = title;
        this.dsc =dsc;
        this.UriPost = uriPost;
        this.price= price==null?null:price;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }
    public String getUriPost() {
        return UriPost;
    }

    public void setUriPost(String uriPost) {
        UriPost = uriPost;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
