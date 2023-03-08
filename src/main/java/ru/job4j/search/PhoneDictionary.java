package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> predicateName = (i) -> key.equals(i.getName());
        Predicate<Person> predicateSurname = (i) -> key.equals(i.getSurname());
        Predicate<Person> predicatePhone = (i) -> key.equals(i.getPhone());
        Predicate<Person> predicateAddress = (i) -> key.equals(i.getAddress());
        Predicate<Person> combine = predicateName.or(predicateSurname).or(predicatePhone).or(predicateAddress);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
