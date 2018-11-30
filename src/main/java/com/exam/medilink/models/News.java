package com.exam.medilink.models;

public class News {
    //title, body
    private final int id;
    private String title;
    private String body;

    public News() {
        this.id = -1;
    }

    public News(int id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getId() {
        return id;
    }

}
