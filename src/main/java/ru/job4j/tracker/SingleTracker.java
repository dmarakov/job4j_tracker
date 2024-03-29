package ru.job4j.tracker;

import java.util.List;

public class SingleTracker {

    private Store tracker = new MemTracker();
    private static SingleTracker singleTracker = null;

    private SingleTracker() {
    }

    public static SingleTracker getInstance() {
        if (singleTracker == null) {
            singleTracker = new SingleTracker();
        }
        return singleTracker;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findItemById(int id) {
        return tracker.findById(id);
    }

    public List<Item> showAllItem() {
        return tracker.findAll();
    }

    public List<Item> findItemByName(String name) {
        return tracker.findByName(name);
    }

    public boolean deleteItem(int id) {
        return tracker.delete(id);
    }

    public boolean editItem(int id, Item item) {
        return tracker.replace(id, item);
    }

}
