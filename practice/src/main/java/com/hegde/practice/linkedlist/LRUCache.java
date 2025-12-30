package com.hegde.practice.linkedlist;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class LRUCache<K, V> implements Cache<K, V> {
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private static final boolean ACCESS_ORDER = true;
    int capacity;
    private final Map<K, V> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity, DEFAULT_LOAD_FACTOR, ACCESS_ORDER) {
            @Override
            public boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    @Override
    public Optional<V> get(K key) {
        return Optional.of(cache.get(key));
    }

    @Override
    public void put(K key, V value) {
        cache.put(key, value);
    }

    public void print() {
        cache.entrySet().forEach(System.out::println);
    }
}
