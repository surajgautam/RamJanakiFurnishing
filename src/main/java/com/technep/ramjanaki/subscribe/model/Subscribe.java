package com.technep.ramjanaki.subscribe.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

/**
 * Created by surajgautam on 8/11/17.
 */
@Entity
@Table(name="ecommerce_subscribe")
public class Subscribe {

    @Id@GeneratedValue
    @Column(name="subscribe_ID")
    private Integer sid;


    @Email(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$")
    @NotEmpty
    @Column(name="subscribe_email",unique = true)
    private String email;

    @Column(name="subscribe_status")
    private boolean status;


    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
