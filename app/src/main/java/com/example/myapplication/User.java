package com.example.myapplication;

import com.google.firebase.database.Query;

public class User {
    private String id;
    private String cm;
    private String query;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommend() {
        return cm;
    }

    public void setCommend(String cm) {
        this.cm = cm;
    }

}
