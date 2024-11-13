package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.assertThat;

class FindByIdTest {

    @Test
    void whenItemWasFoundByIdSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("Found item");
        tracker.add(item);
        FindItemById foundItem = new FindItemById(output);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);

        foundItem.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find item by id ===" + ln
                        + item + ln
        );
    }
}