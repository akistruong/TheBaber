package com.example.thebaber.Models;

import java.io.Serializable;
import java.util.List;

public class Lookbook implements Serializable {
    String urlBanner;
    String title;
    String dsc;
    List<StyleHair> mStyles;

    public Lookbook(String title, String dsc,String urlBanner, List<StyleHair> mStyles) {
        this.title = title;
        this.dsc = dsc;
        this.mStyles = mStyles;
        this.urlBanner = urlBanner;
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

    public List<StyleHair> getmStyles() {
        return mStyles;
    }

    public void setmStyles(List<StyleHair> mStyles) {
        this.mStyles = mStyles;
    }

    public String getUrlBanner() {
        return urlBanner;
    }

    public void setUrlBanner(String urlBanner) {
        this.urlBanner = urlBanner;
    }
}
