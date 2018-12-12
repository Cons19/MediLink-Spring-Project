package com.exam.medilink.models;

public class News {
    //title, description
    private int id;
    private String title;
    private String description;

    public News() {

    }

    public News(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return description;
    }

    public void setBody(String body) {
        this.description = description;
    }

}
