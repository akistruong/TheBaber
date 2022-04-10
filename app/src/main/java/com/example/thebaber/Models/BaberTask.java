package com.example.thebaber.Models;

import java.util.Date;

public class BaberTask {
       String CustomerName;
       String CustomerId;
       String StaffName;

    public String getStaffName() {
        return StaffName;
    }

    public void setStaffName(String staffName) {
        StaffName = staffName;
    }

    public String getStaffId() {
        return StaffId;
    }

    public void setStaffId(String staffId) {
        StaffId = staffId;
    }

    String StaffId;
       Date date;
       String Phone;
       boolean isDone = false;
       int reviewStars=0;
       Date timeStamp = new Date();

    public BaberTask() {
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    public BaberTask(String customerName, Date date, String phone, boolean isDone, int reviewStars,String customerId,String StaffId,String StaffName) {
        CustomerName = customerName;
        this.date = date;
        Phone = phone;
        this.isDone = isDone;
        this.reviewStars = reviewStars;
        this.CustomerId= customerId;
        this.StaffId = StaffId==null?null:StaffId;
        this.StaffName = StaffName==null?null:StaffName;
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
