package ru.job4j.stream;

import java.util.List;

public class ProductLabel {
    public List<String> generateLabels(List<Product> products) {
        return products.stream()
                .filter(it -> it.getStandard() - it.getActual() <= 3 && it.getStandard() - it.getActual() >= 0)
                .map(it -> new Label(it.getName(), (it.getPrice() * 0.5f)).toString())
                .toList();
    }
}