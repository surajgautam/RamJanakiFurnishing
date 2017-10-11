package com.technep.ramjanaki.login.model;/*
author: surajgautam
email: teamwarrior200@gmail.com
*/

import javax.persistence.*;

@Entity
@Table(name = "temp_user")
public class CodeUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;

    private Integer userId;

    private Integer code;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
