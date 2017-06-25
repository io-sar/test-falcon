package com.falcon.representation;

/**
 * Created by bagasas on 25/6/2017.
 */


public class Dummy {

    private long id;
    private final String name;
    private final String content;

    public Dummy(String name, String content) {

        this.name = name;
        this.content = content;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }
}
