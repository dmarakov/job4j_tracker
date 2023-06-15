package ru.job4j.tracker;

import java.util.List;

public class FindItemByName implements UserAction {

    @Override
    public String name() {
        return "Find item by name";
    }

    private final Output out;

    public FindItemByName(Output out) {
        this.out = out;
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Find item by name ===");
        String name = input.askStr("Enter name: ");
        List<Item> items = tracker.findByName(name);
        if (items.size() > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Заявки с введенным name: " + name + " не найдены.");
        }
        return true;
    }
}
