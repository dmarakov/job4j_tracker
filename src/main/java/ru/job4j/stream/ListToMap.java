package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {

    public static Map<String, Student> convert(List<Student> list) {
        return list.stream().collect(
                Collectors.toMap(Student::getSurname,
                        it -> new Student(it.getScore(), it.getSurname()),
                        (existing, replacement) -> existing)
        );
    }
}