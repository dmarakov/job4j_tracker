package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;

public class UniqueText {
    public boolean isEquals(String originalText, String duplicateText) {
        boolean rsl = true;
        String[] original = originalText.split(" ");
        String[] duplicate = duplicateText.split(" ");
        HashSet<String> set = new HashSet<>(Arrays.asList(original));
        for (String string : duplicate) {
            if (!set.contains(string)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
