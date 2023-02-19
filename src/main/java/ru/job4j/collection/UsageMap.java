package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("helloworld@gmail.com", "Ivanov Ivan Ivanovich");
        map.put("test@gmail.com", "Petrov Petr");
        map.put("helloworld@gmail.com", "Nikolaev Nikolay");
        map.put("hellotest@gmail.com", "AlexandrovAlexandr");
        map.put("test@gmail.com", "Stepanov Stepan");
        for (String name : map.keySet()) {
            System.out.println(map.get(name));
        }
    }
}
