package com.example.thebaber.Models;

public class UrlObj {
    String url;
    String public_id;


    public UrlObj() {
    }

    public UrlObj(String url, String public_id) {
        this.url = url;
        this.public_id = public_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPublic_id() {
        return public_id;
    }

    public void setPublic_id(String public_id) {
        this.public_id = public_id;
    }
}
