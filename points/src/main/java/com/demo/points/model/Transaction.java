package com.demo.points.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Transaction {

    private String payer;
    private Integer points;
    private Date timestamp;

    public Transaction(@JsonProperty("payer") String payer,
                       @JsonProperty("points") Integer points,
                       @JsonProperty("timestamp") Date timestamp) {
        this.payer = payer;
        this.points = points;
        this.timestamp = timestamp;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
