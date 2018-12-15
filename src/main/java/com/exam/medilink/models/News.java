package com.exam.medilink.models;

import java.io.Serializable;
import java.util.Objects;

public class News implements CrudItem, Serializable {
    //title, description
    private int id;
    private String title;
    private String description;
    private String imgPath;

    public News() {

    }

    public News(int id, String title, String description) {
        this(id, title, description, "");
    }

    public News(int id, String title, String description, String imgPath) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imgPath = imgPath;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return id == news.id &&
                title.equals(news.title) &&
                description.equals(news.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description);
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
