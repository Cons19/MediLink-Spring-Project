package com.exam.medilink.models;

import java.io.Serializable;

public class User implements CrudItem, Serializable {

    private int id;
    private String password;

    public User(String password) {
        this.password = password;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
