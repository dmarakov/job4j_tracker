package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> predicateName = (i) -> i.getName().contains(key);
        Predicate<Person> predicateSurname = (i) -> i.getSurname().contains(key);
        Predicate<Person> predicatePhone = (i) -> i.getPhone().contains(key);
        Predicate<Person> predicateAddress = (i) -> i.getAddress().contains(key);
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
