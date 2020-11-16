package com.test.game;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class TestMain {

    public static void main(String[] args) {
        User user =new User();
        user.setName("qgl");
        Gson gson = new Gson();
        String path = "a.json";
        try {
            gson.toJson(user,new FileWriter(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
