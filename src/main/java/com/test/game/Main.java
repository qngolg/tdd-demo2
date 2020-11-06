package com.test.game;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setName("qgl");
        user.setAge("18");
        user.setCountry("china");
        user.setProvince("shanxi");
        user.setCity("xian");
        user.setCommunity("环普");

        Class<? extends User> aClass = user.getClass();
        Field[] fields = aClass.getDeclaredFields();
        Arrays.stream(fields).distinct()
                .forEach(field -> {
                    try {
                        field.setAccessible(true);
                        System.out.println(field.getName() + " "+ field.get(user));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
    }
}
