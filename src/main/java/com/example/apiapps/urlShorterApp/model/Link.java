package com.example.apiapps.urlShorterApp.model;

public class Link {

    private String long_url;

    public Link() {
    }

    public Link(String long_url) {
        this.long_url = long_url;
    }

    public String getLong_url() {
        return long_url;
    }

    public void setLong_url(String long_url) {
        this.long_url = long_url;
    }
}
