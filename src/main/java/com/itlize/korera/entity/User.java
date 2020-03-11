package com.itlize.korera.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {
    private int UserId;
    private String Username;
    private String UserPassword;
    private String UserTitle;
    private Date UserRegisterDate;

    public User(){}
    //UserId
    @Id
    @Column(name = "UserId", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public int getUserId() {return this.UserId;}
    public void setUserId(int userId) {this.UserId = userId;}


    //Username
    @Column(name = "Username", unique = true, nullable = false)

    public String getUsername() { return this.Username;}
    public void setUsername(String username) {this.Username = username;}

    //UserPassword
    @Column(name = "UserPassword", nullable = false)

    public String getUserPassword() {return this.UserPassword;}
    public void setUserPassword(String password) {this.UserPassword = password;}

    //UserTitle
    @Column(name = "UserTitle", nullable = false)

    public String getUserTitle() { return this.UserTitle;}
    public void setUserTitle(String title) {this.UserTitle = title;}

    @Column(name = "UserRegisterDate",nullable = false)
    @CreationTimestamp
    public Date getUserRegisterDate() { return this.UserRegisterDate;}
    public void setUserRegisterDate(Date date) {this.UserRegisterDate = date;}


    @Override
    public String toString() {
        return "User{" +
                ", id=" + UserId +
                ", username='" + Username + '\'' +
                ", password='" + UserPassword + '\'' +
                ", title='" + UserTitle + '\'' +
                ", registerDate='" + UserRegisterDate + '\'' +
                '}';
    }
}
