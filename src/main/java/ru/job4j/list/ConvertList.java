package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> rsl = new ArrayList<>();
        for (int[] number : list) {
            for (int number1 : number) {
                rsl.add(number1);
            }
        }
        return rsl;
    }
}