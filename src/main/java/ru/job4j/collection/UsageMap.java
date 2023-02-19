package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("helloworld@gmail.com", "Ivanov Ivan Ivanovich");
        for (String name : map.keySet()) {
            System.out.println(map.get(name));
        }
    }
}
