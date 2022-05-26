package com.example.demo;

import java.util.List;

public class User {
    int id;
    String name;
    List<String> friendList;

    public User(int id, String name)
    {
        this.id=id;
        this.name=name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
