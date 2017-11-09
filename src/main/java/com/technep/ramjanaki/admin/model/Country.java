package com.technep.ramjanaki.admin.model;/*
author: surajgautam
email: teamwarrior200@gmail.com
*/

import javax.persistence.*;

@Entity
@Table
public class Country {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;

    String id;

    String name;

    String href;

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
