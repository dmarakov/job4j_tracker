package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    private final Map<K, SoftReference<V>> cache = new HashMap<>();

    public final void put(K key, V value) {
        SoftReference<V> softReference = new SoftReference<>(value);
        cache.putIfAbsent(key, softReference);
    }

    public V get(K key) {
        V value = cache.getOrDefault(key, new SoftReference<>(null)).get();
        if (value == null) {
            System.out.println("Кеша нету. Создаю.");
            value = load(key);
            put(key, value);
        }
        return value;
    }

    protected abstract V load(K key);

}