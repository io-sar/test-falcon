package com.falcon.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by bagasas on 25/6/2017.
 */

@Entity
public class Dummy {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private  String name;
    private  String content;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
