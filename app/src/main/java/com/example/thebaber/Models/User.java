package com.example.thebaber.Models;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public class User implements Serializable {
    UrlObj avtUrl;

    public UrlObj getAvtUrl() {
        return avtUrl;
    }

    public void setAvtUrl(UrlObj avtUrl) {
        this.avtUrl = avtUrl;
    }

    String Email;
    String UserName;
    String Phone;
    Boolean isAdmin;
    Boolean isStaff;
    Boolean isUser;
    Date timeStamp;
    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public User(String email, String userName, String phone, Boolean isAdmin, Boolean isStaff, Boolean isUser, Date timeStamp,UrlObj avt) {
        Email = email;
        UserName = userName;
        Phone = phone;
        this.isAdmin = isAdmin;
        this.isStaff = isStaff;
        this.isUser = isUser;
        this.timeStamp = timeStamp;
        this.avtUrl = avt==null?null:avt;
    }



    public User() {
    }



    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Boolean getStaff() {
        return isStaff;
    }

    public void setStaff(Boolean staff) {
        isStaff = staff;
    }

    public Boolean getUser() {
        return isUser;
    }

    public void setUser(Boolean user) {
        isUser = user;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    @NonNull
    @Override
    public String toString() {
        return Email;
    }
}
