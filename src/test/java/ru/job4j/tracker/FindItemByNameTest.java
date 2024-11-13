package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.assertThat;

class FindItemByNameTest {

    @Test
    void whenItemWasFoundByIdSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("Found item");
        tracker.add(item);
        FindItemByName foundItem = new FindItemByName(output);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn(item.getName());

        foundItem.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find item by name ===" + ln
                        + item + ln
        );
    }
}