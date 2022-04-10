package com.example.thebaber.Models;

public class ServiceBaber {
    String url;
    String title;
    String dsc;
    Float price;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ServiceBaber(String url, String title, String dsc,Float Price) {
        this.url = url;
        this.title = title;
        this.dsc = dsc;
        this.price = price==null?null:price;
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
