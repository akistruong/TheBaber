package com.example.thebaber.Models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class BaberTask implements Serializable {
        String _id;
        String CustomerName;
        String CustomerId;
        String StaffName;
        String StaffId;
        Date date;
        String Phone;
        boolean isDone = false;
        int reviewStars=0;
        Date timeStamp = new Date();
        List<ServiceBaber> serviceBaberList;
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



    public BaberTask() {
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    public BaberTask(String _id,String customerName, Date date, String phone, boolean isDone, int reviewStars,String customerId,String StaffId,String StaffName,List<ServiceBaber> serviceBaberList) {
        this._id = _id==null?null:_id;
        CustomerName = customerName;
        this.date = date;
        this.Phone = phone;
        this.isDone = isDone;
        this.reviewStars = reviewStars;
        this.CustomerId= customerId;
        this.StaffId = StaffId==null?null:StaffId;
        this.StaffName = StaffName==null?null:StaffName;
        this.serviceBaberList = serviceBaberList==null?null:serviceBaberList;
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

    public List<ServiceBaber> getServiceBaberList() {
        return serviceBaberList;
    }

    public void setServiceBaberList(List<ServiceBaber> serviceBaberList) {
        this.serviceBaberList = serviceBaberList;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}
