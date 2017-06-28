package com.falcon.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by bagasas on 28/6/2017.
 */
@Entity
public class OutputMessage {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min=1, max=15, message = "Name must not be empty")
    private String name;

    private String message;

    private String timestamp;

    public OutputMessage(){}

    public OutputMessage(final String name, final String message, final String timestamp) {
        this.name = name;
        this.message = message;
        this.timestamp = timestamp;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public String getTimestamp() {
        return timestamp;
    }

}
