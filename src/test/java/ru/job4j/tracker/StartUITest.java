package ru.job4j.tracker;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(new String[]{"0", "new item", "1"});
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(out), new ExitProgram()};
        new StartUI(new StubOutput()).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("new item");
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new test");
        tracker.add(item);
        Input in = new StubInput(new String[]{"0", String.valueOf(item.getId()), "replaced test", "1"});
        Output out = new StubOutput();
        UserAction[] actions = {new EditItem(out), new ExitProgram()};
        new StartUI(new StubOutput()).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo("replaced test");
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new test");
        tracker.add(item);
        Input in = new StubInput(new String[]{"0", String.valueOf(item.getId()), "1"});
        Output out = new StubOutput();
        UserAction[] actions = {new DeleteItem(out), new ExitProgram()};
        new StartUI(new StubOutput()).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }

}