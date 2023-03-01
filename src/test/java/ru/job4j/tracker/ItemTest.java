package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemTest {
    @Test
    public void whenItemsAscByName() {
        List<Item> items = Arrays.asList(new Item("Bye"), new Item("Hello"), new Item("Allo"));
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(new Item("Allo"), new Item("Bye"), new Item("Hello"));
        assertThat(items).isEqualTo(expected);
    }

    @Test
    public void whenItemsDescByName() {
        List<Item> items = Arrays.asList(new Item("Bye"), new Item("Hello"), new Item("Allo"));
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(new Item("Hello"), new Item("Bye"), new Item("Allo"));
        assertThat(items).isEqualTo(expected);
    }

}