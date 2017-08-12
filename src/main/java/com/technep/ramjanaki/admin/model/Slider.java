package com.technep.ramjanaki.admin.model;

import javax.persistence.*;

/**
 * Created by surajgautam on 8/11/17.
 */
@Entity
@Table(name="ecommerce_slider")
public class Slider {

    @Id@GeneratedValue
    @Column(name="slider_ID")
    private Integer sid;

    @Column(name="slider_image")
    private String imageUrl;

    @Column(name="slider_position")
    private Integer position;


    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}
