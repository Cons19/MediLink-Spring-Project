package com.exam.medilink.models;

public class User {
    public enum String {
        ADMIN,
        HELPER
    }

    private String password;

    public User(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
