package com.example.thebaber.Models;

import androidx.annotation.NonNull;

public class User {
    String Email;
    Boolean isAdmin;
    Boolean isStaff;
    Boolean isUser;

    public User() {
    }

    public User(String email, Boolean isAdmin, Boolean isStaff, Boolean isUser) {
        Email = email;
        this.isAdmin = isAdmin;
        this.isStaff = isStaff;
        this.isUser = isUser;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
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

    @NonNull
    @Override
    public String toString() {
        return Email;
    }
}
