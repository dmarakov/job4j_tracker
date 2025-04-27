package ru.job4j.lombok;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Category {
    @Getter
    @EqualsAndHashCode.Include
    private final int id;
    @Getter
    @Setter
    private String name;

    public Category(int id) {
        this.id = id;
    }
}