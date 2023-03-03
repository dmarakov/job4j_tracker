package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int loopLength = Math.min(left.length(), right.length());
        for (int i = 0; i < loopLength; i++) {
            rsl = Integer.compare(left.charAt(i), right.charAt(i));
            if (rsl != 0) {
                break;
            }
        }
        return rsl == 0 ? Integer.compare(left.length(), right.length()) : rsl;
    }
}