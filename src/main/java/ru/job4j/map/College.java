package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {

    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        return Optional.of(students.keySet())
                .stream()
                .flatMap(s -> s.stream().filter(s1 -> s1.account().equals(account)))
                .findFirst();
    }

    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional<Student> a = findByAccount(account);
        if (a.isPresent()) {
            return Optional.of(students.get(a.get()))
                    .stream()
                    .flatMap(s -> s.stream().filter(s1 -> s1.name().equals(name)))
                    .findFirst();
        }
        return Optional.empty();
    }
}
