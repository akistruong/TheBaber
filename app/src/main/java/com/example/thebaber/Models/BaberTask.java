package com.example.thebaber.Models;

import java.util.Date;

public class BaberTask {
       String CustomerName;
       Date date;
       String Phone;
       boolean isDone = false;
       int reviewStars=0;
       Date timeStamp = new Date();

    public BaberTask(String customerName, Date date, String phone, boolean isDone, int reviewStars) {
        CustomerName = customerName;
        this.date = date;
        Phone = phone;
        this.isDone = isDone;
        this.reviewStars = reviewStars;

    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public int getReviewStars() {
        return reviewStars;
    }

    public void setReviewStars(int reviewStars) {
        this.reviewStars = reviewStars;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
