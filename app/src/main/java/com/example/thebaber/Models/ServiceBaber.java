package com.example.thebaber.Models;

public class ServiceBaber {
    String url;
    String title;
    String dsc;

    public ServiceBaber(String url, String title, String dsc) {
        this.url = url;
        this.title = title;
        this.dsc = dsc;
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
}
