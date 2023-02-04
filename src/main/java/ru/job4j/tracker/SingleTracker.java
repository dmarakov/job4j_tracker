package ru.job4j.tracker;

public class SingleTracker {

    private Tracker tracker = new Tracker();
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

    public Item[] showAllItem() {
        return tracker.findAll();
    }

    public Item[] findItemByName(String name) {
        return tracker.findByName(name);
    }

    public boolean deleteItem(int id) {
        return tracker.delete(id);
    }

    public boolean editItem(int id, Item item) {
        return tracker.replace(id, item);
    }


}
