package ru.job4j.tracker;

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
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find item by name ===");
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            out.println("Заявки с введенным name: " + name + " не найдены.");
        }
        return true;
    }
}
