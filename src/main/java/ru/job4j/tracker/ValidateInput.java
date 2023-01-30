package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.askInt(question);
                invalid = false;
            } catch (NumberFormatException e) {
                System.out.println("Please enter valid data");
            }
        } while (invalid);
        return value;
    }
}
