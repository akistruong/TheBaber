package com.example.thebaber.Models;

import androidx.annotation.NonNull;

import java.util.Date;

public class User {
    String Email;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public User(String email, String userName, String phone, Boolean isAdmin, Boolean isStaff, Boolean isUser, Date timeStamp) {
        Email = email;
        UserName = userName;
        Phone = phone;
        this.isAdmin = isAdmin;
        this.isStaff = isStaff;
        this.isUser = isUser;
        this.timeStamp = timeStamp;
    }

    String UserName;
    String Phone;
    Boolean isAdmin;
    Boolean isStaff;
    Boolean isUser;
    Date timeStamp;

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
