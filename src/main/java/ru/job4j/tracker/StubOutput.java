package ru.job4j.tracker;

public class StubOutput implements Output {

    private final StringBuilder buffer = new StringBuilder();

    @Override
    public void println(Object obj) {
        if (obj != null) {
            buffer.append(obj);
        } else {
            buffer.append("null");
        }
        buffer.append(System.lineSeparator());
    }

    public String toString() {
        return buffer.toString();
    }
}