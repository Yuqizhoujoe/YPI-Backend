package com.ypi.entity;
import javax.persistence.*;

@Entity
@Table(name = "User")

public class User {

    private int UserId;
    private String UserName;
    private String UserPassword;
    private String UserTitle;
    private boolean isAdmin;

    public User(){

    }

    public User(String UserName, String UserPassword, String UserTitle, Boolean isAdmin){
        this.UserName = UserName;
        this.UserPassword = UserPassword;
        this.UserTitle = UserTitle;
        this.isAdmin = isAdmin;
    }

    //getter and setter for UserId
    @Id
    @Column(name = "UserId", unique = true, nullable = false)
    @GeneratedValue(generator = "increment")
    public int getUserId() {return UserId;}

    public void setUserId(int userId) { this.UserId =  userId;}

    // getter and setter for UserName
    @Column(name = "UserName")
    public String getUserName() {return this.UserName;}

    public void setUserName(String username) {this.UserName = username;}

    //getter and setter for UserPassword
    @Column(name = "UserPassword")
    public String getUserPassword() {return this.UserPassword;}

    public void setUserPassword(String userPassword) {this.UserPassword = userPassword;}

    //getter and setter for UserTitle
    @Column(name = "UserTitle")
    public String getUserTitle() {return this.UserTitle;}

    public void setUserTitle(String userTitle) {this.UserTitle = userTitle;}

    //getter and setter for isAdmin
    @Column(name = "isAdmin")
    public Boolean getIsAdmin() {return this.isAdmin;}

    public void setIsAdmin(boolean isAdmin) {this.isAdmin = isAdmin;}

    @Override
    public String toString() {
        return String.format("User{UserId=%1$s, UserName=\'%2$s\'" +
                ", UserPassword=\'%3$s\', UserTitle=\'%4$s\', isAdmin=%5$s}"
                ,UserId,UserName,UserPassword,UserTitle,isAdmin);
    }

}
