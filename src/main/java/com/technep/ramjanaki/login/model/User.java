package com.technep.ramjanaki.login.model;

import javax.persistence.*;

/**
 * Created by surajgautam on 6/24/17.
 */

@Entity
@Table(name = "ecommerce_user")
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int uid;
    @Column(name="username")
    private String userName;

    @Column(name = "password",length = 120000)
    private String password;

    @Column(name = "address")
    private String address;

    @Column(name="mobileNumber")
    private String mobileNumber;

    @Column(name="email")
    private String email;

    @Column(name="role")
    private String role;

    @Column(name="enabled")
    private boolean status;


    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
