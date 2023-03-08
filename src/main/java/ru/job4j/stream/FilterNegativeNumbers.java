package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class FilterNegativeNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 5, -10, -1, 3, -8);
        List<Integer> positive = numbers.stream().filter(it -> it > 0).toList();
        positive.forEach(System.out::println);
    }
}