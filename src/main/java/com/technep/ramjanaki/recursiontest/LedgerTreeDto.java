package com.technep.ramjanaki.recursiontest;/*
author: surajgautam
email: teamwarrior200@gmail.com
*/

import java.util.List;

public class LedgerTreeDto {

    private Integer id;

    private String level;

    private List<LedgerTreeDto> children;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LedgerTreeDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<LedgerTreeDto> getChildren() {
        return children;
    }

    public void setChildren(List<LedgerTreeDto> children) {
        this.children = children;
    }
}
