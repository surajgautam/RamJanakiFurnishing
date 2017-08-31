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
    @Column(name = "ecommerce_username")
    private String userName;

    @Column(name = "ecommerce_password", length = 120000)
    private String password;

    @Column(name = "ecommerce_address")
    private String address;

    @Column(name="ecommerce_mobile_number")
    private String mobileNumber;

    @Column(name="ecommerce_email")
    private String email;


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
}
