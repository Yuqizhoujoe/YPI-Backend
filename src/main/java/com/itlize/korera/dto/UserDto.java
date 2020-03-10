package com.itlize.korera.dto;

import com.itlize.korera.entity.User;

import java.util.Date;

public class UserDto {
    private String username;
    private String password;
    private String title;
    private Date UserRegisterDate;

    public UserDto(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getUserRegisterDate() {
        return UserRegisterDate;
    }

    public void setUserRegisterDate(Date userRegisterDate) {
        UserRegisterDate = userRegisterDate;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", title='" + title + '\'' +
                ", UserRegisterDate=" + UserRegisterDate +
                '}';
    }
}
